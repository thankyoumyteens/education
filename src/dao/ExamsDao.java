package dao;

import model.Exams;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.C3P0Util;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Admin on 2017/8/25.
 */
public class ExamsDao {
    public List<Exams> getAll() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        String sql = "select * from t_exams";
        return queryRunner.query(sql, new BeanListHandler<>(Exams.class));
    }

    public int insert(Exams exams) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        String sql = "insert into t_exams(title, link) values(?,?)";
        return queryRunner.update(sql,
                exams.getTitle(), exams.getLink());
    }
}
