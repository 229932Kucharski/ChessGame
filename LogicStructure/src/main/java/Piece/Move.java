package Piece;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class Move {

//    Piece moveOwner;
    private boolean attack;

    private final int currentX;
    private final int currentY;

    private final int nextX;
    private final int nextY;

    public Move(int currentX, int currentY, int nextX, int nextY) {
        this.currentX = currentX;
        this.currentY = currentY;
        this.nextX = nextX;
        this.nextY = nextY;
    }

    public int getCurrentX() {
        return currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public int getNextX() {
        return nextX;
    }

    public int getNextY() {
        return nextY;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if(!(obj instanceof Move)) {
            return false;
        }
        Move move = (Move)obj;

        return new EqualsBuilder()
                .append(currentX, move.currentX)
                .append(currentY, move.currentY)
                .append(nextX, move.nextX)
                .append(nextY, move.nextY)
                .isEquals();
    }

    public boolean isDestination(Move move){

        if((currentX == move.nextX) && (currentY == move.nextY)){
            return true;
        }
        return false;
    }

    public boolean isAttack() {
        return attack;
    }

    public void setAttack(boolean attack) {
        this.attack = attack;
    }
}
