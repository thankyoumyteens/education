package servlet.admin;

import exception.UserException;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Admin on 2017/8/30.
 */
@WebServlet(name = "AdminPermissionServlet", urlPatterns = "/adminPermission")
public class AdminPermissionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid = request.getParameter("uid");
        String msg = "";
        UserService service = new UserService();
        try {
            if (service.givePermission(1, uid)) {
                msg = "完成";
            } else {
                msg = "用户不存在";
            }
        } catch (UserException e) {
            msg = e.getMessage();
        }
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("admin/permission.jsp").forward(request, response);
    }
}
