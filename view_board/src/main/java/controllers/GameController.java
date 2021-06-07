package controllers;

import Piece.Move;
import Piece.Piece;
import Piece.PieceColor;
import app.App;
import code.CheckerBoard;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import player.manager.LoginManager;

import java.io.File;
import java.io.IOException;
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

    public Text whoWon;
    public HBox reasonWin;
    public AnchorPane winBg;

    public static ThreadStopwatch wts = new ThreadStopwatch();
    public static ThreadStopwatch bts = new ThreadStopwatch();
    public ImageView coverImageView;



    //public static ThreadStopwatch nts = new ThreadStopwatch();

    ImageView temp;
    HBox tempHb;
    CheckerBoard cb = new CheckerBoard();
    static int move_counter = 0;
    int oldX;
    int oldY;
    int newX;
    int newY;
    public boolean isWon = false;
    public void initialize() {
        move_counter = 0;
        if(LoginManager.getLoggedUser()!=null) {
            username.setText(LoginManager.getLoggedUser().getName());
            File imageFile = new File("assets/cover/"+ LoginManager.getLoggedUser().getLogin() +".jpg");
            Image image = new Image(imageFile.toURI().toString());
            coverImageView.setImage(image);
        }
        cb.initBoard();
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
                wts.setGameController(this);
                bts.setLabel(sPlayerLabel);
                bts.setGameController(this);

            }
        }

                addGridEvent();

    }
    private void addGridEvent() {
        chessboardGridPane.getChildren().forEach(item -> {
           item.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (event.getClickCount() == 1 && !isWon) {
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
                        //drawEllipse(hb);
                        newX = rowIndex;
                        newY = colIndex;
                        isHighlighted = false;
                        //przenoszenie pionka w inne miejsce
                        if(tempHb != null) {
                            System.out.println("old: " + oldX + " " + oldY + ", new: " + newX + " " + newY);
                            if (move_counter % 2 == 0) {
                                if(cb.getPs().move(new Move(oldY, oldX, newY, newX))) {
                                    moveFigure(hb, cb.getPiece(oldY, oldX).getPieceColor());
                                }
                            } else {
                               if(cb.getPsb().move(new Move(oldY, oldX, newY, newX))) {
                                   moveFigure(hb, cb.getPiece(oldY, oldX).getPieceColor());
                               }
                            }
                        }
                        //sprawdzenie czy kliknięte pole ma w sobie figure i podkreślenie jej
                        if(!hb.getChildren().isEmpty() && !isHighlighted) {
                            Piece piece = cb.getPiece(newY, newX);
                            if(move_counter %2 == 0 && cb.getPiece(newY, newX).getPieceColor() == PieceColor.WHITE) {
                                glowUp(hb);
                            }
                            else if (move_counter%2 == 1 && cb.getPiece(newY, newX).getPieceColor() == PieceColor.BLACK) {
                                glowUp(hb);
                            }
                            tempHb = hb;
                            oldX = newX;
                            oldY = newY;
                            temp = (ImageView) hb.getChildren().get(0);
                            isHighlighted = true;
                        }
                    }
                }
            });
        });
    }
    public void glowUp(HBox hb) {
        hb.setBorder(new Border(new BorderStroke(Color.YELLOW,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(4))));
    }
    public void moveFigure(HBox hb, PieceColor pc) {

            if (tempHb.getChildren().get(0) == temp && cb.getPiece(oldY, oldX).getPieceColor() == pc ) {
                if (hb.getChildren().isEmpty()) {

                    hb.setBorder(new Border(new BorderStroke(Color.YELLOW,
                            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(0))));
                    tempHb.getChildren().clear();
                    hb.getChildren().add(temp);
                    tempHb = null;
                    isHighlighted = true;
                    cb.movePiece(cb.getPiece(oldY,oldX),newY,newX);
                    move_counter++;
                }
                else if(!hb.getChildren().isEmpty()) {
                    if(cb.getPiece(newY, newX).getPieceColor() == PieceColor.WHITE) {
                        if(cb.getPiece(oldY, oldX).getPieceColor() == PieceColor.BLACK) {

                            hb.getChildren().clear();
                            hb.getChildren().add(temp);
                            cb.movePiece(cb.getPiece(oldY,oldX),newY,newX);
                            move_counter++;
                        }
                    }
                    else if(cb.getPiece(newY, newX).getPieceColor() == PieceColor.BLACK) {
                        if(cb.getPiece(oldY, oldX).getPieceColor() == PieceColor.WHITE) {
                            hb.getChildren().clear();
                            hb.getChildren().add(temp);
                            cb.movePiece(cb.getPiece(oldY,oldX),newY,newX);
                            move_counter++;
                        }
                    }
                }
                if(move_counter %2 == 0) {
                    wts.setYes();
                    bts.setNot();
                }
                else {
                    bts.setYes();
                    wts.setNot();
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
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Give Up");
            alert.setHeaderText("Czy na pewno chcesz się poddać?");
            //alert.setContentText("Czy napewno chcesz się poddać?");
            //alert.setGraphic(new ImageView(new Image("/images/icon.png")));
            ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/images/icon.png"));
            ButtonType okButton = new ButtonType("Tak", ButtonBar.ButtonData.YES);
            ButtonType noButton = new ButtonType("Nie", ButtonBar.ButtonData.NO);
            alert.getButtonTypes().setAll(okButton, noButton);
            alert.showAndWait().ifPresent(type -> {
                if (type == okButton) {
                    try{
                        if(LoginManager.getLoggedUser() != null) {
                            if(move_counter %2 == 1) {
                                LoginManager.getLoggedUser().getStatistic().setCheckMate(LoginManager.getLoggedUser().getStatistic().getCheckMate() + 1);
                            }
                            else {
                                LoginManager.getLoggedUser().getStatistic().setLoses(LoginManager.getLoggedUser().getStatistic().getLoses() + 1);
                            }
                            LoginManager.updateLoggedUser();
                        }
                        App.changeScene(gameAnchorPane, "mainWindow");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    alert.close();
                }
            });
        }

    public void drawEllipse(HBox hb) {
        if(hb.getChildren().isEmpty()) {
            Circle circle = new Circle(20, Paint.valueOf("grey"));
            circle.setId("circle");
            hb.getChildren().add(circle);
        }
    }
    public void winOpen() throws IOException {
        isWon = true;
        Stage stage = new Stage();
        stage.getIcons().add(new Image("/images/cr.jpg"));
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane root = fxmlLoader.load(GameController.class.getResource("/fxml/winWindow.fxml").openStream());
        root.getStylesheets().add(getClass().getResource("/style/menustyl.css").toExternalForm());
        //stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(new Scene(root));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(gameAnchorPane.getScene().getWindow());
        stage.setResizable(false);
        stage.setTitle("Win");
        stage.showAndWait();

    }

}
