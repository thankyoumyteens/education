package servlet;

import exception.UserException;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Admin on 2017/8/24.
 */
@WebServlet(name = "LogInServlet", urlPatterns = "/login")
public class LogInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        UserService service = new UserService();
        try {
            if (service.userExist(userId, password)) {
                response.getWriter().write("OK");
            } else {
                response.getWriter().write("用户名或密码错误");
            }
        } catch (UserException e) {
            response.getWriter().write(e.getMessage());
        }

    }
}
