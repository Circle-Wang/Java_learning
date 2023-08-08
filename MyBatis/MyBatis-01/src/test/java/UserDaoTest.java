import circlewang.dao.UserDao;
import circlewang.pojo.User;
import circlewang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void test() {
        // 获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 获取Dao接口对象并执行其方法
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user.toString());
        }

        // 一定不要忘记关闭
        sqlSession.close();
    }

    @Test   // 查询
    public void test2() {
        // 通过id查询用户
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {  // 这样写可以自动实现资源管理, 即相当于在finally块中关闭资源
            UserDao mapper = sqlSession.getMapper(UserDao.class);
            User user = mapper.getUserById(1);   // 传入待查询的用户id
            System.out.println(user.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    @Test   // 增加
    public void test3() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserDao mapper = sqlSession.getMapper(UserDao.class);
            int i = mapper.addUser(new User(4, "李白", "libai123"));  // 返回受影响的列数
            if (i>0){
                System.out.println("插入成功");
            }
            // 提交事务才能把数据真实地插入进数据库
            sqlSession.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Test  // 更新
    public void test4() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserDao mapper = sqlSession.getMapper(UserDao.class);
            int i = mapper.updateUser(new User(4, "修改后的李白", "修改后的密码"));  // 返回受影响的列数
            if (i>0){
                System.out.println("更新成功");
            }
            // 提交事务才能把数据真实地改变进数据库
            sqlSession.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test  // 删除
    public void test5() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserDao mapper = sqlSession.getMapper(UserDao.class);
            int i = mapper.deleteUser(4);  // 返回受影响的列数
            if (i>0){
                System.out.println("删除成功");
            }
            // 提交事务才能把数据真实地改变进数据库
            sqlSession.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }





}
