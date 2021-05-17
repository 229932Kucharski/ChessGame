

public class Pawn extends Piece {

    public Pawn() {
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
