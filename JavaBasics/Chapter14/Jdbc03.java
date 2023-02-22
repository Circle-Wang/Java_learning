package Chapter14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Jdbc03 {
    
    public static void main(String[] args) throws SQLException{

        String DB_URL = "jdbc:mysql://localhost:3306/circle?serverTimezone=GMT%2B8&useSSL=false";  // jdbc:mysql://数据库程序地址和端口/数据库名?serverTimezone=UTC&useSSL=false
        String USER = "root";
        String PASSWORD = "wangyuanquan1"; 


        String sql1 = "INSERT INTO jj_day1 VALUES (100, '事务测试')";
        String sql2 = "INSERT INTO jj_day1 VALUES (101, '事务测试')";

        Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        PreparedStatement prepareStatement1 = null;
        PreparedStatement prepareStatement2 = null;

        try {
            conn.setAutoCommit(false); // 取消自动提交

            prepareStatement1 = conn.prepareStatement(sql1);
            prepareStatement2 = conn.prepareStatement(sql2);

            prepareStatement1.executeUpdate();

            int i = 1 / 0; // 此处会触发异常导致第二条SQL语句不会触发

            prepareStatement2.executeUpdate();
            conn.commit(); // 如果顺利执行到这里则 进行事务提交

        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();  // 回滚到事务开始时
        } finally {
            // 关闭连接
            if (prepareStatement1 != null) prepareStatement1.close();
            if (prepareStatement2 != null) prepareStatement2.close();
            conn.close();
        }
        



    }
}
