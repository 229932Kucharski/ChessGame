package Piece;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

    private boolean firstMove = true;

    public Pawn(int x, int y, PieceColor color, int value, String id) {
        super(x, y, color, value, id);
    }

//    private boolean isMovePossible(List<Piece> allOtherPieces, int newX, int newY) {
//        for(Piece piece : allOtherPieces) {
//            boolean samePosition = (piece.currentX == newX) && (piece.currentY == newY);
//            if( samePosition && (piece.getPieceColor() == this.getPieceColor()) ){
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private boolean isMoveAttack(List<Piece> allOtherPieces, Move move) {
//        for(Piece piece : allOtherPieces) {
//            boolean samePosition = (piece.currentX == move.getNextX()) && (piece.currentY == move.getNextY());
//            if ( samePosition && (piece.getPieceColor() != this.getPieceColor() ) ) {
//                return true;
//            }
//        }
//        return false;
//    }

//    @Override
//    public Move[] getPossibleMoves(List<Piece> allOtherPieces) {
//        List<Move> listPossibleMoves = new ArrayList<>();
//        if(firstMove) {
//            Move[] possibleMove = new Move[2];
//            if((pieceColor == PieceColor.BLACK) && currentY < 7) {
//                possibleMove[0] = new Move(currentX, currentY, currentX, currentY+1);
//                possibleMove[1] = new Move(currentX, currentY, currentX, currentY+2);
//            } else if((pieceColor == PieceColor.WHITE) && currentY > 0) {
//                possibleMove[0] = new Move(currentX, currentY, currentX, currentY-1);
//                possibleMove[1] = new Move(currentX, currentY, currentX, currentY-2);
//            }
//            return possibleMove;
//        } else {
//            Move[] possibleMove = new Move[3];
//            if((pieceColor == PieceColor.BLACK) && currentY < 7) {
//                possibleMove[0] = new Move(currentX, currentY, currentX, currentY+1);
//                possibleMove[1] = new Move(currentX, currentY, currentX-1, currentY+1);
//                possibleMove[2] = new Move(currentX, currentY, currentX+1, currentY+1);
//                return possibleMove;
//            } else if((pieceColor == PieceColor.WHITE) && currentY > 0) {
//                possibleMove[0] = new Move(currentX, currentY, currentX, currentY-1);
//                possibleMove[1] = new Move(currentX, currentY, currentX-1, currentY-1);
//                possibleMove[2] = new Move(currentX, currentY, currentX+1, currentY-1);
//                return possibleMove;
//            } else {
//                return null;
//            }
//        }
//        Move[] possibleMoves = new Move[listPossibleMoves.size()];
//        for(int i = 0; i < listPossibleMoves.size(); i++) {
//            possibleMoves[i] = listPossibleMoves.get(i);
//        }
//        return possibleMoves;
//    }

    @Override
    public Move[] getPossibleMoves(List<Piece> allOtherPieces) {
        List<Move> listPossibleMoves = new ArrayList<>();
        if( (pieceColor == PieceColor.BLACK) && currentY < 7 ) {

            if(isMovePossible(allOtherPieces, currentX, currentY+1)) {
                Move shortMove = new Move(currentX, currentY, currentX, currentY+1);

                if(!isMoveAttack(allOtherPieces, shortMove)) {
                    listPossibleMoves.add(shortMove);

                    if( firstMove && isMovePossible(allOtherPieces, currentX, currentY+2) ) {
                        Move longMove = new Move(currentX, currentY, currentX, currentY+2);
                        if(!isMoveAttack(allOtherPieces, longMove)) {
                            listPossibleMoves.add(longMove);
                        }
                    }
                }
            }

            Move[] attacks = new Move[2];
            attacks[0] = new Move(currentX, currentY, currentX-1, currentY+1);
            attacks[1] = new Move(currentX, currentY, currentX+1, currentY+1);
            for(Move attack : attacks) {
                if(isMoveAttack(allOtherPieces, attack)) {
                    attack.setAttack(true);
                    listPossibleMoves.add(attack);
                }

            }

        } else if ( (pieceColor == PieceColor.WHITE) && currentY > 0 ) {

            if(isMovePossible(allOtherPieces, currentX, currentY-1)) {
                Move shortMove = new Move(currentX, currentY, currentX, currentY-1);

                if(!isMoveAttack(allOtherPieces, shortMove)) {
                    listPossibleMoves.add(shortMove);

                    if( firstMove && isMovePossible(allOtherPieces, currentX, currentY-2) ) {
                        Move longMove = new Move(currentX, currentY, currentX, currentY-2);
                        if(!isMoveAttack(allOtherPieces, longMove)) {
                            listPossibleMoves.add(longMove);
                        }
                    }
                }
            }

            Move[] attacks = new Move[2];
            attacks[0] = new Move(currentX, currentY, currentX-1, currentY-1);
            attacks[1] = new Move(currentX, currentY, currentX+1, currentY-1);
            for(Move attack : attacks) {
                if(isMoveAttack(allOtherPieces, attack)) {
                    attack.setAttack(true);
                    listPossibleMoves.add(attack);
                }

            }


//            if(isMovePossible(allOtherPieces, currentX, currentY-1)) {
//                Move shortMove = new Move(currentX, currentY, currentX, currentY-1);
//                shortMove.setAttack(isMoveAttack(allOtherPieces, shortMove));
//                listPossibleMoves.add(shortMove);
//            }
//            Move[] attacks = new Move[2];
//            attacks[0] = new Move(currentX, currentY, currentX-1, currentY-1);
//            attacks[1] = new Move(currentX, currentY, currentX+1, currentY-1);
//            for(Move attack : attacks) {
//                if(isMoveAttack(allOtherPieces, attack)) {
//                    attack.setAttack(true);
//                    listPossibleMoves.add(attack);
//                }
//
//            }
//            if(firstMove && isMovePossible(allOtherPieces, currentX, currentY-2)) {
//                Move longMove = new Move(currentX, currentY, currentX, currentY-2);
//                longMove.setAttack(isMoveAttack(allOtherPieces, longMove));
//                listPossibleMoves.add(longMove);
//            }
        }

        Move[] possibleMoves = new Move[listPossibleMoves.size()];
        for(int i = 0; i < listPossibleMoves.size(); i++) {
            possibleMoves[i] = listPossibleMoves.get(i);
        }
        return possibleMoves;
    }

    @Override
    public void move(int newX, int newY) {
        firstMove = false;
        super.move(newX, newY);
    }

}
