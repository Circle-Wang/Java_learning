package Chapter14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 用于演示PreparedStatement实现SQL语句
public class Jdbc02 {
    public static void main(String[] args) throws SQLException {

        // 1、准备好数据库URL、用户名、密码
        String DB_URL = "jdbc:mysql://localhost:3306/circle?serverTimezone=GMT%2B8&useSSL=false";  // jdbc:mysql://数据库程序地址和端口/数据库名?serverTimezone=UTC&useSSL=false
        String USER = "root";
        String PASSWORD = "wangyuanquan1"; 

        // 2、获得连接
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

        // 3、用于执行静态SQL语句的对象
        String sql1 = "SELECT * FROM jj_day1 WHERE Supplier=? ";
        String sql2 = "INSERT INTO jj_day1 VALUES (?, ?)";

        // 4、prepareStatement在此处绑定
        PreparedStatement prepareStatement1 = conn.prepareStatement(sql1);
        PreparedStatement prepareStatement2 = conn.prepareStatement(sql2);
        prepareStatement1.setString(1, "不通过");  // 给 ? 进行赋值

        prepareStatement2.setString(1, "26");  // 也可以使用setInt(需要照顾表中字段属性)
        prepareStatement2.setString(2, "通过");  



        ResultSet resultQuery = prepareStatement1.executeQuery(); // 此处不用再传入SQL语句了
        
        int rows = prepareStatement2.executeUpdate();  // rows得到的是有几行被影响
        System.out.println(rows);
        
        while (resultQuery.next()) {
            // 通过.getString(字段名) 得到对应的返回值
            System.out.print("ID:" + resultQuery.getString("id") + "\t");
            System.out.print("Supplier:" + resultQuery.getString(2) + "\n");
        }

        // 关闭结果集对象、执行对象、连接对象
        resultQuery.close();
        prepareStatement1.close();
        prepareStatement2.close();
        conn.close();
    }
    
}
