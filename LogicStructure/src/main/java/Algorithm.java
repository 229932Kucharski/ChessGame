import java.util.ArrayList;
import java.util.List;



public abstract class Algorithm {

    protected Move nextMove;
    protected String difficultyLevel;

    private PieceSet gameSet;

    public abstract void makeMove();
    protected List<Move[]> copy = new ArrayList<Move[]>();


    public Algorithm() {

        copy.addAll(gameSet.possibleMoves);


            switch (difficultyLevel) {

                case "Easy":
                    System.out.println("Easy");
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
}
