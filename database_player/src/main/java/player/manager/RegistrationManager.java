package player.manager;

import dao.UserDao;
import player.User;
import player.enums.BoardDesign;
import player.enums.PieceDesign;

import java.sql.SQLException;

/**
 * Class responsible for user registration
 */
public class RegistrationManager {

    /**
     * Check if login is free
     * @param login login of new user that want to register
     * @return true if login is free, false if login is in use
     */
    private static boolean isLoginFree(String login) throws SQLException {
        User user = null;
        try(UserDao userDao = new UserDao()) {
            user = userDao.findByLogin(login);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user == null;
    }

    /**
     * Register new user
     * @param name name of new user
     * @param login login of new user
     * @param pass password of new user
     */
    public static void registerUser(String name, String login, String pass) throws SQLException {
        if (!isLoginFree(login)) {
            throw new IllegalArgumentException("Login is already in use");
        }
        User user = new User(null, PieceDesign.DEFAULT, BoardDesign.DEFAULT, 0, name, login, pass, 0, 0, 0, 0);
        try(UserDao userDao = new UserDao()) {
            userDao.add(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
