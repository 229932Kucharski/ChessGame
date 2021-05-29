package player;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import player.enums.ChessboardStyle;
import player.enums.PieceColor;
import player.enums.FiguresStyle;

public abstract class Player {

    private PieceColor pieceColor;
    private FiguresStyle figuresStyle;
    private ChessboardStyle chessboardStyle;
    private int score;

    public Player(PieceColor pieceColor, FiguresStyle figuresStyle, ChessboardStyle chessboardStyle, int score) {
        this.pieceColor = pieceColor;
        this.figuresStyle = figuresStyle;
        this.chessboardStyle = chessboardStyle;
        this.score = score;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public void setPieceColor(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public FiguresStyle getPieceDesign() {
        return figuresStyle;
    }

    public void setPieceDesign(FiguresStyle figuresStyle) {
        this.figuresStyle = figuresStyle;
    }

    public ChessboardStyle getBoardDesign() {
        return chessboardStyle;
    }

    public void setBoardDesign(ChessboardStyle chessboardStyle) {
        this.chessboardStyle = chessboardStyle;
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
                .append(figuresStyle, player.figuresStyle)
                .append(chessboardStyle, player.chessboardStyle)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(pieceColor)
                .append(figuresStyle)
                .append(chessboardStyle)
                .append(score)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("pieceColor", pieceColor)
                .append("pieceDesign", figuresStyle)
                .append("boardDesign", chessboardStyle)
                .append("score", score)
                .toString();
    }
}
