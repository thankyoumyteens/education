package service;

import dao.SimulationDao;
import exception.UserException;
import model.Simulation;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Admin on 2017/8/29.
 */
public class SimulationService {
    private SimulationDao dao = new SimulationDao();

    public List<Simulation> getAll() throws UserException {
        try {
            return dao.getAll();
        } catch (SQLException e) {
            //
            throw new UserException("服务器异常");
        }
    }

    public boolean insert(Simulation simulation) throws UserException {
        try {
            return dao.insert(simulation) > 0;
        } catch (SQLException e) {
            //
            throw new UserException("上传失败");
        }
    }
}
