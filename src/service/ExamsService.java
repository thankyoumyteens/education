package service;

import dao.ExamsDao;
import exception.UserException;
import model.Exams;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Admin on 2017/8/25.
 */
public class ExamsService {
    private ExamsDao dao = new ExamsDao();

    public List<Exams> getAll() throws UserException {
        try {
            return dao.getAll();
        } catch (SQLException e) {
            //
            throw new UserException("服务器异常");
        }
    }
}
