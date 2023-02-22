package Chapter14;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import Chapter14.dao_.domain.Table;

// 使用Apache_DBUtils + 德鲁伊 完成数据库操作
public class Jdbc05 {
    public static void main(String[] args) throws SQLException {

        // 及逆行数据库连接
        Connection connection = JDBCUtilsByDruid.getConnection();

        // 创建QueryRunner对象
        QueryRunner queryRunner = new QueryRunner();

        String sql1 = "SELECT * FROM jj_day1 WHERE Supplier=?";

        // new BeanListHandler<>(Table.class): 将resultSet中每一条结果变为 -> Table对象 -> 并放到ArrayList中
        // BeanListHandler 之后的参数是依次对SQL语句中的 ? 进行赋值的。
        List<Table> query = queryRunner.query(connection, sql1, new BeanListHandler<Table>(Table.class), "通过");
        System.out.println(query);


        // 执行DML操作，插入，更新
        String sql2 = "INSERT INTO jj_day1 VALUES (?, ?)";
        // 返回值是受影响的行数
        int updateRow = queryRunner.update(connection, sql2, 152, "Apache_DBUtils测试");;


        // 最新版的jar包还关闭了连接
        // JDBCUtilsByDruid.close(null, null, connection);
    }
    
}

