package controllers;

import app.App;
import code.Statistic;
import javafx.event.ActionEvent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;

public class ProfileController {
    final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
    public BarChart<?, ?> chart = new BarChart<>(xAxis, yAxis);;
    public AnchorPane profileAnchorPane;

    public void initialize() {

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("2003");

        Statistic st = new Statistic(3,4,5);
        final XYChart.Data<String, Number> dataPrzegr = new XYChart.Data("Przegrane", st.getLoses());
        final XYChart.Data<String, Number> dataRem = new XYChart.Data("Remisy", st.getStalemate());
        final XYChart.Data<String, Number> dataWygr = new XYChart.Data("Wygrane", st.getCheckmate());
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


    }

    public void back(ActionEvent actionEvent) {
        App.changeScene(profileAnchorPane,"mainWindow");
    }

    public void changeStyle(ActionEvent actionEvent) {
        App.changeScene(profileAnchorPane,"styleWindow");
    }
}
