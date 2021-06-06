package Piece;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {

    private boolean moved = false;

    public Rook(int x, int y, PieceColor color, int value, String id) {
        super(x, y, color, value, id);
    }

    @Override
    public Move[] getPossibleMoves() {
        List<Move> listPossibleMoves = new ArrayList<>();
//        Move[] possibleMoves = new Move[0];
//        Move[] tmp = new Move[8];
//        int counter = 0;
        int tempX = 0;
        int tempY = 0;

        for(int direction = 0; direction < 4; direction++) {
            tempX = currentX;
            tempY = currentY;
//            counter = 0;

            if(direction == 0) {
                while(tempX < 7) {
                    tempX++;
//                    tmp[counter] = new Move(currentX, currentY, tempX, tempY);
//                    counter++;
                    listPossibleMoves.add(new Move(currentX, currentY, tempX, tempY));
                }
            } else if(direction == 1) {
                while(tempX > 0) {
                    tempX--;
//                    tmp[counter] = new Move(currentX, currentY, tempX, tempY);
//                    counter++;
                    listPossibleMoves.add(new Move(currentX, currentY, tempX, tempY));
                }
            } else if(direction == 2) {
                while(tempY < 7) {
                    tempY++;
//                    tmp[counter] = new Move(currentX, currentY, tempX, tempY);
//                    counter++;
                    listPossibleMoves.add(new Move(currentX, currentY, tempX, tempY));
                }
            } else if(direction == 3) {
                while(tempY > 0) {
                    tempY--;
//                    tmp[counter] = new Move(currentX, currentY, tempX, tempY);
//                    counter++;
                    listPossibleMoves.add(new Move(currentX, currentY, tempX, tempY));
                }
            }

//            int oldSize = possibleMoves.length;
//            Move[] tmpOldCopy = new Move[oldSize];
//            System.arraycopy(possibleMoves, 0, tmpOldCopy, 0, oldSize);
//            possibleMoves = new Move[oldSize + counter];
//            System.arraycopy(tmpOldCopy, 0, possibleMoves, 0, oldSize);
//            System.arraycopy(tmp, 0, possibleMoves, oldSize, tmp.length);
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
