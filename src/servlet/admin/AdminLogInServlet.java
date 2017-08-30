package servlet.admin;

import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Admin on 2017/8/30.
 */
@WebServlet(name = "AdminLogInServlet", urlPatterns = "/adminLogin")
public class AdminLogInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        if ("admin".equals(userId) && "Admin123".equals(password)) {
            HttpSession session = request.getSession();
            User user = new User();
            user.setUid(userId);
            user.setPwd(password);
            session.setAttribute("admin", user);
            response.sendRedirect("admin/index.jsp");
        } else {
            // 登陆失败
            request.setAttribute("msg", "用户名或密码错误");
            request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
        }
    }
}
