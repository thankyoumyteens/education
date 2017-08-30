package dao;

import model.Profile;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import util.C3P0Util;

import java.sql.SQLException;

/**
 * Created by Admin on 2017/8/28.
 */
public class ProfileDao {
    public Profile getProfileByUid(String uid) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        String sql = "select * from t_profile where uid=?";
        return qr.query(sql, new BeanHandler<>(Profile.class), uid);
    }

    public int update(String queryString, Object[] params) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        return queryRunner.update(queryString, params);
    }

    public boolean tableExist(String uid) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        String sql = "select * from t_profile where uid=?";
        Profile profile =  qr.query(sql, new BeanHandler<>(Profile.class), uid);
        return profile != null;
    }

    public int initProfile(String uid) throws SQLException {
        String queryString = "insert into t_profile(uid) values(?)";
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        return queryRunner.update(queryString, uid);
    }
}
