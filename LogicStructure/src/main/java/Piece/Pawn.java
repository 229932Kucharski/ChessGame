package Piece;

public class Pawn extends Piece {

    private boolean firstMove = true;

    public Pawn(int x, int y, PieceColor color, int value) {
        super(x, y, color, value);
    }

    @Override
    public Move[] getPossibleMoves() {
        if(firstMove) {
            Move[] possibleMove = new Move[2];
            if((pieceColor == PieceColor.WHITE) && currentY < 7) {
                possibleMove[0] = new Move(currentX, currentY, currentX, currentY+1);
                possibleMove[1] = new Move(currentX, currentY, currentX, currentY+2);
            } else if((pieceColor == PieceColor.BLACK) && currentY > 0) {
                possibleMove[0] = new Move(currentX, currentY, currentX, currentY-1);
                possibleMove[1] = new Move(currentX, currentY, currentX, currentY-2);
            }
            firstMove = false;
            return possibleMove;
        } else {
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

}