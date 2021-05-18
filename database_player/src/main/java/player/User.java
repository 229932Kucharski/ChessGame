package player;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import player.enums.BoardDesign;
import player.enums.PieceColor;
import player.enums.PieceDesign;

public class User extends Player {

    String name;
    String login;
    byte[] password;

    public User(PieceColor pieceColor, PieceDesign pieceDesign, BoardDesign boardDesign, int score, String name, String login, byte[] password) {
        super(pieceColor, pieceDesign, boardDesign, score);
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(name, user.name)
                .append(login, user.login)
                .append(password, user.password)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(name)
                .append(login)
                .append(password)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("login", login)
                .append("password", password)
                .append("pieceColor", pieceColor)
                .append("pieceDesign", pieceDesign)
                .append("boardDesign", boardDesign)
                .append("score", score)
                .toString();
    }
}
