import org.junit.Assert;
import org.junit.Test;
import player.User;
import player.enums.ChessboardStyle;
import player.enums.FiguresStyle;
import player.password.PasswordHashing;

public class UserTest {

    @Test
    public void createUserTest() {
        User user = new User(null , FiguresStyle.classic, ChessboardStyle.classic,
                0, "Gelo", "gelo2424", "qwerty", 0, 0, 0 ,5, null);
        Assert.assertEquals(user.getLogin(), "gelo2424");
        Assert.assertEquals(user.getName(), "Gelo");
        Assert.assertArrayEquals(user.getPassword(), PasswordHashing.hashPassword("qwerty"));
        Assert.assertEquals(user.getBoardDesign(), ChessboardStyle.classic);
        Assert.assertEquals(user.getPieceDesign(), FiguresStyle.classic);
        Assert.assertNull(user.getPieceColor());
    }

    @Test
    public void userSetterTest() {
        User user = new User(null , FiguresStyle.classic, ChessboardStyle.classic,
                0, "Gelo", "gelo2424", "qwerty", 0, 0, 0 ,5, null);
        user.setPassword("alamakota");
        user.setName("NewName");
        Assert.assertEquals(user.getName(), "NewName");
        Assert.assertArrayEquals(user.getPassword(), PasswordHashing.hashPassword("alamakota"));
    }

//    @Test
//    public void createDatabaseTest() {
//
//        try {
//            DatabaseManager databaseManager = new DatabaseManager();
//            databaseManager.createDatabase();
//        } catch (SQLException ignored) {
//
//        }
//        try {
//            DatabaseManager databaseManager = new DatabaseManager();
//            databaseManager.createUser();
//        } catch (SQLException ignored) {
//        }
//    }
//
//    @Test
//    public void userAddOperationTest() throws SQLException {
//        UserDao userDao = new UserDao();
//        User user = userDao.findByLogin("gelo2424");
//        if(!(user == null)) {
//            return;
//        }
//        user = new User(null , PieceDesign.DEFAULT, BoardDesign.DEFAULT,
//                0, "Gelo", "gelo2424", "qwerty", 2, 0, 1, 3);
//        userDao.add(user);
//    }
//
//    @Test
//    public void userDeleteOperationTest() throws SQLException {
//        UserDao userDao = new UserDao();
//        User user = new User(null , PieceDesign.DEFAULT, BoardDesign.DEFAULT,
//                0, "Gelo", "gelo2424", "qwerty", 2, 0, 1, 3);
//        userDao.delete(user);
//    }
//
//    @Test
//    public void registerNewUserTest() throws SQLException {
//        UserDao userDao = new UserDao();
//        RegistrationManager.registerUser("Test", "testowy", "qwerty");
//        User user = userDao.findByLogin("testowy");
//        Assert.assertEquals(user.getName(), "Test");
//        Assert.assertThrows(IllegalArgumentException.class, () -> {
//            RegistrationManager.registerUser("Test", "testowy", "qwerty");
//        });
//        userDao.delete(user);
//    }
//
//    @Test
//    public void loginUserTest() throws SQLException {
//        UserDao userDao = new UserDao();
//        RegistrationManager.registerUser("Test", "testowy", "qwerty");
//        Assert.assertThrows(IllegalArgumentException.class, () -> {
//            LoginManager.login("abc" ,"qwerty");
//        });
//        LoginManager.login("testowy" ,"qwerty");
//        Assert.assertEquals("Test", LoginManager.getLoggedUser().getName());
//        userDao.delete(LoginManager.getLoggedUser());
//    }

}
