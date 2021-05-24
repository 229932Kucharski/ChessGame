package controllers;

import app.App;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.layout.*;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class GameController {
    public AnchorPane gameAnchorPane;
    public boolean isHighlighted;
    public GridPane chessboardGridPane;

    public void initialize() {
        addGridEvent();
    }
    private void addGridEvent() {
        chessboardGridPane.getChildren().forEach(item -> {
            item.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (event.getClickCount() == 1) {
                        System.out.println("doubleClick");
                        Node source = (Node) event.getSource();
                        Integer colIndex = GridPane.getColumnIndex(source);
                        Integer rowIndex = GridPane.getRowIndex(source);
                        if(colIndex == null) {
                            colIndex = 0;
                        }
                        if(rowIndex == null) {
                            rowIndex = 0;
                        }
                        System.out.printf("Mouse entered cell [%d, %d]%n", colIndex, rowIndex);
                        HBox hb = (HBox) getNodeByXY(chessboardGridPane, rowIndex, colIndex);

                        hb.setBorder(new Border(new BorderStroke(Color.YELLOW,
                                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(4))));

                        System.out.println(hb);
                    }
                    if (event.isPrimaryButtonDown()) {
                        System.out.println("PrimaryKey event");
                    }
                }
            });
        });
    }
    public Node getNodeByXY(GridPane gp, int x, int y) {
        Node result = null;
        ObservableList<Node> children = gp.getChildren();
        for (Node node : children) {

            Integer row = GridPane.getRowIndex(node);
            Integer column = GridPane.getColumnIndex(node);
            if(row == null) {
                row = 0;
            }
            if(column == null) {
                column = 0;
            }

            if(row == x && column == y) {
                result = node;
                break;
            }
        }
        return result;
    }
    public void back(ActionEvent actionEvent) {
        App.changeScene(gameAnchorPane,"mainWindow");
    }

    public void mouseEntered(javafx.scene.input.MouseEvent mouseEvent) {
        Node source = (Node) mouseEvent.getSource();
        Integer colIndex = GridPane.getColumnIndex(source);
        Integer rowIndex = GridPane.getRowIndex(source);
        System.out.printf("Mouse entered cell [%d, %d]%n", colIndex, rowIndex);
    }
}
