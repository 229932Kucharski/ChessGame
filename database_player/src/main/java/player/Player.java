package player;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import player.enums.BoardDesign;
import player.enums.PieceColor;
import player.enums.PieceDesign;

public class Player {

    PieceColor pieceColor;
    PieceDesign pieceDesign;
    BoardDesign boardDesign;
    int score;

    public Player(PieceColor pieceColor, PieceDesign pieceDesign, BoardDesign boardDesign, int score) {
        this.pieceColor = pieceColor;
        this.pieceDesign = pieceDesign;
        this.boardDesign = boardDesign;
        this.score = score;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public void setPieceColor(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public PieceDesign getPieceDesign() {
        return pieceDesign;
    }

    public void setPieceDesign(PieceDesign pieceDesign) {
        this.pieceDesign = pieceDesign;
    }

    public BoardDesign getBoardDesign() {
        return boardDesign;
    }

    public void setBoardDesign(BoardDesign boardDesign) {
        this.boardDesign = boardDesign;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return new EqualsBuilder()
                .append(score, player.score)
                .append(pieceColor, player.pieceColor)
                .append(pieceDesign, player.pieceDesign)
                .append(boardDesign, player.boardDesign)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(pieceColor)
                .append(pieceDesign)
                .append(boardDesign)
                .append(score)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("pieceColor", pieceColor)
                .append("pieceDesign", pieceDesign)
                .append("boardDesign", boardDesign)
                .append("score", score)
                .toString();
    }
}
