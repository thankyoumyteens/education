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
        List<Exams> examsList =  queryRunner.query(sql, new BeanListHandler<>(Exams.class));
        return examsList;
    }
}
