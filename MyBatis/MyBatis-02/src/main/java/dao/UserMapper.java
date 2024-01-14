package dao;


/*这个类直接使用注解定义SQL语句, 虽然不需要mapper.xml了但还需要在Mybatis核心配置文件中配置mappers标签
*
*
* */

import org.apache.ibatis.annotations.*;
import pojo.User;

import java.util.List;

public interface UserMapper {

    // 查询
    @Select("select * from mybatis.user")
    List<User> getUser();

    // 根据id查询用户
    @Select("select * from mybatis.user where id=#{id_2}")
    User getUserById(@Param("id_2") int id);

    // 插入
    @Insert("insert into mybatis.user(id, name, pwd) values (#{id},#{name},#{pwd})")
    int addUser(User user);

    // 更新
    @Update("UPDATE mybatis.user SET name=#{name},pwd=#{pwd} where id=#{id}")
    int updateUser(User user);

    // 删除
    @Delete("delete from mybatis.user where id=#{uid}")
    int deleteUser(@Param("uid")int id);
}
