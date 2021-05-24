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

    public void setPace(ActionEvent actionEvent) {
        Stopwatch whitewatch = new Stopwatch();
        Stopwatch blackwatch = new Stopwatch();
        if(paceChoiceBox.getValue().getPace().equals("bullet 1 | 0")){
            whitewatch.setTime(1);
            whitewatch.setIncrement(0);
            blackwatch.setTime(1);
            blackwatch.setIncrement(0);
        }else if (paceChoiceBox.getValue().getPace().equals("bullet 1 | 1")){
            whitewatch.setTime(1);
            whitewatch.setIncrement(1);
            blackwatch.setTime(1);
            blackwatch.setIncrement(1);
        }else if (paceChoiceBox.getValue().getPace().equals("blitz 3 | 0")){
            whitewatch.setTime(3);
            whitewatch.setIncrement(0);
            blackwatch.setTime(3);
            blackwatch.setIncrement(0);
        }else if (paceChoiceBox.getValue().getPace().equals("blitz 5 | 0")){
            whitewatch.setTime(5);
            whitewatch.setIncrement(0);
            blackwatch.setTime(5);
            blackwatch.setIncrement(0);
        }else if (paceChoiceBox.getValue().getPace().equals("blitz 5 | 5")){
            whitewatch.setTime(5);
            whitewatch.setIncrement(5);
            blackwatch.setTime(5);
            blackwatch.setIncrement(5);
        }else if (paceChoiceBox.getValue().getPace().equals("szybkie 10 | 0")){
            whitewatch.setTime(10);
            whitewatch.setIncrement(0);
            blackwatch.setTime(10);
            blackwatch.setIncrement(0);
        }

    }
}
