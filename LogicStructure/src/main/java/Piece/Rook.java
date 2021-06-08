package Piece;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {

    private boolean moved = false;

    public Rook(int x, int y, PieceColor color, int value, String id) {
        super(x, y, color, value, id);
    }

    @Override
    public Move[] getPossibleMoves(List<Piece> allOtherPieces) {
        List<Move> listPossibleMoves = new ArrayList<>();
        int tempX = 0;
        int tempY = 0;

        for(int direction = 0; direction < 4; direction++) {
            tempX = currentX;
            tempY = currentY;

            if(direction == 0) {

                while(tempX < 7) {
                    tempX++;
                    if(isMovePossible(allOtherPieces, tempX, tempY)) {
                        Move move = new Move(currentX, currentY, tempX, tempY);
                        if(isMoveAttack(allOtherPieces, move)) {
                            move.setAttack(true);
                            listPossibleMoves.add(move);
                            tempX = 8; //wyjscie z while
                        } else {
                            listPossibleMoves.add(move);
                        }
                    } else {
                        tempX = 8; //wyjscie z while
                    }
                }

            } else if(direction == 1) {

                while(tempX > 0) {
                    tempX--;
                    if(isMovePossible(allOtherPieces, tempX, tempY)) {
                        Move move = new Move(currentX, currentY, tempX, tempY);
                        if(isMoveAttack(allOtherPieces, move)) {
                            move.setAttack(true);
                            listPossibleMoves.add(move);
                            tempX = -1; //wyjscie z while
                        } else {
                            listPossibleMoves.add(move);
                        }
                    } else {
                        tempX = -1; //wyjscie z while
                    }
                }

            } else if(direction == 2) {

                while(tempY < 7) {
                    tempY++;
                    if(isMovePossible(allOtherPieces, tempX, tempY)) {
                        Move move = new Move(currentX, currentY, tempX, tempY);
                        if(isMoveAttack(allOtherPieces, move)) {
                            move.setAttack(true);
                            listPossibleMoves.add(move);
                            tempY = 8; //wyjscie z while
                        } else {
                            listPossibleMoves.add(move);
                        }
                    } else {
                        tempY = 8; //wyjscie z while
                    }
                }

            } else if(direction == 3) {

                while(tempY > 0) {
                    tempY--;
                    if(isMovePossible(allOtherPieces, tempX, tempY)) {
                        Move move = new Move(currentX, currentY, tempX, tempY);
                        if(isMoveAttack(allOtherPieces, move)) {
                            move.setAttack(true);
                            listPossibleMoves.add(move);
                            tempY = -1; //wyjscie z while
                        } else {
                            listPossibleMoves.add(move);
                        }
                    } else {
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

    public void setMovedTrue() {
        moved = true;
    }

    public boolean wasMoved() {
        return moved;
    }

    @Override
    public void move(int newX, int newY) {
        super.move(newX, newY);
        setMovedTrue();
    }

}
