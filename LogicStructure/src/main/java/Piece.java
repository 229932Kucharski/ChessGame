public abstract class Piece {

    protected int currentX;
    protected int currentY;

    PieceColor pieceColor;
    int value;
    boolean isOnBoard;
    byte position;

    public abstract Move[] getPossibleMoves();

}
