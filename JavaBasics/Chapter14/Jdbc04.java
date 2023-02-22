package Chapter14;

import java.sql.Connection;
import java.sql.SQLException;

// 使用Druid连接池进行数据库连接
public class Jdbc04 {
    public static void main(String[] args) {
        try {

            Connection connection = JDBCUtilsByDruid.getConnection();
            JDBCUtilsByDruid.close(null, null, connection);
            System.out.println(connection.getClass());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
