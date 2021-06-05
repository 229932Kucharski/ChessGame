
public class Rook extends Piece {

    private boolean moved = false;

    public Rook(int x, int y, PieceColor color, int value) {
        super(x, y, color, value);
    }

    @Override
    public Move[] getPossibleMoves() {
        Move[] possibleMoves = new Move[0];
        Move[] tmp = new Move[8];
        int counter = 0;
        int tempX = 0;
        int tempY = 0;

        for(int direction = 0; direction < 4; direction++) {
            tempX = currentX;
            tempY = currentY;
            counter = 0;

            if(direction == 0) {
                while(tempX < 7) {
                    tempX++;
                    tmp[counter] = new Move(currentX, currentY, tempX, tempY);
                    counter++;
                }
            } else if(direction == 1) {
                while(tempX > 0) {
                    tempX--;
                    tmp[counter] = new Move(currentX, currentY, tempX, tempY);
                    counter++;
                }
            } else if(direction == 2) {
                while(tempY < 7) {
                    tempY++;
                    tmp[counter] = new Move(currentX, currentY, tempX, tempY);
                    counter++;
                }
            } else if(direction == 3) {
                while(tempY > 0) {
                    tempY--;
                    tmp[counter] = new Move(currentX, currentY, tempX, tempY);
                    counter++;
                }
            }

            int oldSize = possibleMoves.length;
            Move[] tmpOldCopy = new Move[oldSize];
            System.arraycopy(possibleMoves, 0, tmpOldCopy, 0, oldSize);
            possibleMoves = new Move[oldSize + counter];
            System.arraycopy(tmpOldCopy, 0, possibleMoves, 0, oldSize);
            System.arraycopy(tmp, 0, possibleMoves, oldSize, tmp.length);
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
