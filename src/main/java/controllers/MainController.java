package controllers;

import app.App;
import enums.GameMode;
import enums.Pace;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainController {
    public AnchorPane mainAnchorPane;
    public ChoiceBox<Pace> paceChoiceBox;
    public ChoiceBox<GameMode> modeChoiceBox;

    public void initialize() {
        //choice box do rodzaju gry
        ObservableList<GameMode> mode = FXCollections.observableArrayList(GameMode.values());
        modeChoiceBox.setItems(mode);
        modeChoiceBox.setValue(GameMode.GraczGracz);

        //choice box do tempa gry
        ObservableList<Pace> pace = FXCollections.observableArrayList(Pace.values());
        paceChoiceBox.setItems(pace);
        paceChoiceBox.setValue(Pace.menu);


    }

    public void logIn(ActionEvent actionEvent) {
        App.changeScene(mainAnchorPane,"loginWindow");
    }

    public void showProfile(ActionEvent actionEvent) throws IOException {
        App.changeScene(mainAnchorPane,"profileWindow");
    }

    public void closeApp(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void newGame(ActionEvent actionEvent) throws IOException {
        App.changeScene(mainAnchorPane,"gameWindow");
    }
}
