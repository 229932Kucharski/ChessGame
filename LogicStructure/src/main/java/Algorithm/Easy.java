package Algorithm;

import Piece.Move;

import java.util.Random;

public class Easy extends Algorithm{

    Random random = new Random();

    @Override
    public void makeMove() {
        int index = random.nextInt(copy.size());

        Move[] move = copy.get(index);

    }
}
