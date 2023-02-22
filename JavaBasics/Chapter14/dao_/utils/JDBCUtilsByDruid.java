package Chapter14.dao_.utils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;


// 使用德鲁伊来连接池技术进行连接
public class JDBCUtilsByDruid {

    private static DataSource ds;

    // 在静态代码块中完成 ds初始化
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("Chapter14/德鲁伊配置文件.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
             // 将编译异常转换成运行异常抛出，调用者可以选择捕获异常也可以选择默认处理
            throw new RuntimeException(e);
        }
    }

    // 从连接池中获得连接对象
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    
    // 关闭相关连接对象
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
