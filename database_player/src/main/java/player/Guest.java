package player;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import player.enums.ChessboardStyle;
import player.enums.PieceColor;
import player.enums.FiguresStyle;

public class Guest extends Player {

    String name;

    public Guest(PieceColor pieceColor, FiguresStyle figuresStyle, ChessboardStyle chessboardStyle, int score, String name) {
        super(pieceColor, figuresStyle, chessboardStyle, score);
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Guest guest = (Guest) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(name, guest.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(name)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .toString();
    }
}
