package servlet;

import exception.UserException;
import net.sf.json.JSONObject;
import service.ProfileService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Admin on 2017/8/29.
 */
@WebServlet(name = "ProfileServlet", urlPatterns = "/updateProfile")
public class ProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tabIndexStr = request.getParameter("tabIndex");
        String uid = request.getParameter("uid");
        int tabIndex = Integer.parseInt(tabIndexStr);
        String status = "";
        String message = "";
        String mail = null;
        String nickname = null;
        String name = null;
        String gender = null;
        String idCard = null;
        String schoolCard = null;
        String address = null;
        String qqAccount = null;
        String wechatAccount = null;
        String weiboAccount = null;
        ProfileService service = new ProfileService();
        try {
            switch (tabIndex) {
                case 1:
                    mail = request.getParameter("mail");
                    service.updateProfile(uid, mail, uid);
                    break;
                case 2:
                    nickname = request.getParameter("nickname");
                    name = request.getParameter("name");
                    gender = request.getParameter("gender");
                    idCard = request.getParameter("idCard");
                    schoolCard = request.getParameter("schoolCard");
                    address = request.getParameter("address");
                    service.updateProfile(uid, nickname, name, gender, idCard, schoolCard, address, uid);
                    break;
                case 3:
                    qqAccount = request.getParameter("qqAccount");
                    wechatAccount = request.getParameter("wechatAccount");
                    weiboAccount = request.getParameter("weiboAccount");
                    service.updateProfile(uid, qqAccount, wechatAccount, weiboAccount, uid);
                    break;
            }
            status = "OK";
            message = "完成";
        } catch (UserException e) {
            status = "NO";
            message = e.getMessage();
        }
        JSONObject object = new JSONObject();
        object.put("status", status);
        object.put("message", message);
        response.getWriter().write(object.toString());
    }
}
