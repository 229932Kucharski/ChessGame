package controllers;

import app.App;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import player.exception.PasswordException;
import player.manager.RegistrationManager;
import java.sql.SQLException;

public class SignUpController {
    public AnchorPane signUpAnchorPane;
    public TextField loginTextField;
    public PasswordField passwordTextField;
    public TextField nickTextField;
    public Label warningLabel;

    public void signUp() {
        if(!checkForm()) {
            return;
        }
        String login = loginTextField.getText();
        String password = passwordTextField.getText();
        String nick = nickTextField.getText();

        try {
            RegistrationManager.registerUser(nick, login, password);
        } catch (PasswordException e) {
            setWarning("Haslo jest za krotkie");
            return;
        } catch (IllegalArgumentException e) {
            setWarning("Login jest juz zajety");
            return;
        } catch (SQLException e) {
            setWarning("Nie udalo sie stworzyc uzytkownika");
            return;
        }

        App.changeScene(signUpAnchorPane, "loginWindow");

    }

    private boolean checkForm() {
        String login = loginTextField.getText();
        String password = passwordTextField.getText();
        String nick = nickTextField.getText();

        if(login.equals("") || password.equals("") || nick.equals("")) {
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
        App.changeScene(signUpAnchorPane,"loginWindow");
    }

}
