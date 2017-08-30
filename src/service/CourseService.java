package service;

import dao.CourseDao;
import exception.UserException;
import model.Course;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Admin on 2017/8/25.
 */
public class CourseService {
    private CourseDao dao = new CourseDao();

    public List<Course> getAllByCategory(int category) throws UserException {
        try {
            if (category < 0) {
                return dao.getAll();
            } else {
                return dao.getAllByCategory(category);
            }
        } catch (SQLException e) {
            //
            throw new UserException("获取数据失败");
        }
    }

    public boolean insert(Course course) throws UserException {
        try {
            return dao.insert(course) > 0;
        } catch (SQLException e) {
            //
            throw new UserException("上传失败");
        }
    }
}
