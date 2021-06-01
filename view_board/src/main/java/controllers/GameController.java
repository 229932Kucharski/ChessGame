package controllers;

import app.App;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import player.manager.LoginManager;

import java.util.ArrayList;
import java.util.List;


public class GameController extends GridPane{
    private static List<HBox> hBoxList = new ArrayList<>();
    public AnchorPane gameAnchorPane;
    public boolean isHighlighted;
    public GridPane chessboardGridPane;
    public Text username;
    public Label sPlayerLabel;
    public Label fPlayerLabel;

    public static ThreadStopwatch wts = new ThreadStopwatch();
    public static ThreadStopwatch bts = new ThreadStopwatch();


    ImageView temp;
    HBox tempHb;
    HBox temp2Hb;
    boolean beat;
    int move_counter = 0;
    public void initialize() {
        if(LoginManager.getLoggedUser()!=null) {
            username.setText(LoginManager.getLoggedUser().getName());
        }
        //inicjalizacja hboxów na planszy
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                HBox hb = new HBox();
                if((i+j)%2 != 0) {
                    hb.setId("black");
                    hb.setStyle("-fx-background-color: " + StyleManager.getColorBoard());
                }
                else {
                    hb.setId("white");
                    hb.setStyle("-fx-background-color: rgba(255,255,255,0.9)");
                }
                hb.setMinSize(38, 38);
                hb.setAlignment(Pos.CENTER);
                //odwrocono kolejnosc bo gridpane zamienia wiersze z kolumnami
                SetPiecesOnBoard.setPieces(hb,j,i);

                hBoxList.add(hb);
                chessboardGridPane.add(hb, i, j);

                wts.setLabel(fPlayerLabel);
                bts.setLabel(sPlayerLabel);
            }
        }
            addGridEvent();
    }
    private void addGridEvent() {
        chessboardGridPane.getChildren().forEach(item -> {
           item.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (event.getClickCount() == 1) {

                        clearHBox();
                        //pobranie źródła z gridpane (x,y)
                        Node source = (Node) event.getSource();
                        Integer colIndex = GridPane.getColumnIndex(source);
                        Integer rowIndex = GridPane.getRowIndex(source);
                        if(colIndex == null) {
                            colIndex = 0;
                        }
                        if(rowIndex == null) {
                            rowIndex = 0;
                        }
//                        System.out.printf("Mouse entered cell [%d, %d]%n", colIndex, rowIndex);
                        //pobranie hboxa z gridpane
                        HBox hb = (HBox) getNodeByXY(chessboardGridPane, rowIndex, colIndex);
                        isHighlighted = false;
                        //przenoszenie pionka w inne miejsce
                        if(move_counter %2 == 0)
                            moveFigure(hb,"whiteImage");

                        else
                            moveFigure(hb,"blackImage");

                        //sprawdzenie czy kliknięte pole ma w sobie figure i podkreślenie jej
                        if(!hb.getChildren().isEmpty() && !isHighlighted) {
                            hb.setBorder(new Border(new BorderStroke(Color.YELLOW,
                                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(4))));
                            temp2Hb = tempHb;
                            tempHb = hb;
                            temp = (ImageView) hb.getChildren().get(0);
                            isHighlighted = true;
                        }
                    }
                }
            });
        });
    }
    public void moveFigure(HBox hb, String color) {
        if(tempHb != null) {
            if (tempHb.getChildren().get(0) == temp && temp.getId().equals(color)) {
                if (hb.getChildren().isEmpty()) {
                    hb.setBorder(new Border(new BorderStroke(Color.YELLOW,
                            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(0))));
                    tempHb.getChildren().clear();
                    hb.getChildren().add(temp);
                    tempHb = null;
                    isHighlighted = true;
                }
                    else if(!hb.getChildren().isEmpty()) {
                        if(hb.getChildren().get(0).getId().equals("whiteImage")) {
                            if(tempHb.getChildren().get(0).getId().equals("blackImage")) {
                                hb.getChildren().clear();
                                hb.getChildren().add(temp);
                            }
                        }
                        else if(hb.getChildren().get(0).getId().equals("blackImage")) {
                            if(tempHb.getChildren().get(0).getId().equals("whiteImage")) {
                                hb.getChildren().clear();
                                hb.getChildren().add(temp);
                            }
                        }
                    }
                move_counter++;
                System.out.println(move_counter);
            }
        }
    }

    public void clearHBox() {
        for (HBox hbox : hBoxList) {
            hbox.setBorder(new Border(new BorderStroke(Color.YELLOW,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(0))));
        }
    }
    public Node getNodeByXY(GridPane gp, int x, int y) {
        Node result = null;
        ObservableList<Node> children = gp.getChildren();
        for (Node node : children) {

            Integer row = GridPane.getRowIndex(node);
            Integer column = GridPane.getColumnIndex(node);
            if(row == null) {
                row = 0;
            }
            if(column == null) {
                column = 0;
            }
            if(row == x && column == y) {
                result = node;
                break;
            }
        }
        return result;
    }

    public void back(ActionEvent actionEvent) {
        App.changeScene(gameAnchorPane,"mainWindow");
    }
    public static List<HBox> gethBoxList() {
        return hBoxList;
    }

    public void giveUp(ActionEvent actionEvent) {
        if(LoginManager.getLoggedUser() != null) {
            LoginManager.getLoggedUser().getStatistic().setLoses(LoginManager.getLoggedUser().getStatistic().getLoses() + 1);
            LoginManager.updateLoggedUser();
        }
        App.changeScene(gameAnchorPane, "mainWindow");
    }
}
