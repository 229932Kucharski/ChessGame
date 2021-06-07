package player;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import player.enums.ChessboardStyle;
import player.enums.PieceColor;
import player.enums.FiguresStyle;
import player.password.PasswordHashing;

public class User extends Player {

    private String name;
    private final String login;
    private byte[] password;
    private final Statistic statistic;
    private byte[] cover;

    public User(PieceColor pieceColor, FiguresStyle figuresStyle, ChessboardStyle chessboardStyle, int score, String name, String login, String password,
                int checkMate, int staleMate, int loses, int played, byte[] cover) {
        super(pieceColor, figuresStyle, chessboardStyle, score);
        this.name = name;
        this.login = login;
        setPassword(password);
        statistic = new Statistic(checkMate, staleMate, loses, played);
        this.cover = cover;
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

    public Statistic getStatistic() {
        return statistic;
    }

    public byte[] getCover() {
        return cover;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = PasswordHashing.hashPassword(password);
    }

    public void setCover(byte[] cover) {
        this.cover = cover;
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
                .toString();
    }
}
