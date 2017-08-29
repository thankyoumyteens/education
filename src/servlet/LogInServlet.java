package servlet;

import exception.UserException;
import model.Profile;
import model.User;
import net.sf.json.JSONObject;
import service.ProfileService;
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
        ProfileService profileService = new ProfileService();
        String status = "";
        String message = "";
        Profile profile = null;
        User user = null;
        try {
            if (service.userExist(userId, password)) {
                status = "OK"; // 登陆成功
                message = "登陆成功";
                user = service.getUser(userId, password);
                profile = profileService.getProfileByUid(userId);
            } else {
                status = "NO";
                message = "用户名或密码错误";
            }
        } catch (UserException e) {
            message = e.getMessage();
        } finally {
            JSONObject object = new JSONObject();
            object.put("status", status);
            object.put("message", message);
            object.put("profile", profile);
            object.put("user", user);
            response.getWriter().write(object.toString());
        }
    }
}
