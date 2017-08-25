package servlet;

import exception.UserException;
import model.Exams;
import net.sf.json.JSONArray;
import service.ExamsService;
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
@WebServlet(name = "ExamsServlet", urlPatterns = "/exams")
public class ExamsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExamsService service = new ExamsService();
        try {
            List<Exams> examsList = service.getAll();
            JSONArray array = JSONHelper.getJSONArrayFromList(examsList);
            response.getWriter().write(array.toString());
        } catch (UserException e) {
            response.getWriter().write(e.getMessage());
        }
    }
}
