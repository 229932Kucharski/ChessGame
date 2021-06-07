package controllers;

import code.CheckerBoard;
import javafx.scene.layout.HBox;

public class SetPiecesOnBoard {

    static CheckerBoard cb = new CheckerBoard();
    public static void setPieces(HBox hb, int i, int j) {
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
        cb.fillHBox(hb,"/images/queen.png",i,j,7,3);
        cb.fillHBox(hb,"/images/kingBlack.png",i,j,0,4);
        cb.fillHBox(hb,"/images/king.png",i,j,7,4);
        for(int y = 0; y < 8 ; y++) {
            cb.fillHBox(hb,"/images/pawnBlack.png",i,j,1,y);
            cb.fillHBox(hb,"/images/pawn.png",i,j,6,y);
        }
    }
}
