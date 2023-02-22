package Chapter14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Jdbc01 {
    public static void main(String[] args) throws SQLException {

        // 1、准备好数据库URL、用户名、密码
        String DB_URL = "jdbc:mysql://localhost:3306/circle?serverTimezone=GMT%2B8&useSSL=false";  // jdbc:mysql://数据库程序地址和端口/数据库名?serverTimezone=UTC&useSSL=false
        String USER = "root";
        String PASSWORD = "wangyuanquan1"; 

        // 2、获得连接
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

        // 3、用于执行静态SQL语句的对象
        Statement statement = conn.createStatement();
        String sql = "SELECT * FROM jj_day1";
        ResultSet resultQuery = statement.executeQuery(sql);  // 查询返回的结果是一个迭代器
        
        while (resultQuery.next()) {
            // 通过.getString(字段名) 得到对应的返回值
            System.out.print("ID:" + resultQuery.getString("id") + "\t");
            System.out.print("Supplier:" + resultQuery.getString(2) + "\n");
        }

        // 关闭结果集对象、执行对象、连接对象
        resultQuery.close();
        statement.close();
        conn.close();
    }
    
}
