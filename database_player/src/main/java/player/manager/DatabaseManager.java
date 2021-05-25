package player.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager implements AutoCloseable{

    private final String url = "jdbc:sqlserver://localhost";
    private final String username = "sa";
    private final String password = "qwerty";
    private final Connection connection;

    public DatabaseManager( ) throws SQLException {
        connection = prepareConnection();
    }

    private Connection prepareConnection() throws SQLException {
        Connection connection = null;
        connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    public void createDatabase() throws SQLException {
        Statement s = connection.createStatement();
        s.executeUpdate("CREATE DATABASE chessGameDB");
    }

    public void createUser() throws SQLException {
        String createUser = "USE chessGameDB;" +
                "CREATE TABLE player(" +
                "userId int IDENTITY(1,1) PRIMARY KEY," +
                "name varchar(50) NOT NULL," +
                "login varchar(50) NOT NULL," +
                "password binary(100) NOT NULL," +
                "boardDesign varchar(50) NOT NULL," +
                "pieceDesign varchar(50) NOT NULL" +
                ");";
        Statement s = connection.createStatement();
        s.executeUpdate(createUser);
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
}
