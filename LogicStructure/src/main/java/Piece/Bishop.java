package Piece;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece{

    public Bishop(int x, int y, PieceColor color, int value, String id) {
        super(x, y, color, value, id);
    }

    @Override
    public Move[] getPossibleMoves(List<Piece> allOtherPieces) {
        List<Move> listPossibleMoves = new ArrayList<>();
        int tempX = 0;
        int tempY = 0;

        for (int direction = 0; direction < 4; direction++) {
            tempX = currentX;
            tempY = currentY;

            if (direction == 0) {

                while (tempX < 7 && tempY > 0) {
                    tempX++;
                    tempY--;
                    if(isMovePossible(allOtherPieces, tempX, tempY)) {
                        Move move = new Move(currentX, currentY, tempX, tempY);
                        if(isMoveAttack(allOtherPieces, move)) {
                            move.setAttack(true);
                            listPossibleMoves.add(move);
                            tempX = 8;
                            tempY = -1; //wyjscie z while
                        } else {
                            listPossibleMoves.add(move);
                        }
                    } else {
                        tempX = 8;
                        tempY = -1; //wyjscie z while
                    }
                }

            } else if (direction == 1) {

                while (tempX < 7  && tempY < 7) {
                    tempX++;
                    tempY++;
                    if(isMovePossible(allOtherPieces, tempX, tempY)) {
                        Move move = new Move(currentX, currentY, tempX, tempY);
                        if(isMoveAttack(allOtherPieces, move)) {
                            move.setAttack(true);
                            listPossibleMoves.add(move);
                            tempX = 8;
                            tempY = 8; //wyjscie z while
                        } else {
                            listPossibleMoves.add(move);
                        }
                    } else {
                        tempX = 8;
                        tempY = 8; //wyjscie z while
                    }
                }

            } else if (direction == 2) {

                while (tempX > 0 && tempY < 7)  {
                    tempX--;
                    tempY++;
                    if(isMovePossible(allOtherPieces, tempX, tempY)) {
                        Move move = new Move(currentX, currentY, tempX, tempY);
                        if(isMoveAttack(allOtherPieces, move)) {
                            move.setAttack(true);
                            listPossibleMoves.add(move);
                            tempX = -1;
                            tempY = 8; //wyjscie z while
                        } else {
                            listPossibleMoves.add(move);
                        }
                    } else {
                        tempX = -1;
                        tempY = 8; //wyjscie z while
                    }
                }

            } else if (direction == 3) {

                while (tempX > 0 && tempY > 0) {
                    tempX--;
                    tempY--;
                    if(isMovePossible(allOtherPieces, tempX, tempY)) {
                        Move move = new Move(currentX, currentY, tempX, tempY);
                        if(isMoveAttack(allOtherPieces, move)) {
                            move.setAttack(true);
                            listPossibleMoves.add(move);
                            tempX = -1;
                            tempY = -1; //wyjscie z while
                        } else {
                            listPossibleMoves.add(move);
                        }
                    } else {
                        tempX = -1;
                        tempY = -1; //wyjscie z while
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
