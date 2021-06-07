package controllers;

import app.App;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;


public class WinController {

    public Text whoWon;
    public AnchorPane winBg;
    public Text reasonText;
    GameController gameController;

    public void initialize() {
        if (GameController.move_counter % 2 == 1) {
            whoWon.setText("Biały wygrał!");

        } else {
            whoWon.setText("Czarny wygrał!");
        }
    }

    public void setReasonText(String str) {
        reasonText.setText(str);

    }

    public void back(ActionEvent actionEvent) {
          // Platform.exit();
//        App.changeScene(gameController.gameAnchorPane, "mainWindow");

    }
}
