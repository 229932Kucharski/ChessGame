package dao;

import player.User;
import player.enums.BoardDesign;
import player.enums.PieceDesign;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for user database operation, add, delete, update, fin
 */
public class UserDao implements Dao<User> {

    private final String url = "jdbc:sqlserver://localhost;databaseName=chessGameDB";
    private final String username = "sa";
    private final String password = "qwerty";
    private final Connection connection;

    public UserDao( ) throws SQLException {
        connection = prepareConnection();
    }

    private Connection prepareConnection() throws SQLException {
        Connection connection = null;
        connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    @Override
    public void add(User obj) throws SQLException {
        String addUser ="insert into player(name, login, password, boardDesign, pieceDesign, checkMate, " +
                "staleMate, loses, played) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(addUser);
        preparedStatement.setString(1, obj.getName());
        preparedStatement.setString(2, obj.getLogin());
        preparedStatement.setBytes(3, obj.getPassword());
        preparedStatement.setString(4, obj.getBoardDesign().toString());
        preparedStatement.setString(5, obj.getPieceDesign().toString());
        preparedStatement.setInt(6, obj.getStatistic().getCheckMate());
        preparedStatement.setInt(7, obj.getStatistic().getStaleMate());
        preparedStatement.setInt(8, obj.getStatistic().getLoses());
        preparedStatement.setInt(9, obj.getStatistic().getPlayed());
        preparedStatement.executeUpdate();

    }

    public User findByLogin(String loginn) throws SQLException {
        User user = null;
        String getUser = "SELECT * FROM player WHERE login=?";
        PreparedStatement preparedStatement = connection.prepareStatement(getUser);
        preparedStatement.setString(1, loginn);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            String name = resultSet.getString(2);
            String login = resultSet.getString(3);
            byte[] pass = resultSet.getBytes(4);
            String boardDesign = resultSet.getString(5);
            String pieceDesign = resultSet.getString(6);
            int checkMate = resultSet.getInt(7);
            int staleMate = resultSet.getInt(8);
            int loses = resultSet.getInt(9);
            int played = resultSet.getInt(10);
            user = new User(null, PieceDesign.valueOf(pieceDesign), BoardDesign.valueOf(boardDesign),
                    0, name, login, password, checkMate, staleMate, loses, played);
        }
        return user;
    }

    @Override
    public User findById(int id) throws SQLException {
        User user = null;
        String getUser = "SELECT * FROM player WHERE userId=?";
        PreparedStatement preparedStatement = connection.prepareStatement(getUser);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            String name = resultSet.getString(2);
            String login = resultSet.getString(3);
            byte[] pass = resultSet.getBytes(4);
            String boardDesign = resultSet.getString(5);
            String pieceDesign = resultSet.getString(6);
            int checkMate = resultSet.getInt(7);
            int staleMate = resultSet.getInt(8);
            int loses = resultSet.getInt(9);
            int played = resultSet.getInt(10);
            user = new User(null, PieceDesign.valueOf(pieceDesign), BoardDesign.valueOf(boardDesign),
                    0, name, login, password, checkMate, staleMate, loses, played);
        }
        return user;
    }

    @Override
    public List<User> findAll() throws SQLException {
        String getAllUsers = "SELECT * FROM player";
        List<User> users = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(getAllUsers);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            String name = resultSet.getString(2);
            String login = resultSet.getString(3);
            byte[] pass = resultSet.getBytes(4);
            String boardDesign = resultSet.getString(5);
            String pieceDesign = resultSet.getString(6);
            int checkMate = resultSet.getInt(7);
            int staleMate = resultSet.getInt(8);
            int loses = resultSet.getInt(9);
            int played = resultSet.getInt(10);
            User user = new User(null, PieceDesign.valueOf(pieceDesign), BoardDesign.valueOf(boardDesign),
                    0, name, login, password, checkMate, staleMate, loses, played);
            users.add(user);
        }
        return users;
    }

    @Override
    public void delete(User obj) throws SQLException {
        String deleteUser ="DELETE FROM player WHERE login=?";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteUser);
        preparedStatement.setString(1, obj.getLogin());
        preparedStatement.executeUpdate();

    }

    @Override
    public void update(User obj) throws SQLException {
        String updateUser ="UPDATE player SET name = ? WHERE login = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(updateUser);
        preparedStatement.setString(1, obj.getName());
        preparedStatement.setString(2, obj.getLogin());
        preparedStatement.executeUpdate();

    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
}
