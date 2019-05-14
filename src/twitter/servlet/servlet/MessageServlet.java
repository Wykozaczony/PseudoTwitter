package twitter.servlet.servlet;

import model.Tweet;
import twitter.servlet.dao.TweetDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "message", value = "/message")

public class MessageServlet extends HttpServlet {

    TweetDao tweetDao = new TweetDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Tweet> tweets = tweetDao.getFollowedTweets((String)req.getSession().getAttribute("login"));
        req.setAttribute("tweets", tweets);
        req.getRequestDispatcher("WEB-INF/view/messages.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
