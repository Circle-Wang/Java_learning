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

## 一、初识MyBatis
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

### 1.1、使用xml配置实现sql语句
- 原来我们想使用JDBC执行SqL语句是需要在代码中获取相关对象。但使用MyBatis之后，可以从配置文件中读取出sql语句并执行.
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

### 1.2、增删改查
- 我们知道对数据库的操作(sql语句)都写在了绑定了相应接口的.xml文件中, 所以所有的CRUD操作都需要以标签的形式进行配置，下面我们将介绍不同的标签的配置方式。
- **select**: 查询语句
  - id: 对应的namespace(绑定接口类)的方法名(也就是接口类中的方法名)
  - resultType: Sql语句执行后的返回值。可以是自定义的对象(这个对象必须有get/set方法, 并且对象的字段和数据库中对应表的字段是一致的), 也可以是基本数据类型
  - parmeterType: 在Sql语句中传入的参数类型。在sql语句中可以通过#{参数名}可以取出参数, 注意必须与形参命名一致。(如果数据类型是map则在sql可以用#{键名}进行读取)
- **insert / update / delete**: 插入语句 / 更新语句 / 删除语句
  - id: 对应的namespace(绑定接口类)的方法名(也就是接口类中的方法名)
  - parmeterType: 可以设定为一个自定义对象(这个对象必须有get/set方法, 并且对象的字段和数据库中对应表的字段是一致的), 这样在sql语句中可以只用使用#{对象字段名}的方式使用。
  - 无resultType标签
- 注意: 
  - 增删改必须在完成后提交事务`sqlSession.commit()`
  - 由于parmeterType会指定sql中所有参数的属性，因此如果sql语句中由多种类型, 最好是使用map。(只有一个基本数据类型可以省略这个参数)

### 1.3、Mybatis核心配置
- **属性(properties)**: 设置好的属性可以在整个配置文件中用来替换需要动态配置的属性值
  - 设置属性, 我们可以设置resource指向一个config.properties文件, 这样在整个xml中通过${键名}使用配置文件中的值, 也可以直接下面增加属性配置。
    ```xml
    <properties resource="你的config.properties文件路径">  
      <property name="username" value="dev_user"/>   <!--也可以直接在里面设置-->
      <property name="password" value="F2Fa3!33TYyg"/>
    </properties>
    ```
  - 优先从外部配置文件中获取
- **环境配置(environments)**: MyBatis 可以配置成适应多种环境，这种机制有助于将 SQL 映射应用于多种数据库之中
  - 可以在代码中指定使用那个数据库环境:`SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(readerIO流对象, environment字符串);`
  - 其他配置可以参看MyBatis-01代码包中的配置
    - 类型别名(typeAliases): 类型别名可为 Java 类型设置一个缩写名字。 它仅用于mapper的XML配置，意在降低冗余的全限定类名书写。
    - 我们可以通过以下方式给我们类起别名:
      ```xml
      <typeAliases>
          <typeAlias alias="别名" type="类的全路径"/>
          <typeAlias alias="User" type="circlewang.pojo.User"/>
      </typeAliases>
      ```
    - 我们也可以指定一个包名，MyBatis 会在包名下面搜索需要的 Java Bean(如果采用这种方式则自动识别为首字母小写的类名作为别名)
      ```xml
          <typeAliases>
              <package name="domain.blog"/>
          </typeAliases>
      ```
    - 也可以在类上使用注解@Alias(别名), 来被识别到
- **设置(settings)**: 这是MyBatis中极为重要的调整设置, 它们会改变MyBatis的运行时行为。(还有很多设置)
  - logImpl: 指定 MyBatis 所用日志的具体实现，未指定时将自动查找。(SLF4J | LOG4J | LOG4J2 |)
  - cacheEnabled: 全局性地开启或关闭所有映射器配置文件中已配置的任何缓存。(true | false)
- **映射器(mappers)**：定义 SQL 映射语句了。首先，我们需要告诉 MyBatis 到哪里去找到这些Sql语句
  - 方式一: 使用相对于类路径的资源引用【推荐使用】
    ```xml
    <mappers>
        <mapper resource="org/mybatis/builder/AuthorMapper.xml"/>
        <mapper resource="org/mybatis/builder/BlogMapper.xml"/>
        <mapper resource="org/mybatis/builder/PostMapper.xml"/>
    </mappers>
    ```
  - 方式二: 使用映射器接口实现类的完全限定类名（注意: 接口和他的Mapper配置文件必须同名, 且必须在同一个包下才能使用）
    ```xml
    <mappers>
        <mapper class="org.mybatis.builder.AuthorMapper"/>
        <mapper class="org.mybatis.builder.BlogMapper"/>
        <mapper class="org.mybatis.builder.PostMapper"/>
    </mappers>
    ```
  - 方式三: 通过扫描包下的所有mapper配置文件（注意：接口和他的Mapper配置文件必须同名，且必须在同一个包下才能使用）
    ```xml
    <mappers>
        <package name="org.mybatis.builder"/>
    </mappers>
    ```
  

### 1.4、属性名和字段名不一致(ReslutMap)
- 如果自定义的类中字段名和数据库中的字段名不是一一对应的，那么查询结果转化为自定义对像时就会存在字段缺失
- 我们可以在Mapper的XML中可以使用reslutMap进行配置结果集别名转化
  ```xml
    <resultMap id="结果映射器别名" type="User">
        <id column="数据库 主键字 段名" property="对象中的属性名"/>
        <result column="数据库字段名" property="对象中的属性名"/>
    </resultMap>
  
    <select id="getUserList" resultMap="结果映射器别名">
        <!--你的Sql语句-->
    </select>
  ```
- 这样数据库中的列名与对象的属性可以不同
- 需要注意，如果对象中的属性是一个对象，那我们还需要将查出来的列进行进一步的封装才行，这会使用到高级的reslutMap的标签使用,具体可以查看:https://mybatis.net.cn/sqlmap-xml.html#Result_Maps
- 注意这个子标签id 一般会用以主键的属性转化, 如果结果集中完全不同的值的列，可以使用这个id
