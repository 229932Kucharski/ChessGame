package controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class WinController {

    public Text whoWon;
    public AnchorPane winBg;
    public Text reasonText;
    public Button closeButton;
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

    public void back(ActionEvent actionEvent){
        // get a handle to the stage
        Stage stage = (Stage) closeButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}
