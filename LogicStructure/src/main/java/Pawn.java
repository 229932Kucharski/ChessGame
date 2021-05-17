
public class Pawn extends Piece {

    public Pawn(int x, int y, PieceColor color, int value) {
        super(x, y, color, value);
    }

    @Override
    public Move[] getPossibleMoves() {
        Move[] possibleMove = new Move[1];
        if((pieceColor == PieceColor.WHITE) && currentY < 7) {
            possibleMove[0] = new Move(currentX, currentY, currentX, currentY+1);
            return possibleMove;
        } else if((pieceColor == PieceColor.BLACK) && currentY > 0) {
            possibleMove[0] = new Move(currentX, currentY, currentX, currentY-1);
            return possibleMove;
        } else {
            return null;
        }
    }

}
