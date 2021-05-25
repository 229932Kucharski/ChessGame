package code;

public class Statistic {

    private int checkmate;
    private int stalemate;
    private int loses;
    private int played;

    public Statistic(int checkmate, int stalemate, int loses) {
        this.checkmate = checkmate;
        this.stalemate = stalemate;
        this.loses = loses;
    }

    public int getCheckmate() {
        return checkmate;
    }

    public int getStalemate() {
        return stalemate;
    }

    public int getLoses() {
        return loses;
    }

    public int getPlayed() {
        played = getCheckmate() + getStalemate() + getLoses();
        return played;
    }



}
