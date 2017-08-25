package servlet;

import exception.UserException;
import model.Course;
import net.sf.json.JSONArray;
import service.CourseService;
import util.JSONHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Admin on 2017/8/25.
 */
@WebServlet(name = "CourseServlet", urlPatterns = "/course")
public class CourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoryStr = request.getParameter("category");
        int category = Integer.parseInt(categoryStr);
        CourseService service = new CourseService();
        try {
            List<Course> list = service.getAllByCategory(category);
            JSONArray array = JSONHelper.getJSONArrayFromList(list);
            response.getWriter().write(array.toString());
        } catch (UserException e) {
            response.getWriter().write(e.getMessage());
        }
    }
}
