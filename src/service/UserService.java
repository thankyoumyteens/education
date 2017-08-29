package service;

import dao.UserDao;
import exception.UserException;
import model.User;

import java.sql.SQLException;

/**
 * Created by Admin on 2017/8/25.
 */
public class UserService {
    private UserDao dao = new UserDao();

    public boolean userExist(String uid, String pwd) throws UserException {
        User user = null;
        try {
            user = dao.getUserByUidAndPwd(uid, pwd);
        } catch (SQLException e) {
            // 记录
            throw new UserException("服务器异常");
        }
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }

    public User getUser(String uid, String pwd) throws UserException {
        User user = null;
        try {
            user = dao.getUserByUidAndPwd(uid, pwd);
        } catch (SQLException e) {
            // 记录
            throw new UserException("服务器异常");
        }
        return user;
    }

    public boolean register(String uid, String pwd) throws UserException {
        User user = new User();
        user.setUid(uid);
        user.setPwd(pwd);
        // 默认普通会员
        user.setAccessLevel(0);
        user.setDelFlag(0);
        if (userExist(uid, pwd)) {
            throw new UserException("用户已存在");
        } else {
            try {
                return dao.insert(user) > 0;
            } catch (SQLException e) {
                //
                throw new UserException("注册失败");
            }
        }
    }
}
