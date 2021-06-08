package Algorithm;

import Piece.Move;
import Piece.Piece;
import Piece.PieceSet;
import Piece.PieceColor;

import java.util.List;
import java.util.Random;

public class Hard extends Algorithm {

    private boolean maximizing_player;
    private double max_eval = Double.NEGATIVE_INFINITY;
    private double min_eval = Double.POSITIVE_INFINITY;
    protected int depth;
    double current_eval = 0;
    private Move best_move;

    public Hard(int depth) {
        this.depth = depth;
    }

    public double minimax(PieceSet pieceSet, int depth, PieceColor maximizing_color, boolean maximizing_player){
        if (depth == 0){
            evaluate(maximizing_color);
            return 0;
        }
         List<Move> moves = allySet.getPossibleMoves();
         Move best_move = getRandomMove(moves);

        if (maximizing_player) {
            max_eval = Double.NEGATIVE_INFINITY;
            for (Move move : moves) {
                allySet.move(move, enemySet);
                current_eval = minimax(allySet, depth -1,maximizing_color,false);
                allySet.unmakeMove(enemySet);
                if(current_eval > max_eval){
                    max_eval = current_eval;
                    best_move = move;
                }

                return max_eval;
            }
        }else{
            min_eval = Double.POSITIVE_INFINITY;
            for (Move move : moves) {
                allySet.move(move, enemySet);
                current_eval = minimax(allySet, depth -1,maximizing_color,true);
                allySet.unmakeMove(enemySet);
                if(current_eval < min_eval){
                    min_eval = current_eval;
                    best_move = move;
                }

                return min_eval;
            }

        }


        return 0;
    }

    public String toString() {
        return "Minimax";
    }

    @Override
    public Move makeMove() {
        minimax(allySet, 4, allySet.getPieceColor(), true);
        allySet.move(best_move,enemySet);
        return null;
    }
}
