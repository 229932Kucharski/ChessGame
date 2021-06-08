package Piece;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {

    public Queen(int x, int y, PieceColor color, int value, String id) {
        super(x, y, color, value, id);
    }

    private boolean decideIfAddAndAdd(List<Move> listPossibleMoves, List<Piece> allOtherPieces, int tempX, int tempY) {
        if(isMovePossible(allOtherPieces, tempX, tempY)) {
            Move move = new Move(currentX, currentY, tempX, tempY);
            if(isMoveAttack(allOtherPieces, move)) {
                move.setAttack(true);
                listPossibleMoves.add(move);
                return true;
            } else {
                listPossibleMoves.add(move);
                return false;
            }
        } else {
            return true; //wyjscie z while
        }
    }

    @Override
    public Move[] getPossibleMoves(List<Piece> allOtherPieces) {
        List<Move> listPossibleMoves = new ArrayList<>();
        int tempX = 0;
        int tempY = 0;

        for (int direction = 0; direction < 8; direction++) {
            tempX = currentX;
            tempY = currentY;

            if (direction == 0) {

                while (tempX < 7 && tempY > 0) {
                    tempX++;
                    tempY--;
                    if(decideIfAddAndAdd(listPossibleMoves, allOtherPieces, tempX, tempY)) {
                        tempX = 8;
                        tempY = -1;
                    }
                }

            } else if (direction == 1) {

                while (tempX < 7  && tempY < 7) {
                    tempX++;
                    tempY++;
                    if(decideIfAddAndAdd(listPossibleMoves, allOtherPieces, tempX, tempY)) {
                        tempX = 8;
                        tempY = 8;
                    }
                }

            } else if (direction == 2) {

                while (tempX > 0 && tempY < 7)  {
                    tempX--;
                    tempY++;
                    if(decideIfAddAndAdd(listPossibleMoves, allOtherPieces, tempX, tempY)) {
                        tempX = -1;
                        tempY = 8;
                    }
                }

            } else if (direction == 3) {

                while (tempX > 0 && tempY > 0) {
                    tempX--;
                    tempY--;
                    if(decideIfAddAndAdd(listPossibleMoves, allOtherPieces, tempX, tempY)) {
                        tempX = -1;
                        tempY = -1;
                    }
                }

            } else if (direction == 4) {

                while(tempX < 7) {
                    tempX++;
                    if(decideIfAddAndAdd(listPossibleMoves, allOtherPieces, tempX, tempY)) {
                        tempX = 8;
                    }
                }

            } else if (direction == 5) {

                while(tempX > 0) {
                    tempX--;
                    if(decideIfAddAndAdd(listPossibleMoves, allOtherPieces, tempX, tempY)) {
                        tempX = -1;
                    }
                }

            } else if (direction == 6) {

                while(tempY < 7) {
                    tempY++;
                    if(decideIfAddAndAdd(listPossibleMoves, allOtherPieces, tempX, tempY)) {
                        tempY = 8;
                    }
                }

            } else if (direction == 7) {

                while(tempY > 0) {
                    tempY--;
                    if(decideIfAddAndAdd(listPossibleMoves, allOtherPieces, tempX, tempY)) {
                        tempY = -1;
                    }
                }

            }


        }

        Move[] possibleMoves = new Move[listPossibleMoves.size()];
        for(int i = 0; i < listPossibleMoves.size(); i++) {
            possibleMoves[i] = listPossibleMoves.get(i);
        }
        return possibleMoves;
    }
}
