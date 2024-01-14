package circlewang.dao;

import circlewang.pojo.User;

import java.util.List;

/*
* dao层又被成为mapper层，叫数据持久层，先设计接口，然后在配置文件中进行配置其实现的关联。
* dao层的作用为访问数据库，向数据库发送sql语句，完成数据的增删改查任务。
* 数据持久化操作就是指，把数据放到持久化的介质中，同时提供增删改查操作，比如数据通过MyBatis等数据库框架插入到数据库中
* */
public interface UserDao {
    // 获取全部用户
    List<User> getUserList();

    // 根据id查询用户
    User getUserById(int id);

    // 直接插入一个对象
    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
