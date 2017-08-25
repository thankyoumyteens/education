package servlet;

import exception.UserException;
import org.junit.jupiter.api.Test;
import service.UserService;

import java.sql.SQLException;

/**
 * Created by Admin on 2017/8/25.
 */
class LogInServletTest {
    @Test
    public void test() throws SQLException, UserException {
//        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
//        String sql = "select * from t_user";
//        List<User> list =  qr.query(sql, new BeanListHandler<>(User.class));
        Boolean b = new UserService().userExist("tx", "123");
        System.out.println();
    }
}