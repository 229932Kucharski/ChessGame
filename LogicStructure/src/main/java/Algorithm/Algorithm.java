package Algorithm;

import Piece.*;

import java.util.ArrayList;
import java.util.List;



public abstract class Algorithm {

    protected Move nextMove;
    protected String difficultyLevel;

    protected PieceSet gameSet;



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

    public int evaluate(PieceColor maximizing_color){
        int currentScore;
        if (maximizing_color == PieceColor.WHITE){
            currentScore = gameSet.getWhiteScore() - gameSet.getBlackScore();
        }else{
            currentScore = gameSet.getBlackScore() - gameSet.getWhiteScore();
        }
        return currentScore;
    }
}
