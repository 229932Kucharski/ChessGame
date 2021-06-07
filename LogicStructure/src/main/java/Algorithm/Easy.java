package Algorithm;



import Piece.Move;
import Piece.PieceSet;

import java.util.List;


public class Easy extends Algorithm{


    @Override
    public void makeMove() {

        List<Move> moves = allySet.getPossibleMoves();
        Move nextMove =  getRandomMove(moves);
        allySet.move(nextMove, enemySet);



    }
}
