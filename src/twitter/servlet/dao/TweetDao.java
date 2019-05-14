package twitter.servlet.dao;

import model.Tweet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TweetDao {

    UserDao userDao = new UserDao();

    public List<Tweet> getFollowedTweets (String username){
        Set<String> followedUser = userDao.getFollowedUsers(username);
        followedUser.add(username);
        List<Tweet> tweets = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;


        try {
            connection = DatabaseConnection.iinitializeDatabase();

            statement = connection.prepareStatement(("SELECT * FROM tweet where USER_NAME IN('" +
                    String.join("','", followedUser) + "')"));
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                Tweet tweet = new Tweet();
                tweet.setId(resultSet.getInt("ID"));
                tweet.setUsername(resultSet.getString("USER_NAME"));
                tweet.setPublishedAt(resultSet.getTimestamp("PUBLISHED_AT"));
                tweet.setMessage(resultSet.getString("MESSAGE"));
                tweets.add(tweet);
            }return tweets;
        } catch (Exception e) {
            e.printStackTrace();
            return tweets;
    }finally {
            DatabaseConnection.cleanUp(resultSet,connection,statement);
        }
        }

        public void newTweet(String text,String username){
            Connection connection = null;
            PreparedStatement statement = null;

            try {
                connection = DatabaseConnection.iinitializeDatabase();
                statement = connection.prepareStatement("insert into tweet(USER_NAME, MESSAGE) values(?,?) ");
                statement.setString(1,username);
                statement.setString(2,text);
                statement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                DatabaseConnection.cleanUp(connection,statement);
            }
        }

}
