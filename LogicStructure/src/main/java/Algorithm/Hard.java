package Algorithm;

import Piece.Move;
import Piece.Piece;
import Piece.PieceSet;
import Piece.PieceColor;

public class Hard extends Algorithm {

    boolean maximizing_player;

    public Move minimax(PieceSet pieceSet, int depth, PieceColor maximizing_color, boolean maximizing_player){
        if (depth == 0){
            evaluate(maximizing_color);
            return null;
        }
        double max_eval = Double.NEGATIVE_INFINITY;

        for(Move possibleMove : gameSet.getPossibleMoves()) {

        }


        return null;
    }

    @Override
    public void makeMove() {

    }
}
