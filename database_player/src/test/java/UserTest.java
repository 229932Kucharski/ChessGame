import org.junit.Assert;
import org.junit.Test;
import player.User;
import player.enums.BoardDesign;
import player.enums.PieceColor;
import player.enums.PieceDesign;
import player.password.PasswordHashing;

public class UserTest {

    @Test
    public void createUserTest() {
        User user = new User(null , PieceDesign.DEFAULT, BoardDesign.DEFAULT, 0, "Gelo", "gelo2424", "qwerty");
        Assert.assertEquals(user.getLogin(), "gelo2424");
        Assert.assertEquals(user.getName(), "Gelo");
        Assert.assertArrayEquals(user.getPassword(), PasswordHashing.hashPassword("qwerty"));
        Assert.assertEquals(user.getBoardDesign(), BoardDesign.DEFAULT);
        Assert.assertEquals(user.getPieceDesign(), PieceDesign.DEFAULT);
        Assert.assertNull(user.getPieceColor());
    }

    @Test
    public void userSetterTest() {
        User user = new User(null , PieceDesign.DEFAULT, BoardDesign.DEFAULT, 0, "Gelo", "gelo2424", "qwerty");
        user.setPassword("alamakota");
        user.setName("NewName");
        Assert.assertEquals(user.getName(), "NewName");
        Assert.assertArrayEquals(user.getPassword(), PasswordHashing.hashPassword("alamakota"));
    }

}
