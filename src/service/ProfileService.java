package service;

import dao.ProfileDao;
import exception.UserException;
import model.Profile;

import java.sql.SQLException;

/**
 * Created by Admin on 2017/8/28.
 */
public class ProfileService {
    private ProfileDao dao = new ProfileDao();

    public Profile getProfileByUid(String uid) throws UserException {
        Profile profile = null;
        try {
            profile = dao.getProfileByUid(uid);
        } catch (SQLException e) {
            // 记录
            throw new UserException("服务器异常");
        }
        return profile;
    }

    public boolean updateProfile(Object... params) throws UserException {
        String queryString = null;
        try {
            if (params.length == 2) {
                queryString = "update t_profile set mail=? where uid=?";
            } else if (params.length == 4) {
                queryString = "update t_profile set qqAccount=?,wechatAccount=?,weiboAccount=? where uid=?";
            } else {
                queryString = "update t_profile set " +
                        "nickname=?," +
                        "name=?," +
                        "gender=?," +
                        "idCard=?," +
                        "schoolCard=?," +
                        "address=?" +
                        " where uid=?";
            }
            return dao.update(queryString, params) > 0;
        } catch (SQLException e) {
            //
            throw new UserException("服务器异常");
        }
    }
}
