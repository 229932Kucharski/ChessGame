package Piece;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {

    private boolean moved = false;
    private boolean danger = false;

    public King(int x, int y, PieceColor color, int value, String id) {
        super(x, y, color, value, id);
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
                if (tempX > 0 && tempY > 0) {
                    tempX--;
                    tempY--;
                    listPossibleMoves.add(new Move(currentX, currentY, tempX, tempY));
                }
            } else if (direction == 1) {
                if ( tempY > 0) {
                    tempY--;
                    listPossibleMoves.add(new Move(currentX, currentY, tempX, tempY));
                }
            } else if (direction == 2) {
                if (tempX < 7 && tempY > 0) {
                    tempX++;
                    tempY--;
                    listPossibleMoves.add(new Move(currentX, currentY, tempX, tempY));
                }
            } else if (direction == 3) {
                if (tempX < 7 ) {
                    tempX++;
                    listPossibleMoves.add(new Move(currentX, currentY, tempX, tempY));
                }
            } else if (direction == 4) {
                if (tempX < 7 && tempY < 7) {
                    tempX++;
                    tempY++;
                    listPossibleMoves.add(new Move(currentX, currentY, tempX, tempY));
                }
            } else if (direction == 5) {
                if (tempY < 7) {
                    tempY++;
                    listPossibleMoves.add(new Move(currentX, currentY, tempX, tempY));
                }
            } else if (direction == 6) {
                if (tempX > 0 && tempY < 7) {
                    tempX--;
                    tempY++;
                    listPossibleMoves.add(new Move(currentX, currentY, tempX, tempY));
                }
            } else if (direction == 7) {
                if (tempX > 0 ) {
                    tempX--;
                    listPossibleMoves.add(new Move(currentX, currentY, tempX, tempY));
                }
            }
        }
        List<Move> retList = new ArrayList<>();
        for(Move move : listPossibleMoves) {
            if(isMovePossible(allOtherPieces, move.getNextX(), move.getNextY())) {
                move.setAttack(isMoveAttack(allOtherPieces, move));
                retList.add(move);
            }
        }

        Move[] possibleMoves = new Move[retList.size()];
        for(int i = 0; i < retList.size(); i++) {
            possibleMoves[i] = retList.get(i);
        }
        return possibleMoves;
    }

    public void setMovedTrue() {
        moved = true;
    }

    public boolean wasMoved() {
        return moved;
    }

    public boolean isDanger() {
        return danger;
    }

    public void setDanger(boolean danger) {
        this.danger = danger;
    }
    @Override
    public void move(int newX, int newY) {
        super.move(newX, newY);
        setMovedTrue();
    }


}
