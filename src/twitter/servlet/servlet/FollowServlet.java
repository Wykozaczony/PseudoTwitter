package twitter.servlet.servlet;

import model.Tweet;
import twitter.servlet.dao.TweetDao;
import twitter.servlet.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

@WebServlet(name = "follow", value = "/follow")
public class FollowServlet extends HttpServlet {
    UserDao userDao = new UserDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<String> followers = userDao.getFollowedUsers((String)req.getSession().getAttribute("login"));
        req.setAttribute("followers",followers);
        req.getRequestDispatcher("WEB-INF/view/users.jsp");

    }
}
