package controllers;

import app.App;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;

public class SignUpController {
    public AnchorPane signUpAnchorPane;

    public void back(ActionEvent actionEvent) {
        App.changeScene(signUpAnchorPane,"loginWindow");
    }
}
