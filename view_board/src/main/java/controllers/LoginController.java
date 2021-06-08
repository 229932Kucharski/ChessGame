package controllers;

import app.App;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import player.manager.LoginManager;

import java.sql.SQLException;


public class LoginController {
    public AnchorPane loginAnchorPane;
    public TextField loginTextField;
    public PasswordField passwordTextField;
    public Label warningLabel;

    public void logIn() {
        if(!checkForm()) {
            return;
        }
        String login = loginTextField.getText();
        String password = passwordTextField.getText();

        try {
            LoginManager.login(login, password);
        } catch (IllegalArgumentException e) {
            setWarning("Nieprawidlowy login lub haslo");
            return;
        } catch (SQLException e) {
            setWarning("Nie udalo sie zalogowac");
            return;
        }
        StyleManager.setBoardColor(LoginManager.getLoggedUser().getBoardDesign());
        StyleManager.setFiguresStyle(LoginManager.getLoggedUser().getPieceDesign());
        App.changeScene(loginAnchorPane, "mainWindow");
    }

    private boolean checkForm() {
        String login = loginTextField.getText();
        String password = passwordTextField.getText();

        if(login.equals("") || password.equals("")) {
            setWarning("Pola nie moga byc puste");
            return false;
        }
        return true;
    }

    private void setWarning(String message) {
        warningLabel.setText(message);
        warningLabel.setStyle("-fx-text-fill: red");
    }

    public void back() {
        App.changeScene(loginAnchorPane,"mainWindow");
    }

    public void signUp() {
        App.changeScene(loginAnchorPane,"signUpWindow");
    }

}
