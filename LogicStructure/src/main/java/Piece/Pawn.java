package Piece;

import java.util.List;

public class Pawn extends Piece {

    private boolean firstMove = true;

    public Pawn(int x, int y, PieceColor color, int value, String id) {
        super(x, y, color, value, id);
    }

    private boolean isMovePossible(List<Piece> allOtherPieces, int newX, int newY) {
        for(Piece piece : allOtherPieces) {
            boolean samePosition = (piece.currentX == newX) && (piece.currentY == newY);
            if( samePosition && (piece.getPieceColor() == this.getPieceColor()) ){
                return false;
            } else if ( samePosition && (piece.getPieceColor() != this.getPieceColor() ) ) {
                return true;
            }
        }
        return true;
    }

    private boolean isMoveAttack(List<Piece> allOtherPieces, int newX, int newY) {
        for(Piece piece : allOtherPieces) {
            boolean samePosition = (piece.currentX == newX) && (piece.currentY == newY);
            if ( samePosition && (piece.getPieceColor() != this.getPieceColor() ) ) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Move[] getPossibleMoves(List<Piece> allOtherPieces) {
        if(firstMove) {
            Move[] possibleMove = new Move[2];
            if((pieceColor == PieceColor.BLACK) && currentY < 7) {
                possibleMove[0] = new Move(currentX, currentY, currentX, currentY+1);
                possibleMove[1] = new Move(currentX, currentY, currentX, currentY+2);
            } else if((pieceColor == PieceColor.WHITE) && currentY > 0) {
                possibleMove[0] = new Move(currentX, currentY, currentX, currentY-1);
                possibleMove[1] = new Move(currentX, currentY, currentX, currentY-2);
            }
            return possibleMove;
        } else {
            Move[] possibleMove = new Move[3];
            if((pieceColor == PieceColor.BLACK) && currentY < 7) {
                possibleMove[0] = new Move(currentX, currentY, currentX, currentY+1);
                possibleMove[1] = new Move(currentX, currentY, currentX-1, currentY+1);
                possibleMove[2] = new Move(currentX, currentY, currentX+1, currentY+1);
                return possibleMove;
            } else if((pieceColor == PieceColor.WHITE) && currentY > 0) {
                possibleMove[0] = new Move(currentX, currentY, currentX, currentY-1);
                possibleMove[1] = new Move(currentX, currentY, currentX-1, currentY-1);
                possibleMove[2] = new Move(currentX, currentY, currentX-1, currentY-1);
                return possibleMove;
            } else {
                return null;
            }
        }
    }

    @Override
    public void move(int newX, int newY) {
        firstMove = false;
        super.move(newX, newY);
    }

}
