package player;

public class Statistic {
    
    private int checkMate;
    private int staleMate;
    private int loses;
    private int played;

    public Statistic(int checkMate, int staleMate, int loses, int played) {
        this.checkMate = checkMate;
        this.staleMate = staleMate;
        this.loses = loses;
        this.played = played;
    }

    public int getCheckMate() {
        return checkMate;
    }

    public void setCheckMate(int checkMate) {
        this.checkMate = checkMate;
    }

    public int getStaleMate() {
        return staleMate;
    }

    public void setStaleMate(int staleMate) {
        this.staleMate = staleMate;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public int getPlayed() {
        return checkMate + staleMate + loses;
    }

}
