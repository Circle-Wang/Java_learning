package Chapter14;

import java.sql.Connection;
import java.sql.SQLException;

public class Jdbc04 {
    public static void main(String[] args) {
        try {
            Connection connection = JDBCUtilsByDruid.getConnection();
            JDBCUtilsByDruid.close(null, null, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
