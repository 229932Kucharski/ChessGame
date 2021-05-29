package controllers;

import app.App;
import player.User;
import player.enums.ChessboardStyle;
import player.enums.FiguresStyle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import player.manager.LoginManager;


public class StyleController {
    public ChoiceBox<FiguresStyle> figuresChoiceBox;
    public ChoiceBox<ChessboardStyle> chessboardChoiceBox;
    public ImageView figureImage;
    public ImageView chessImage;
    public AnchorPane styleAnchorPane;
    public static String colorBoard = "rgba(50,50,50)";

    public void initialize() {
        ObservableList<FiguresStyle> figures = FXCollections.observableArrayList(FiguresStyle.values());
        figuresChoiceBox.setItems(figures);
        figuresChoiceBox.setValue(FiguresStyle.menu);

        ObservableList<ChessboardStyle> cbs = FXCollections.observableArrayList(ChessboardStyle.values());
        chessboardChoiceBox.setItems(cbs);
        User user = LoginManager.getLoggedUser();
        chessboardChoiceBox.setValue(user.getBoardDesign());

        figuresChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {

               if (t1.equals(1)) {
                    Image image = new Image("/images/queen.png");
                    figureImage.setImage(image);
                }
                else if (t1.equals(2)) {
                    Image image = new Image("/images/woodenTemp.jpg");
                    figureImage.setImage(image);
                }
                else if (t1.equals(3)) {
                    Image image = new Image("/images/marbleTemp.jpg");
                    figureImage.setImage(image);
                }
            }
            }
        );
        chessboardChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
               @Override
               public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {

                   if (t1.equals(1)) {
                       Image image = new Image("/images/classicChess.jpg");
                       chessImage.setImage(image);
                       colorBoard = "rgba(50,50,50)";
                       LoginManager.getLoggedUser().setBoardDesign(ChessboardStyle.classic);
                   }
                   else if (t1.equals(2)) {
                       Image image = new Image("/images/woodenChess.jpg");
                       chessImage.setImage(image);
                       colorBoard = "rgba(120,50,35)";
                       LoginManager.getLoggedUser().setBoardDesign(ChessboardStyle.wooden);
                   }
                   else if (t1.equals(3)) {
                       Image image = new Image("/images/marbleChess.jpg");
                       chessImage.setImage(image);
                       colorBoard = "rgba(128,128,128)";
                       LoginManager.getLoggedUser().setBoardDesign(ChessboardStyle.marble);

                   }
                   LoginManager.updateLoggedUser();

               }
           }
        );

}

    public void back(ActionEvent actionEvent) {
        App.changeScene(styleAnchorPane, "profileWindow");
    }
}


