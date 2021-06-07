package Piece;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {

    public Queen(int x, int y, PieceColor color, int value, String id) {
        super(x, y, color, value, id);
    }

    @Override
    public Move[] getPossibleMoves() {
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
                    listPossibleMoves.add(new Move(currentX, currentY, tempX, tempY));
                }
            } else if (direction == 1) {
                while (tempX < 7  && tempY < 7) {
                    tempX++;
                    tempY++;
                    listPossibleMoves.add(new Move(currentX, currentY, tempX, tempY));
                }
            } else if (direction == 2) {
                while (tempX > 0 && tempY < 7)  {
                    tempX--;
                    tempY++;
                    listPossibleMoves.add(new Move(currentX, currentY, tempX, tempY));
                }
            } else if (direction == 3) {
                while (tempX > 0 && tempY > 0) {
                    tempX--;
                    tempY--;
                    listPossibleMoves.add(new Move(currentX, currentY, tempX, tempY));
                }
            }
//            else if (direction == 4) {
//                while (tempX > 0 && tempY > 0) {
//                    tempX--;
//                    tempY--;
//                    listPossibleMoves.add(new Move(currentX, currentY, tempX, tempY));
//                }
//            } else if (direction == 5) {
//                while (tempX > 0 && tempY > 0) {
//                    tempX--;
//                    tempY--;
//                    listPossibleMoves.add(new Move(currentX, currentY, tempX, tempY));
//                }
//            } else if (direction == 6) {
//                while (tempX > 0 && tempY > 0) {
//                    tempX--;
//                    tempY--;
//                    listPossibleMoves.add(new Move(currentX, currentY, tempX, tempY));
//                }
//            } else if (direction == 7) {
//                while (tempX > 0 && tempY > 0) {
//                    tempX--;
//                    tempY--;
//                    listPossibleMoves.add(new Move(currentX, currentY, tempX, tempY));
//                }
//            }


        }

        Move[] possibleMoves = new Move[listPossibleMoves.size()];
        for(int i = 0; i < listPossibleMoves.size(); i++) {
            possibleMoves[i] = listPossibleMoves.get(i);
        }
        return possibleMoves;
    }
}
