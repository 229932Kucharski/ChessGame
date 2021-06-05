
public class King extends Piece {

    private boolean moved = false;

    public King(int x, int y, PieceColor color, int value) {
        super(x, y, color, value);
    }

    @Override
    public Move[] getPossibleMoves() {
        Move[] possibleMoves = new Move[8];
        int tempX = 0;
        int tempY = 0;
        int counter = 0;

        for (int direction = 0; direction < 8; direction++) {
            tempX = currentX;
            tempY = currentY;

            if (direction == 0) {
                if (tempX > 0 && tempY > 0) {
                    tempX--;
                    tempY--;
                    possibleMoves[counter] = new Move(currentX, currentY, tempX, tempY);
                }
            } else if (direction == 1) {
                if ( tempY > 0) {
                    tempY--;
                    possibleMoves[counter] = new Move(currentX, currentY, tempX, tempY);
                    counter++;
                }
            } else if (direction == 2) {
                if (tempX < 7 && tempY > 0) {
                    tempX++;
                    tempY--;
                    possibleMoves[counter] = new Move(currentX, currentY, tempX, tempY);
                    counter++;
                }
            } else if (direction == 3) {
                if (tempX < 7 ) {
                    tempX++;
                    possibleMoves[counter] = new Move(currentX, currentY, tempX, tempY);
                    counter++;
                }
            } else if (direction == 4) {
                if (tempX < 7 && tempY < 7) {
                    tempX++;
                    tempY++;
                    possibleMoves[counter] = new Move(currentX, currentY, tempX, tempY);
                    counter++;
                }
            } else if (direction == 5) {
                if (tempY < 7) {
                    tempY++;
                    possibleMoves[counter] = new Move(currentX, currentY, tempX, tempY);
                    counter++;
                }
            } else if (direction == 6) {
                if (tempX > 0 && tempY < 7) {
                    tempX--;
                    tempY++;
                    possibleMoves[counter] = new Move(currentX, currentY, tempX, tempY);
                    counter++;
                }
            } else if (direction == 7) {
                if (tempX > 0 ) {
                    tempX--;
                    possibleMoves[counter] = new Move(currentX, currentY, tempX, tempY);
                    counter++;
                }
            }
        }
        return possibleMoves;
    }

    public void setMovedTrue() {
        moved = true;
    }

    public boolean wasMoved() {
        return moved;
    }

}
