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
        User user =  qr.query(sql, new BeanHandler<>(User.class), uid, pwd);
        return user;
    }
}