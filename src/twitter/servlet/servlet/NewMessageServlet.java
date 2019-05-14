package twitter.servlet.servlet;

import twitter.servlet.dao.TweetDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "newTweet", value = "/addNewTweet")

public class NewMessageServlet extends HttpServlet {

TweetDao tweetDao = new TweetDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("post");
        String username = (String) req.getSession().getAttribute("login");
                tweetDao.newTweet(message,username);
        req.getRequestDispatcher("message").forward(req, resp);
    }
}
