package dao;

import model.Course;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.C3P0Util;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Admin on 2017/8/25.
 */
public class CourseDao {
    public List<Course> getAllByCategory(int category) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        String sql = "select * from t_course where category=?";
        return queryRunner.query(sql, new BeanListHandler<>(Course.class),
                category);
    }

    public List<Course> getAll() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        String sql = "select * from t_course";
        return queryRunner.query(sql, new BeanListHandler<>(Course.class));
    }

    public int insert(Course course) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        String sql = "insert into t_course(category, title, img, link) values(?,?,?,?)";
        return queryRunner.update(sql,
                course.getCategory(), course.getTitle(), course.getImg(), course.getLink());
    }
}
