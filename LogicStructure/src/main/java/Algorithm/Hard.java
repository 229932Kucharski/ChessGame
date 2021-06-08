package Algorithm;

import Piece.Move;
import Piece.Piece;
import Piece.PieceSet;
import Piece.PieceColor;

import java.util.List;
import java.util.Random;

public class Hard extends Algorithm {

    boolean maximizing_player;
    double max_eval = Double.NEGATIVE_INFINITY;
    double min_eval = Double.POSITIVE_INFINITY;
    double current_eval = 0;
    private Move best_move;

    public double minimax(PieceSet pieceSet, int depth, PieceColor maximizing_color, boolean maximizing_player){
        if (depth == 0){
            //evaluate();
            return 0;
        }
         List<Move> moves = allySet.getPossibleMoves();
         Move best_move = getRandomMove(moves);

        if (maximizing_player) {
            for (Move move : moves) {

                current_eval = minimax(allySet, depth -1,maximizing_color,false);
                        if(current_eval > max_eval){
                            max_eval = current_eval;
                            best_move = move;
                        }

            return max_eval;
            }
        }else{
            for (Move move : moves) {

                current_eval = minimax(allySet, depth -1,maximizing_color,true);
                if(current_eval < min_eval){
                    min_eval = current_eval;
                    best_move = move;
                }
           return min_eval;
            }

        }


        return 0;
    }

    @Override
    public void makeMove() {

    }
}
