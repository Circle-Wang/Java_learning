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
    <mapper resource="circlewang/dao/dao.UserMapper.xml"/>
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
```
```xml
<select id="getUserList" resultMap="结果映射器别名">
    <!--你的Sql语句-->
</select>
```
- 这样数据库中的列名与对象的属性可以不同
- 需要注意，如果对象中的属性是一个对象，那我们还需要将查出来的列进行进一步的封装才行，这会使用到高级的reslutMap的标签使用,具体可以查看:https://mybatis.net.cn/sqlmap-xml.html#Result_Maps
- 注意这个子标签id 一般会用以主键的属性转化, 如果结果集中完全不同的值的列，可以使用这个id


## 二、MyBatis注解开发
- 我们可以不用在Mapper.xml文件中进行Sql的编写(但不推荐这种写法对复杂的sql查询语句, 因为无法实现ReslutMap)
- 在Mapper接口类中，我们在方法上使用@Select, @Insert, @Update, @Delete等注解可以不用再为这个接口类配置Mapper.xml了
- 虽然没有了Mapper.xml，我们仍然要在mybatis的核心配置文件中配置mappers这个标签，不过此时传入的是class
```xml
    <!--这里的mappers需要注册类而不是文件路径-->
    <mappers>
        <mapper class="dao.UserMapper"/>
    </mappers>
```

- 自动事务提交:
  - 我们从sqlSessionFactory.openSession()方法得到sqlSession时, 可以传入参数true, 从而实现自动事务提交
- 使用@Param(),在注解中传递参数
  - @Param("别名"), 在注解中或者其他地方可以使用这个别名指代该位置变量
  - 建议基本类型的参数或者String类型，都加上这个注解
  - 在SQL中#{别名}的方式进行拆线呢

### 2.1、Lombok协助开发
- 我们发现在使用对pojo层的user设置时，需要对类进行get，set的设置，以及设置有参和无参构造，这个过程我们可以利用Lombok的注解来协助完成
- @Data: 实现自动的重写全参数的get set 以及 toString方法
- @AllArgsConstructor: 自动实现全参数的有参构造(会自动删除无参构造)
- @NoArgsConstructor: 自动实现无参构造
- @Getter: 如果只是想在某个字段上生成get方法可以在修饰字段

## 三、MyBatis的复杂运用
### 3.1 resultMap的复杂应用(多表查询, 一对多查询, 多对一查询)
- resultMap的使用前面已经做了一个简单的介绍，他可以帮我们完成当数据库字段名和类字段名不一致时帮我们完成匹配。但实际上resultMap中的association标签(帮助我们完成属性为类的映射), collection标签(完成属性是集合的映射)
- association标签：
  - 当我们类的字段中存在自定义对象，则我们需要为这个自定义的对象使用association标签将查出来的结果表中的所有字段进行一一映射成对象
- collection标签: 
  - 当我们类的字段中存在集合时，我们可以使用这个标签，这个标签中ofType表示这个集合中的元素是什么类型, javaType表示这个集合是什么类型(可以写List)

### 3.2、动态SQL语句
1. 有时时候我们需要根据业务需求的不同条件分支了来进行Sql的查询，在这种情况下我们常常需要在程序中根据if else等条件语句将Sql语句进行拼接。现在使用MyBatis绑定接口的方式去执行已经写好的SQL语句, 意味着我们在Mapper接口类中无法进行业务逻辑的简单嵌入，我们该怎么办呢？实际上MyBatis提供了一种动态SQL语句执行的方式，即我们可以在Mapper.xml中使用\<if>、\<choose、when、otherwise>等标签完成动态Sql的编写, 而不用去根据业务逻辑完成SQL语句的拼接 
2. if: 条件判断语句, 如果test中判断语句为true则将if中的语句拼接到SQL中
  ```xml
  <select>
    SELECT * FROM BLOG
    WHERE state = ‘ACTIVE’
    <if test="title != null">
      AND title like #{title}
    </if>
  </select>
  ```
3. choose、when、otherwise: 选择一项进行执行, 类似于Switch语句。choose中when有任何一项满足则会拼接该字段, 如果都不满足, 拼接otherwise的字段
```xml
<select>
  SELECT * FROM BLOG WHERE state = ‘ACTIVE’
  <choose>
    <when test="title != null">
      AND title like #{title}
    </when>
    <when test="author != null and author.name != null">
      AND author_name like #{author.name}
    </when>
    <otherwise>
      AND featured = 1
    </otherwise>
  </choose>
</select>
```
4. where: 用于解决在多条件时可能出现SQL语法错误，比如当所有条件都不满足时则不会注入WHERE这个字符串，并且还会自动的帮你把不符合SQL语法规则的AND和OR从开头去除(只会在子元素返回任何内容的情况下才插入 “WHERE” 子句。而且，若子句的开头为 “AND” 或 “OR”，where 元素也会将它们去除。)
  ```xml
  <select>
  SELECT * FROM BLOG
  <where>
    <if test="state != null">
         state = #{state}
    </if>
    <if test="title != null">
        AND title like #{title}
    </if>
    <if test="author != null and author.name != null">
        AND author_name like #{author.name}
    </if>
  </where>
  </select>
  ```
5. set: set标签可以用于动态包含需要更新的列，忽略其它不更新的列。set元素会动态地在行首插入SET关键字，并会删掉额外的逗号（这些逗号是在使用条件语句给列赋值时引入的）
  ```xml
  <update>
    update Author
      <set>
        <if test="username != null">username=#{username},</if>
        <if test="password != null">password=#{password},</if>
        <if test="email != null">email=#{email},</if>
        <if test="bio != null">bio=#{bio}</if>
      </set>
    where id=#{id}
  </update>
  ```
6. foreach: 动态SQL的另一个常见使用场景是对集合进行遍历（尤其是在构建 IN 条件语句的时候）。
  ```xml
  <select>
    SELECT *
    FROM POST P
    WHERE ID in
    <foreach item="item" index="index" collection="list"
        open="(" separator="," close=")">
          #{item}
    </foreach>
  </select>
  ```
  - 它允许你指定一个集合，声明可以在元素体内使用的集合项（item）和索引（index）变量。它也允许你指定开头与结尾的字符串以及集合项迭代之间的分隔符。
  - 你可以将任何可迭代对象（如 List、Set 等）、Map 对象或者数组对象作为集合参数传递给 foreach。当使用可迭代对象或者数组时，index 是当前迭代的序号，item 的值是本次迭代获取到的元素。当使用 Map 对象（或者 Map.Entry 对象的集合）时，index 是键，item 是值。
7. trim: 可以替换前缀和后缀, 通过这个功能可以很好的覆盖where标签与set标签，也可以有很多自定义的设计
   - prefixOverrides属性: 会移除所有prefixOverrides属性中指定的内容(可以通过"| "进行拼接), 针对前缀
   - suffixOverrides属性: 会移除suffixOverrides属性指定的内容, 针对后缀
   - prefix属性: 插入prefix属性中的内容, 会将prefix前缀拼接到trim标签的外侧
   - suffix属性: 插入suffix属性中的内容, 会将suffix后缀拼接到trim标签的外侧


## 四、MyBatis缓存
- 一次查询后，将查询的结果暂存在内存中，方便查询。解决了高并发的问题


