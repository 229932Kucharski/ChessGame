package Algorithm;

import Piece.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public abstract class Algorithm {

    protected Move nextMove;
    protected String difficultyLevel;

    protected PieceSet gameSet;
    protected PieceSet allySet;
    protected PieceSet enemySet;
    Random random = new Random();



    protected PieceColor maximizing_color;

    public abstract void makeMove();



    public Algorithm() {




            switch (difficultyLevel) {

                case "Algorithm.Easy":
                    System.out.println("Algorithm.Easy");
                    makeMove();
                    break;
                case "Normal":
                    System.out.println("Normal");
                    makeMove();
                    break;
                case "Hard":
                    System.out.println("Hard");
                    makeMove();
                    break;

            }
    }
    public Move  getNextMove() { return nextMove; }

    public String getDifficultyLevel() { return difficultyLevel; }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public Move getRandomMove(List<Move> list){

        int index = random.nextInt(allySet.getPossibleMoves().size());

        return list.get(index);

    }

    public int evaluate(){
        return allySet.getScore() - enemySet.getScore();
    }
}
