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
}
