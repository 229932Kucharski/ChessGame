package controllers;

import code.CheckerBoard;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class SetPiecesOnBoard {

    static CheckerBoard cb = new CheckerBoard();
    public static void setPieces(HBox hb, int i, int j) {
        //if(i == 0 && j == 0 || i == 0 && j == 7) {
            //tu powinna byc czarna wieza
//            Image image = new Image("/images/rookBlack.png");
//            ImageView imageView = new ImageView(image);
//            imageView.setId("blackImage");
//            imageView.setFitHeight(60);
//            imageView.setFitWidth(45);

            //hb.getChildren().add(imageView);
        //}
        cb.fillHBox(hb,"/images/rookBlack.png",i,j, 0,0);
        cb.fillHBox(hb,"/images/rookBlack.png",i,j,0,7);
        cb.fillHBox(hb,"/images/rook.png",i,j,7,0);
        cb.fillHBox(hb,"/images/rook.png",i,j,7,7);
        cb.fillHBox(hb,"/images/knightBlack.png",i,j,0,1);
        cb.fillHBox(hb,"/images/knightBlack.png",i,j,0,6);
        cb.fillHBox(hb,"/images/knight.png",i,j,7,1);
        cb.fillHBox(hb,"/images/knight.png",i,j,7,6);
        cb.fillHBox(hb,"/images/bishopBlack.png",i,j,0,2);
        cb.fillHBox(hb,"/images/bishopBlack.png",i,j,0,5);
        cb.fillHBox(hb,"/images/bishop.png",i,j,7,2);
        cb.fillHBox(hb,"/images/bishop.png",i,j,7,5);
        cb.fillHBox(hb,"/images/queenBlack.png",i,j,0,3);
        cb.fillHBox(hb,"/images/queen.png",i,j,7,4);
        cb.fillHBox(hb,"/images/kingBlack.png",i,j,0,4);
        cb.fillHBox(hb,"/images/king.png",i,j,7,3);
        for(int y = 0; y < 8 ; y++) {
            cb.fillHBox(hb,"/images/pawnBlack.png",i,j,1,y);
            cb.fillHBox(hb,"/images/pawn.png",i,j,6,y);
        }


//        if(i == 7 && j == 7 || i == 7 && j == 0) {
//            Image image = new Image("/images/rook.png");
//            ImageView imageView = new ImageView(image);
//            imageView.setId("whiteImage");
//            imageView.setFitHeight(60);
//            imageView.setFitWidth(45);
//            hb.getChildren().add(imageView);
//        }
//
//        if(i == 0 && (j == 1 || j == 6)) {
//            //tu powinien byc czarny skoczek
//            Image image = new Image("/images/knightBlack.png");
//            ImageView imageView = new ImageView(image);
//            imageView.setId("blackImage");
//            imageView.setFitHeight(60);
//            imageView.setFitWidth(45);
//            hb.getChildren().add(imageView);
//        }
//
//        if(i == 7 && (j == 1 ||  j == 6)) {
//            Image image = new Image("/images/knight.png");
//            ImageView imageView = new ImageView(image);
//            imageView.setId("whiteImage");
//            imageView.setFitHeight(60);
//            imageView.setFitWidth(45);
//            hb.getChildren().add(imageView);
//        }
//
//        if(i == 0 && (j == 2 ||  j == 5)) {
//            //tu powinien byc czarny bishop
//            Image image = new Image("/images/bishopBlack.png");
//            ImageView imageView = new ImageView(image);
//            imageView.setId("blackImage");
//            imageView.setFitHeight(60);
//            imageView.setFitWidth(45);
//            hb.getChildren().add(imageView);
//        }
//
//        if(i == 7 && (j == 2 ||  j == 5)) {
//            Image image = new Image("/images/bishop.png");
//            ImageView imageView = new ImageView(image);
//            imageView.setId("whiteImage");
//            imageView.setFitHeight(60);
//            imageView.setFitWidth(45);
//            hb.getChildren().add(imageView);
//        }
//
//        if(i==0 && j == 3) {
//            //tu powinna byc czarna krolowa
//            Image image = new Image("/images/queenBlack.png");
//            ImageView imageView = new ImageView(image);
//            imageView.setId("blackImage");
//            imageView.setFitHeight(60);
//            imageView.setFitWidth(45);
//            hb.getChildren().add(imageView);
//        }
//
//        if (i == 7 && j == 4) {
//            Image image = new Image("/images/queen.png");
//            ImageView imageView = new ImageView(image);
//            imageView.setId("whiteImage");
//            imageView.setFitHeight(60);
//            imageView.setFitWidth(45);
//            hb.getChildren().add(imageView);
//        }
//
//        if (i == 0 && j == 4) {
//            //tu powinien byc czarny krol
//            Image image = new Image("/images/kingBlack.png");
//            ImageView imageView = new ImageView(image);
//            imageView.setId("blackImage");
//            imageView.setFitHeight(60);
//            imageView.setFitWidth(45);
//            hb.getChildren().add(imageView);
//        }
//
//        if (i == 7 && j == 3) {
//            Image image = new Image("/images/king.png");
//            ImageView imageView = new ImageView(image);
//            imageView.setId("whiteImage");
//            imageView.setFitHeight(60);
//            imageView.setFitWidth(45);
//            hb.getChildren().add(imageView);
//        }
//
//        for(int x = 0; x < 8 ; x++) {
//            if (i == 1 && j == x) {
//                //blackImage pawns
//                Image image = new Image("/images/pawnBlack.png");
//                ImageView imageView = new ImageView(image);
//                imageView.setId("blackImage");
//                imageView.setFitHeight(60);
//                imageView.setFitWidth(45);
//                hb.getChildren().add(imageView);
//            }
//            if (i == 6 && j == x) {
//                Image image = new Image("/images/pawn.png");
//                ImageView imageView = new ImageView(image);
//                imageView.setId("whiteImage");
//                imageView.setFitHeight(60);
//                imageView.setFitWidth(45);
//                hb.getChildren().add(imageView);
//            }
//        }

    }
}
