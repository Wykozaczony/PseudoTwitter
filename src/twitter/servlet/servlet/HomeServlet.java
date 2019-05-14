package twitter.servlet.servlet;

import twitter.servlet.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HomeServlet", urlPatterns = {"", "/login"})
public class HomeServlet extends HttpServlet {

    private static final String USERNAME = "login";
    private static final String PASSWORD = "password";

    UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/view/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter(USERNAME);
        String password = req.getParameter(PASSWORD);

        if (userDao.isValid(username, password)) {
            req.getSession().setAttribute(USERNAME, username);
            req.getRequestDispatcher("message").forward(req, resp);
        } else {
            req.setAttribute("error","Login lub haslo niepoprawne politycznie");
            req.getRequestDispatcher("WEB-INF/view/login.jsp").forward(req,resp);
        }


    }
}
