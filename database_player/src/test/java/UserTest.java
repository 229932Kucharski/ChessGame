import dao.UserDao;
import org.junit.Assert;
import org.junit.Test;
import player.User;
import player.enums.BoardDesign;
import player.enums.PieceDesign;
import player.manager.DatabaseManager;
import player.password.PasswordHashing;

import java.sql.SQLException;

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

    @Test
    public void createDatabase() {

        try {
            DatabaseManager databaseManager = new DatabaseManager();
            databaseManager.createDatabase();
        } catch (SQLException ignored) {

        }
        try {
            DatabaseManager databaseManager = new DatabaseManager();
            databaseManager.createUser();
        } catch (SQLException ignored) {
        }
    }

    @Test
    public void userAddOperation() {
        try {
            UserDao userDao = new UserDao();

            User user = userDao.findByLogin("gelo2424");
            if(!(user == null)) {
                return;
            }
            user = new User(null , PieceDesign.DEFAULT, BoardDesign.DEFAULT, 0, "Gelo", "gelo2424", "qwerty");
            userDao.add(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void userDeleteOperation() {
        try {
            UserDao userDao = new UserDao();
            User user = new User(null , PieceDesign.DEFAULT, BoardDesign.DEFAULT, 0, "Gelo", "gelo2424", "qwerty");
            userDao.delete(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
