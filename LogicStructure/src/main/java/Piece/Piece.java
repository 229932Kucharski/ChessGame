package Piece;

public abstract class Piece {

    private boolean danger = false;

    protected int currentX;
    protected int currentY;

    protected PieceColor pieceColor;
    private int value;
    protected String id;
    private boolean isOnBoard = true;

    public abstract Move[] getPossibleMoves();

    public Piece(int x, int y, PieceColor color, int value, String id) {
        currentX = x;
        currentY = y;
        pieceColor = color;
        this.value = value;
        this.id = id;
    }

    public void move(int newX, int newY) {
        currentX = newX;
        currentY = newY;
    }

    public int getCurrentX() {
        return currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public int getValue() {
        return value;
    }

    public boolean isOnBoard() {
        return isOnBoard;
    }

    public void removeFromBoard() {
        isOnBoard = false;
    }

    public String getId() {
        return id;
    }

    public boolean isDanger() {
        return danger;
    }

    public void setDanger(boolean danger) {
        this.danger = danger;
    }
}
