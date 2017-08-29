package dao;

import model.Simulation;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.C3P0Util;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Admin on 2017/8/29.
 */
public class SimulationDao {
    public List<Simulation> getAll() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        String sql = "select * from t_simulation";
        return queryRunner.query(sql, new BeanListHandler<>(Simulation.class));
    }
}
