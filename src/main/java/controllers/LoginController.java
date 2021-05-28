package controllers;

import app.App;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;

public class LoginController {
    public AnchorPane loginAnchorPane;

    public void logIn(ActionEvent actionEvent) {
    }

    public void back(ActionEvent actionEvent) {
        App.changeScene(loginAnchorPane,"mainWindow");
    }

    public void signUp(ActionEvent actionEvent) {
        App.changeScene(loginAnchorPane,"signUpWindow");
    }
}
