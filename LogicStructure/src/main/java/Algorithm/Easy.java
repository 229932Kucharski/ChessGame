package Algorithm;



import Piece.Move;
import Piece.Piece;
import Piece.PieceSet;

import java.util.Random;

public class Easy extends Algorithm{

    Random random = new Random();

    @Override
    public void makeMove() {
        int index = random.nextInt(copy.size());

        Move[] nextMove =  copy.get(index);


    }
}
