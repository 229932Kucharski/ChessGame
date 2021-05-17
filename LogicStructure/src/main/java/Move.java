
public class Move {

    private final int currentX;
    private final int currentY;

    private final int nextX;
    private final int nextY;

    public Move(int currentX, int currentY, int nextX, int nextY) {
        this.currentX = currentX;
        this.currentY = currentY;
        this.nextX = nextX;
        this.nextY = nextY;
    }

    public int getCurrentX() {
        return currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public int getNextX() {
        return nextX;
    }

    public int getNextY() {
        return nextY;
    }

}
