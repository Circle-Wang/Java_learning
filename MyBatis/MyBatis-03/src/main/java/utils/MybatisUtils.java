package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

// 该类用于Mybatis的连接管理等
public class MybatisUtils {
    // 工厂模式只需要一个工厂对象即可，由该工厂对象生成多个目标对象
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            String resource = "mybatis-03-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 返回得到一个可以执行SQL命令的SqlSession对象
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession(true);
    }

}
