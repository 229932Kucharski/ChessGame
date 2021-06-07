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

    public void initialize() {
        User user = LoginManager.getLoggedUser();
        ObservableList<FiguresStyle> figures = FXCollections.observableArrayList(FiguresStyle.values());
        figuresChoiceBox.setItems(figures);
        figuresChoiceBox.setValue(user.getPieceDesign());

        ObservableList<ChessboardStyle> cbs = FXCollections.observableArrayList(ChessboardStyle.values());
        chessboardChoiceBox.setItems(cbs);
        chessboardChoiceBox.setValue(user.getBoardDesign());

        figuresChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {

               if (t1.equals(0)) {
                    //figuresStyle = "classic";
                   StyleManager.setFiguresStyle(FiguresStyle.classic);
                    Image image = new Image("/images/classic/queen.png");
                    figureImage.setImage(image);
                }

                else if (t1.equals(1)) {
                  // figuresStyle = "wooden";
                   StyleManager.setFiguresStyle(FiguresStyle.wooden);
                    Image image = new Image("/images/wooden/queen.png");
                    figureImage.setImage(image);
                }
                LoginManager.updateLoggedUser();
            }
            }
        );

        chessboardChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
               @Override
               public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {

                   if (t1.equals(0)) {
                       Image image = new Image("/images/classicChess.jpg");
                       chessImage.setImage(image);
                       StyleManager.setBoardColor(ChessboardStyle.classic);
                   }
                   else if (t1.equals(1)) {
                       Image image = new Image("/images/woodenChess.jpg");
                       chessImage.setImage(image);
                       StyleManager.setBoardColor(ChessboardStyle.wooden);
                   }
                   else if (t1.equals(2)) {
                       Image image = new Image("/images/marbleChess.jpg");
                       chessImage.setImage(image);
                       StyleManager.setBoardColor(ChessboardStyle.marble);
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


