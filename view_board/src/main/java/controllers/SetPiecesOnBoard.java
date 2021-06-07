package controllers;

import code.CheckerBoard;
import javafx.scene.layout.HBox;

public class SetPiecesOnBoard {

    static CheckerBoard cb = new CheckerBoard();
    public static void setPieces(HBox hb, int i, int j) {
        String dir = StyleManager.figuresStyle;
        cb.fillHBox(hb,"/images/"+ dir +"/rookBlack.png",i,j, 0,0);
        cb.fillHBox(hb,"/images/"+ dir +"/rookBlack.png",i,j,0,7);
        cb.fillHBox(hb,"/images/"+ dir +"/rook.png",i,j,7,0);
        cb.fillHBox(hb,"/images/"+ dir +"/rook.png",i,j,7,7);
        cb.fillHBox(hb,"/images/"+ dir +"/knightBlack.png",i,j,0,1);
        cb.fillHBox(hb,"/images/"+ dir +"/knightBlack.png",i,j,0,6);
        cb.fillHBox(hb,"/images/"+ dir +"/knight.png",i,j,7,1);
        cb.fillHBox(hb,"/images/"+ dir +"/knight.png",i,j,7,6);
        cb.fillHBox(hb,"/images/"+ dir +"/bishopBlack.png",i,j,0,2);
        cb.fillHBox(hb,"/images/"+ dir +"/bishopBlack.png",i,j,0,5);
        cb.fillHBox(hb,"/images/"+ dir +"/bishop.png",i,j,7,2);
        cb.fillHBox(hb,"/images/"+ dir +"/bishop.png",i,j,7,5);
        cb.fillHBox(hb,"/images/"+ dir +"/queenBlack.png",i,j,0,3);
        cb.fillHBox(hb,"/images/"+ dir +"/queen.png",i,j,7,3);
        cb.fillHBox(hb,"/images/"+ dir +"/kingBlack.png",i,j,0,4);
        cb.fillHBox(hb,"/images/"+ dir +"/king.png",i,j,7,4);
        for(int y = 0; y < 8 ; y++) {
            cb.fillHBox(hb,"/images/"+ dir +"/pawnBlack.png",i,j,1,y);
            cb.fillHBox(hb,"/images/"+ dir +"/pawn.png",i,j,6,y);
        }
    }
}
