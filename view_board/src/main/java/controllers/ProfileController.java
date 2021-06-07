package controllers;

import app.App;
import code.Statistic;
import javafx.event.ActionEvent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import player.User;
import player.manager.LoginManager;

import java.io.File;
import java.io.IOException;

public class ProfileController {
    final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
    public BarChart<?, ?> chart = new BarChart<>(xAxis, yAxis);;
    public AnchorPane profileAnchorPane;
    public Text username;
    public ImageView coverImageView;

    public void initialize() {
        username.setText(LoginManager.getLoggedUser().getName());
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("2003");

        int loses = LoginManager.getLoggedUser().getStatistic().getLoses();
        int wins = LoginManager.getLoggedUser().getStatistic().getCheckMate();
        int draws = LoginManager.getLoggedUser().getStatistic().getStaleMate();

        final XYChart.Data<String, Number> dataPrzegr = new XYChart.Data("Przegrane", loses);
        final XYChart.Data<String, Number> dataRem = new XYChart.Data("Remisy", draws);
        final XYChart.Data<String, Number> dataWygr = new XYChart.Data("Wygrane", wins);
        series1.getData().add(dataPrzegr);
        series1.getData().add(dataRem);
        series1.getData().add(dataWygr);
        chart.getData().addAll(series1);

        chart.setStyle("-fx-background-color: rgba(255,255,255,0.6);" +
                " -fx-font-size: 16; -fx-font-family: 'Times New Roman';" +
                " -fx-text-fill: white; -fx-background-size: 200px ,500px");

        dataPrzegr.getNode().setStyle("-fx-bar-fill: CHART_COLOR_1;");
        dataRem.getNode().setStyle("-fx-bar-fill: CHART_COLOR_2;");
        dataWygr.getNode().setStyle("-fx-bar-fill: CHART_COLOR_3;");

        byte[] cover = LoginManager.getLoggedUser().getCover();
        if(cover == null) {
            coverImageView.setImage(new Image("/images/avatar.png"));
        } else {
            try {
                ImageManager.byteArrayToImage(LoginManager.getLoggedUser().getLogin(), cover);
                setCover();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void changeCover() {
        byte[] cover = null;
        try{
            cover = ImageManager.chooseCoverFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(cover == null) {
            return;
        }
        setCover();
        LoginManager.getLoggedUser().setCover(cover);
        LoginManager.updateLoggedUser();
    }

    private void setCover() {
        File imageFile = new File("assets/cover/"+ LoginManager.getLoggedUser().getLogin() +".jpg");
        Image image = new Image(imageFile.toURI().toString());
        coverImageView.setImage(image);
    }

    public void changeStyle() {
        App.changeScene(profileAnchorPane,"styleWindow");
    }

    public void back() {
        App.changeScene(profileAnchorPane,"mainWindow");
    }

}
