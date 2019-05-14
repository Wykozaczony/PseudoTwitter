package twitter.servlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class UserDao {


    public boolean isValid(String username, String password) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnection.iinitializeDatabase();
            statement = connection.prepareStatement("select count(*) as cnt from USER where NAME=? and PASSWORD=?");
            statement.setString(1, username);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            resultSet.next();
            int userCounter = resultSet.getInt("cnt");
            return userCounter == 1;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public Set<String> getFollowedUsers(String followerName){
        Set<String> followedUsers = new HashSet<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;


        try {
            connection = DatabaseConnection.iinitializeDatabase();
            statement = connection.prepareStatement("select USER_NAME from follower where FOLLOWER_NAME=?");
            statement.setString(1,followerName);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                followedUsers.add(resultSet.getString("USER_NAME"));
            }return followedUsers;
        } catch (Exception e) {
            e.printStackTrace();
            return followedUsers;
        }finally {
            DatabaseConnection.cleanUp(resultSet,connection,statement);
        }
    }






}
