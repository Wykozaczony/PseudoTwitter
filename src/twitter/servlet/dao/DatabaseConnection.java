package twitter.servlet.dao;

import java.sql.*;

public class DatabaseConnection {

   private static final String dbDriver = "com.mysql.jdbc.Driver";
   private static final String dbURL = "jdbc:mysql://localhost:3306/twitter?serverTimezone=Europe/Warsaw";
   private static final String dbUsername = "sda";
   private static final String dbPassword = "sda";


   protected static Connection iinitializeDatabase() throws ClassNotFoundException, SQLException {
       Class.forName(dbDriver);
       Connection connection = DriverManager.getConnection(dbURL,dbUsername,dbPassword);
       return connection;
   }

    protected static void cleanUp(ResultSet resultSet, Connection connection, PreparedStatement statement) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        cleanUp(connection, statement);
    }

    protected static void cleanUp(Connection connection, PreparedStatement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
