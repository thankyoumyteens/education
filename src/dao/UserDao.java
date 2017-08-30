package dao;

import model.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import util.C3P0Util;

import java.sql.SQLException;

/**
 * Created by Admin on 2017/8/25.
 */
public class UserDao {
    public User getUserByUidAndPwd(String uid,String pwd) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        String sql = "select * from t_user where uid=? and pwd=?";
        return qr.query(sql, new BeanHandler<>(User.class), uid, pwd);
    }

    public int insert(User user) throws SQLException {
        String queryString = "insert into t_user(uid, pwd, accessLevel, delFlag) values(?,?,?,?)";
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        return queryRunner.update(queryString,
                user.getUid(),
                user.getPwd(),
                user.getAccessLevel(),
                user.getDelFlag());
    }

    public int updateLevel(int level, String uid) throws SQLException {
        String queryString = "update t_user set accessLevel=? where uid=?";
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        return queryRunner.update(queryString, level, uid);
    }
}
