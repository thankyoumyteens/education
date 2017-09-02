package servlet.admin;

import exception.UserException;
import model.Exams;
import model.Simulation;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.ExamsService;
import service.SimulationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 2017/9/2.
 */
@WebServlet(name = "AdminUploadExamsServlet", urlPatterns = "/adminUploadExams")
public class AdminUploadExamsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String savePath = this.getServletContext().getRealPath("/exams");
        String type = null;
        String title = null;
        String link = null;
        File file = new File(savePath);
        if (!file.exists() && !file.isDirectory()) {
            System.out.println(savePath + "目录不存在，需要创建");
            //创建目录
            file.mkdir();
        }
        String message = "";
        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setHeaderEncoding("UTF-8");
            if (!ServletFileUpload.isMultipartContent(request)) {
                return;
            }
            List<FileItem> list = upload.parseRequest(request);
            for (FileItem item : list) {
                if (item.isFormField()) {
                    String name = item.getFieldName();
                    String value = item.getString("UTF-8");
                    switch (name) {
                        case "title":
                            title = value;
                            break;
                        case "type":
                            type = value;
                            break;
                    }
                } else {
                    String filename = item.getName();
                    if (filename == null || filename.trim().equals("")) {
                        continue;
                    }
                    String extension = filename.substring(filename.lastIndexOf("."));
                    filename = "e" + new Date().getTime() + extension;

                    link = "/exams/" + filename;

                    InputStream in = item.getInputStream();
                    FileOutputStream out = new FileOutputStream(savePath + System.getProperty("file.separator") + filename);
                    byte buffer[] = new byte[1024];
                    int len = 0;
                    while ((len = in.read(buffer)) > 0) {
                        out.write(buffer, 0, len);
                    }
                    in.close();
                    out.close();
                    item.delete();
                    message = "文件上传成功！";
                }
            }
        } catch (FileUploadException e) {
            message = "文件上传失败！";
        }
        if ("文件上传成功！".equals(message)) {
            // 将记录添加到数据库
            if (type.equals("exams")) {
                ExamsService service = new ExamsService();
                Exams exams = new Exams();
                exams.setTitle(title);
                exams.setLink(link);
                try {
                    service.insert(exams);
                } catch (UserException e) {
                    message = e.getMessage();
                }
            } else {
                SimulationService service = new SimulationService();
                Simulation simulation = new Simulation();
                simulation.setTitle(title);
                simulation.setLink(link);
                try {
                    service.insert(simulation);
                } catch (UserException e) {
                    message = e.getMessage();
                }
            }
        }
        request.setAttribute("message", message);
        request.getRequestDispatcher("admin/uploadExams.jsp").forward(request, response);
    }
}
