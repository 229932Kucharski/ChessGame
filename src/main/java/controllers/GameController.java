package controllers;

import app.App;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.*;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;


public class GameController {
    private static List<HBox> hBoxList = new ArrayList<>();
    public AnchorPane gameAnchorPane;
    public boolean isHighlighted;
    public GridPane chessboardGridPane;

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                HBox hb = new HBox();
                if((i+j)%2 != 0) {
                    hb.setId("black");
                    hb.setStyle("-fx-background-color: " + StyleController.colorBoard);
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
                        Node source = (Node) event.getSource();
                        Integer colIndex = GridPane.getColumnIndex(source);
                        Integer rowIndex = GridPane.getRowIndex(source);
                        if(colIndex == null) {
                            colIndex = 0;
                        }
                        if(rowIndex == null) {
                            rowIndex = 0;
                        }
                        System.out.printf("Mouse entered cell [%d, %d]%n", colIndex, rowIndex);
                        HBox hb = (HBox) getNodeByXY(chessboardGridPane, rowIndex, colIndex);
                        if(!hb.getChildren().isEmpty())
                        hb.setBorder(new Border(new BorderStroke(Color.YELLOW,
                                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(4))));
                        System.out.println(hb);
                    }
                }
            });
        });
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

}
