
import com.wang.dao.UserDaoImpl;
import com.wang.dao.UserOracleImpl;
import com.wang.dao.UserSQLImpl;
import com.wang.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyRun {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        // 获得一个UserSQLImpl对象
        UserSQLImpl mysql = (UserSQLImpl) context.getBean("mysql");
        mysql.getUser();

        // 获取一个Oracle登录对象
        UserOracleImpl oracle = context.getBean("oracle", UserOracleImpl.class);
        oracle.getUser();

        // 采用别名来得到一个bean对象
        UserDaoImpl dao = context.getBean("别名2", UserDaoImpl.class);
        dao.getUser();

        // 获取UserService
        UserServiceImpl userService = (UserServiceImpl) context.getBean("userService");
        userService.getUser();

        UserServiceImpl userService2 = (UserServiceImpl) context.getBean("userService");
        System.out.println(userService2.name);
    }
}
