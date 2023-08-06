# MyBatis学习
MyBatis是帮助我们更好的连接数据库，避免了JDBC代码和手动设置参数以及获取结果集。MyBatis可以使用简单的XML或者注解来进行配置。持久层框架，完成持久化工作的代码块, 传统的JDBC比较复杂，MyBatis自动化的帮助数据存入数据库中。将Sql语句写在xml配置文件中，便于同一管理和优化(解除了sql语句与程序代码的耦合)。

中文文档地址: https://mybatis.net.cn/ \
maven仓库: https://mvnrepository.com/artifact/org.mybatis/mybatis
```xml
<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.5.10</version>
</dependency>
```

## 1、初识MyBatis
- MyBatis的配置文件包含了其系统的数据库设置，包含获取数据库连接实例的数据源和决定事务范围和控制方式的事务管理器。
- 配置文件包含有数据库连接的JDBC驱动, 连接的url, 用户名和密码等。
- 我们可以使用以下三行代码通过读取配置文件，并得到出SqlSessionFactory(这是个工厂模式下的对象，通过这个工厂类可以获取SqlSession对象, SqlSession对象是实际执行sql语句的载体)
```java
String resource = "org/mybatis/example/mybatis-config.xml";
InputStream inputStream = Resources.getResourceAsStream(resource);
SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
// 获取SqlSession对象
SqlSession session = sqlSessionFactory.openSession()
```

1.1、使用xml配置实现sql语句
- 原来我们想使用JDBC执行SqL语句是需要在代码中获取相关对象。但使用Mapper之后，可以从配置文件中读取出sql语句并执行.
- 原来我们需要定义一个Dao接口并编写其实现类DaoImpl去实现其定义的方法。从而完成数据库的查询修改，现在我们不用编写实现类DaoImpl，而是通过配置.xml实现。
- .xml中我们使用mapper标签绑定一个Dao/Mapping接口, 并进一步配置接口中每个接口方法所对应的Sql语句，以及其返回结果类型(resultTpye指定的单个返回结果对象类型，resultMap指定返回集合类型)
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!--绑定Dao/Mapper接口-->
<mapper namespace="circlewang.dao.UserDao">
    <select id="getUserList" resultType="circlewang.pojo.User">
        select * from mybatis.user
    </select>
</mapper>
```
- 将xxxMapper.xml在MyBatis核心配置文件中注册。(生成SqlSessionFactory时会读取这个MyBatis核心配置文件, 此时SqlSessionFactory将会知道有哪些接口和那些sql语句是对应的)
```xml
<mappers>
    <mapper resource="circlewang/dao/UserMapper.xml"/>
</mappers>
```
- 注意：maven构建文件时会自动过滤java文件中.xml（也就是java包中的.xml文件不会被放入到target中，因为maven中默认资源文件都会在resources包下），无法被导出、生效问题。
1.2、
















