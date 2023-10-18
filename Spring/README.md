# Spring框架学习
Spring是一个框架, 用于帮助企业级别开发.

官网：https://spring.io/projects/spring-framework#overview

中文文档：https://springdoc.cn/spring/index.html

官方下载地址：https://repo.spring.io/webapp/#/home

GitHub：https://github.com/spring-projects/spring-framework

## 第一章：基本了解 (Spring-01)
我们可以从：https://mvnrepository.com/tags/spring 中找到Spring的maven导入包配置, 填写进项目的pom.xml文件中.
```xml
<dependencies>
    <!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>6.0.10</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-jdbc</artifactId>
        <version>6.0.10</version>
    </dependency>
</dependencies>
```
Spring的思想就是通过读取xml配置文件, 由Spring容器自己创建我们自定义好的对象, 我们只需要从容器中提取Spring创建好的对象即可。 
总结一句话就是：对象由Spring创建, 管理, 装配。
创建对象xml模板：
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"xsi:schemaLocation="http://www.springframework.org/schema/beans
https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="给类一个别名" class="类的路径">  
        <!--
        name: 可以认为是setUserDao()方法中需要注入的对象名, 命名为去掉set的后面部分, 如果不是则会报错
        ref: 引用创建Spring中创建好另一个对象id
        value: 当setXXX中是传入的是基本数据类型时,可以使用value进行传值
        type: 与value组合使用的, 用于显示的指定value是什么类型（因为value必须使用""括起来数据）
        -->
        <property name="传入的参数名" ref="对象id"/value="数值/字符串"></property>
    </bean>

    <bean id="..." class="...">
        <!--通过type类型确定注入参数-->
        <constructor-arg type="java.lang.String" value=""/>
        <!--通过下标注入参数-->
        <constructor-arg index="0" value="7500000"/>
        <!--通过引用Spring中已经创建的对象-->
        <constructor-arg ref="beanTwo"/>
    </bean>
    <!-- 更多bean 定义在这里 --></beans>
```
实际上xml中的bean就是在创建对象（默认采用无参构造器）, 如果bean中具有poperty标签, 则Spring会自动调用该类的setXXX方法（如果没有Set方法, 就不能配置poperty标签）
获得Spring容器中的对象：
在主程序中通过以下代码取得Spring的上下文对象（容器对象）, 并从容器对象中根据bean的id来获得该对象。（在默认设定情况下, Spring是单例模式, 即同一个id只会创建一个对象, 即使多次获取也是获取的是同一个对象）
```
// 获得上下文对象
ApplicationContext context = new ClassPathXmlApplicationContext("Spring的xml配置地址");
// 根据id获得对象
Object obj = context.getBean("Bean的id名")
```


## 第二章: Spring可选配置
前面讲到的<beans>标签就是Spring的其中一个配置（也是最重要的一个配置）, 我们通常是都是在配置这个beans标签。但实际上Spring中还有一些其他的配置, 我们下面来介绍

### 2.1、别名
我们除了在定义Bean时能够给id来绑定该对象, 我们还可以给这个对象取不同的别名, 在getBean时可以使用这个别名来获得特定对象。
```xml
<alias name="fromName" alias="toName"/>
```

### 2.2、Bean的配置
我们也可以在Bean定义时采用name属性也可以定义别名：
```xml
<bean id="命名" class="类路径" name="别名1,别名2"/>
```
并且这个name跟的别名可以采用,分割。

### 2.3、import配置
可以将多个配置文件导入到当前配置文件中。
如果一个项目由多个人开发, 那么会存在多个Bean.xml文件, 如果在我们的项目想希望能使用到这些配置, 我们可以在当前的xml文件中使用import导入配置文件。
```
<import resource="services.xml"/>
<import resource="resources/messageSource.xml"/>
<import resource="/resources/themeSource.xml"/>
```


## 第三章：依赖注入
### 3.1、构造器注入
与前文介绍的一样, 使用constructor-arg完成对象的创建, 在创建的同时可以给对象中的某些属性进行赋值（本质就是使用构造函数完成类属性的初始化）

### 3.2、Set方式注入（已经被新特性取代）
有些类并不需要在构造器中完成对属性的初始化或者配置, 对这种属性, 我们常常会在类中为该属性配置SetXXX方法来完成属性的配置（比如对私有属性的修改等等）。而调用SetXXX方法对属性进行配置的这个过程由Spring自动调用。
由Spring根据类定义的SetXXX函数, 调用这个方法来完成注入。
- 对基本数据类型赋值：value标签 + type标签
```
<bean id="给类一个别名" class="类的路径">
    <property name="传入的参数名随意取" type="int" value="123"></property>
</bean>
```
- 对已经存在Spring容器里的bean对象注入：ref标签
```xml
<bean id="exampleBean" class="examples.ExampleBean">
    <property name="beanOne">
        <ref bean="anotherExampleBean"/>
    </property>
    <property name="beanTwo" ref="yetAnotherBean"/>
</bean>
```
- 对list数据类型进行注入：list标签
```xml
<property name="someList">
  <list>
  <value>基本数据类型+String</value>
  <ref bean="myDataSource" />
  </list>
</property>
```
- 对map数据类型进行注入：map标签, 注意：key 值或 value 值, 或 set 值, 也可以是以下任何元素。bean | ref | idref | list | set | map | props | value | null
```xml
<property name="someMap">
  <map>
  <entry key="an entry" value="just some string"/>
  <entry key="a ref" value-ref="myDataSource"/>
  </map>
</property>
```
- 对其他数据类型的注入方式：自行搜索


## 第四章：Bean的作用域（Scope）
- **singleton**：单例模式（默认）, 所有通过getBean获得的对象都是同一个对象。
- **prototype**：原型模式, 与单例模式相反, 每次调用getBean时, 都会创建新的对象。

样式：
```xml
<!--单例模式-->
<bean id="命名" class="类" scope="singleton"/>
<!--原型模式-->
<bean id="命名" class="类" scope="prototype"/>
```


## 第五章：基于注解的注入 (Spring-02)
- 在前面我们都是通过自己手动配置XML, 从而实现对Bean的属性注入以及装配(在xml中将对象实例化)。
- 而在实际大型项目的开发中, 我们会直接在代码中使用注解的方式完成Bean的配置
要想使用注解, 我们需要更改xml文件的约束以及支持注解的代码
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
            http://www.springframework.org/schema/beans/spring-beans.xsd
            http://www.springframework.org/schema/context
            http://www.springframework.org/schema/context/spring-context.xsd">

    <context:annotation-config/>
</beans>
```
完成这些配置之后, 我们就可以在java代码中使用注解来完成对属性的注入了。下面我们将介绍一些常用的注解@xxxxx。
- @Autowired：
  - 在属性/set方法上使用, 由Spring自动在xml文件中寻找符合条件（首先根据数据类型进行匹配, 如果有多个同数据类型, 则匹配id名与属性名相同的）的bean注入当前类的属性。
  - 如果在寻找时无法根据规则锁定唯一的bean那么框架会将抛NoUniqueBeanDefinitionException错误。为了更好的解决这个问题我们可以在再配合@Qualifier(“id名”)的方式从而实现锁定同一个bean的需求
  - @Autowired使用在属性上时可以不需要再显示设置setXXX方法。
  - 可以认为@Autowired修饰的声明, Spring会在其容器中找寻符合这个生命的对象, 从而把Spring容器中的对象分配给这个声明
  - @Autowired注解对接口进行装配时，Spring会查找容器中所有实现该接口的类对象，并将最适配的类对象分给这个接口。
- @Resource：
  - 这个注解需要导入包：jakarta.annotation.Resource, 这个注解需要传入一个名字name, 默认情况下, Spring将该值解释为要注入的Bean名称（id）
  - 如果没有明确指定名字, 默认的名字来自于字段名或setter方法。


## 第六章：基于注解的开发 (Spring-03)
在前文讲解Autowired和Resource时, 我其实发现, 我们仍然需要在xml文件中进行bean的配置（实际上Spring仍需要根据xml来先将bean生成, "基础" Bean定义也是在XML文件中明确定义的, 而注解只驱动依赖性注入。）
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">

    <!--    指定要扫描的包, 在这个包下的注解将会生效, 可以在程序中直接产生bean元数据-->
    <context:component-scan base-package="pojo"/>

</beans>
```
当我们采用以上配置时, Spring将会扫描包pojo中的代码, 并根据注释将相关的类交由Spring容器来进行管理。我们可能使用到以下的一些注解。
- `@Component`：组件, 放在类上, 说明该类被Spring管理 (Component有一些衍生的注解：`@Repository`、 `@Service` 、 `@Controller` （这四个注解的作用都是一样的, 所修饰的组件都会被Spring托管）, 在web开发中, 会按照mvc三层架构进行分层。业务层一般使用`@Service`进行注解, Dao层的组件一般使用`@Repository`进行注解, 在web层的组件一般使用`@Controller`进行注解。)
  - 被@Component修饰的类相当于就是被Spring放到它的容器中了，这个容器中就有一个该类的对象了，等待被分配（注入）
```java
package pojo;
import org.springframework.stereotype.Component;

// 等价于在xml 文件中显式定义 <bean id="user" class="pojo.User"></bean>
@Component
public class User {
    public String name;
}
```
- `@Value("xxxx")`：为基本数据类型、String属性进行注入值。可以在属性上注解, 也可以在SetXXX方法上
```java
package pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// 等价于在xml 文件中显式定义 <bean id="user" class="pojo.User"></bean>
@Component
public class User {
    public String name = "CircleWang";
    
    @Value("13")  // 等价于在bean中加入<property name="age" value="13"></property>
    public int age;

}
```
- `@Scope()`：用于标注当前组件的作用域, 与前文讲到的是一致, 可选传入参数有8个, 但最常用的就是singleton：单例模式（默认）、prototype：原型模式 () 


## 第七章：在JAVA中配置Spring配置信息
### 7.1、基本介绍
在前文中我们可以看到, 我们必须使用XML文件, 并且结合
`new ClassPathXmlApplicationContext("配置文件.xml")`来得到上下文对象, 并从上下文对象中获取相关的bean。这小结我们将介绍如何只是用java源文件来完成整个Spring的配置（换句话说完全取代xml文件）。
我们需要使用`@Configuration`来注解一个类, 这个类就被称之为配置类, 比如以下Java代码就完全等价于相对的xml文件：
```java
@Configuration
public class AppConfig {

    @Bean
    public People person() {
        return new People();
    }
}
```
```xml
<beans>
    <bean id="person" class="com.People"/>
</beans>
```
上文中的`@Bean`是修饰一个方法的, 这个方法会返回一个People对象（其实这就是在生成一个bean的过程）。

我们需要注意的是由于不存在xml文件, 因此我们需要使用新的方式来获取上下文对象：
```java
ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
People people = ctx.getBean("person");
```
上面的操作完全抛弃了XML文件, 因此我们完全可以把AppConfig这个类视为一个Spring的XML文件, 下面我们将介绍一些其他的注解用于修饰AppConfig这个类的。

### 7.2、配置类的更多注解
- 在`@Configuration`后面跟`@Import(其他配置类.class)`：相当于在xml文件中import其他的xml文件（第二小节有介绍）
- 在`@Configuration`后面跟`@ComponentScan(basePackages = "包名")`：相当于扫描指定包下面采用注解注入的bean, 等价于xml文件中的
```xml
<context:component-scan base-package="包名"/>
```

### 7.3、Bean的更多注解
在`@Bean`后面我们也可以加上相关的注解, 使得其具有和XML中相当的作用：
- 在`@Bean`后面可以跟`@Scope("prototype/singleton")`用于表示这个bean的作用域

### 7.4、总结
- 总的来说Spring可以看成是一个管家，当使用@Component修饰一个类时，这个类就会产生一个对象实例（不准确的说）放到Spring容器中，等待被分配引用。
- 如果某一个类中对一个声明引用使用了@Autowired，那么Spring会在容器中寻找有没有可以被这个引用所指向对象。
```java
@Autowired
public People wang;  // 这里声明了一个引用Prople，此时Spring会在容器中找有没有可以被这个引用所指向的对象，发现有，那么以后这个wang所指向的就是这个Sping分配好的这个对象了。
```
- Spring相当于让我们不用在People wang = new People()的方式去实例化一个类，而是有Spring自动给wang分配一个Peopel对象。


## 第八章: SpringMVC框架
MVC框架帮助我们完成的事情：
- 将url映射到java类或者java类的方法
- 封装用户提交的数据
- 处理请求——调用相关业务处理
- 将响应的数据进行渲染到jsp/HTML页面显示

SpringMVC实际上使用的是Servlet作为核心, 一共有以下步骤
- 我们在web.xml中注册一个servlet, 绑定DispatcherServlet类对象(来自spring包中), 所有的请求都需要都会经过这个类
- 在Spring.xml文件中配置Bean, 都是Spring包下第三方类
- 自己实现接口Controller接口, 操作ModelAndView类, 这个类对象可以帮助我们储存信息、重定向页面等, 最后我们需要将ModelAndView返回
- 在Spring配置文件中将我们的写的Controller类注册成bean。id为url后缀，用于被BeanNameUrlHandlerMapping控制器查找（其他的处理器映射器可以能不需要通过id进行映射）

**注意**: 
- 一定要注意如果你使用tomcat10及以上必须使用与其对应的包，特别是Spring, junit,servlet-api, jsp-api以及Java17
- 记得在项目结构中对应的web目录下添加包依赖，否则回报404


### 8.1、初识SpringMVC
根据前文提到的步骤我们写一个在前端展示的页面。

- 步骤一: 在web.xml使用Servlet的方式注册DispatcherServlet类, 并为其绑定Spring配置文件
- 步骤二: 在Spring配置文件中配置好处理器映射器, 处理器适配器，视图解析器，以及我们自己写的控制器Controller的Bean配置
- 步骤三: 重写接口Controller类，将业务代码放在里面，使用ModelAndView进行数据的传输以及视图的跳转

总结：
- 在web中通过Servlet注册的方式将Spring的DispatcherServlet注册进web中，并绑定好spring配置文件
- SpringMVC通过在Spring配置文件中创建处理前端代码的Bean, 我们只需要专注于Controller类的重写即可

### 8.2、采用注解编写SpringMVC
前面小节中我们看到，使用SpringMVC架构仍然还需要在Spring中配置Bean，但实际上我们在学习Spring中知道我们完全可以使用注解的方式对Bean进行配置。
- 步骤一: 仍然要在web.xml中配置Servlet的方式完成DispatcherServlet的注册。(注意更改classpath)
- 步骤二: 需要在Spring.xml中配置以下内容，从而实现注解开发:
  ```xml
  <beans xmlns="http://www.springframework.org/schema/beans"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns:context="http://www.springframework.org/schema/context"
         xmlns:mvc="http://www.springframework.org/schema/mvc"
         xsi:schemaLocation="http://www.springframework.org/schema/beans
          https://www.springframework.org/schema/beans/spring-beans.xsd
          http://www.springframework.org/schema/context
          https://www.springframework.org/schema/context/spring-context.xsd
          http://www.springframework.org/schema/mvc
          https://www.springframework.org/schema/mvc/spring-mvc.xsd">
  
      <!--指定要扫描的包，在这个包下的注解将会生效，可以在程序中直接产生bean元数据-->
      <context:component-scan base-package="circlewang"/>
  
      <!--让静态web文件.css .js .html等不经过视图解析, 过滤(非必须)-->
      <mvc:default-servlet-handler/>
  
      <!--支持注解驱动：不用再手动注入处理器映射器(BeanNameUrlHandlerMapping), 处理器适配器(SimpleControllerHandlerAdapter)
      (非必须)-->
      <mvc:annotation-driven/>
  
      <!--视图解析器-->
      <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver" id="internalResourceViewResolver">
          <!--前缀, 尽量将静态代码放置在WEB-INF中保证视图安全-->
          <property name="prefix" value="/WEB-INF/jsp/"/>
          <!--后缀-->
          <property name="suffix" value=".jsp"/>
      </bean>
  </beans>
  ```
- 步骤三: 创建一个类，使用@Controller进行注解, @RequestMapping完成url匹配, 被@RequestMapping注释的方法return的字符串就是转发到的jsp文件。

以上步骤一和步骤二在大多数情况是可以直接复制的，我们只需要将重心放到步骤三的Controller类的编写上。

### 8.3、各个注释以及组件的使用
下面我们将详细介绍代码中的注解使用方式以及一些类的作用，包括如何使用(重定向和转发、接受前端参数和数据回显、乱码解决)。
- Controller接口
  - 只要实现该接口类就可以实现控制器的功能，这个控制器只有一个功能, 就是处理请求和返回一个ModelAndView
  - 采用实现Controller接口具有一定的不足, 比如一个控制器只有一个方法(只能绑定一个url)，如果要多个方法则需要定义多个Controller。
- @Controller注解
  - 必须要在spring配置文件中设置包扫描`<context:component-scan base-package="circlewang"/>`
  - 需要联合@RequestMapping(url地址)注解方法使用, 这使得Controller类中不同的方法可以被不同的url映射
  - 被@Controller注解的类中的所有方法，如果返回的是String，该String就会被视图解析器进行拼接从而找到.jsp文件
  - 我们发现同一个视图(.jsp)是被复用的, 多个方法(url)可以指向同一个视图
- @RequestMapping注解
  - 该注解修饰类时，当前类下所有的url都需要拼接类的url作为前缀
  - 被注解的方法可以定义形参，而形参的名字则是前端通过param传入的键名。
  - 该注解还可以指定访问方法(get/put/delete...)，通过method方式指定，则当前端访问时需要使用对应的请求方式才能正常访问
  - 除了使用method指定访问方式意外, 我们还可以直接使用对应的@XXXMapping注解
    - @PostMapping
    - @GetMapping
    - @DeleteMapping
    - @PutMapping
    - ...
- @PathVariable注解(RestFul风格)
  - 这个注解可以帮我我们获取url中的参数，即可以让方法参数的值对应绑定到url模板变量上。比如`~/{a}/{b}`则当url传入~/12/time时，相当于给对应的方法传入了12 和 "time" 这个字符串
- 重定向和转发
  - 在Servlet中我们可以通过HttpServletRequest和HttpServletResponse这两个对象，进行网页的跳转和重定向。
  - 但我们发现在Controller中我们直接用return 字符串 的方式实现页面的跳转。实际上我们也可以直接获取到这两个对象
  - 实际上我们使用HttpServletRequest和HttpServletResponse可以跳过视图解析器完成跳转(但一般不会使用这种方式进行)
  - return时 对字符串添加参数实现重定向和转发
    - "forward:你的jsp文件完整路径/ 其他的url": 转发 
    - "redirct:你的jsp文件完整路径/ 其他的url": 重定向
    - 注意: 当使用这forward和redirct参数时不会进入视图解析器的, 因此视图解析器不会对文件或url进行拼接。
    - 注意: 重定向或者转发到url时, 注意url需要写全路径比如/api/xxx。(小心类上有/api)
- 接受前端数据
  - 我们在前面提到我们可以使用@PathVariable注解从而使用RestFul风格获取到url中传递得到的参数
  - 我们还可以使用在形参前面加入@RequestParam("参数名") 的方式, 指定前端传入什么参数
  - 我们还可以在形参处使用自定义对象直接接受前端的传入的参数。(Mapping会帮我们根据前端传入的字段名和你定义的对象中存在的字段名进行匹配, 从而直接得到一个对象), 需要注意前端传入的参数名和对象接受的参数名一定要保持一致
- 前端数据显示
  - 我们在前面小节中使用了ModelAndView和Model都可以返回视图
  - 我们还可以使用ModelMap给前端传递
- 解决乱码:
  - 我们可以使用Spring中自带的过滤器(也可以用自己写的过滤器,可以参看javaWeb笔记)，使用过滤器来解决前端传输乱码的问题
  - 在web.xml中配置
  ```xml
  <web-app>
    <filter>
        <filter-name>encoding</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>utf-8</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>encoding</filter-name>
        <url-pattern>/*</url-pattern>  <!--这里我们需要过滤jsp文件中的乱码传输所以用/*-->
    </filter-mapping>
  </web-app>
  ```
  - 注意: 这里使用/*是为了让所有的文件包括通过jsp文件的请求都经过filter


## 第九章: SpringBoot框架

### 9.1、初始SpringBoot(SpringBoot-01)
- 配置文件: 我们需要在pom.xml中进行依赖导入以及父依赖声明(虽然这一切都可以由IDEA自动完成，只需要在选择项目时选择Spring Initializr)
  ```xml
  <project>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.1.4</version>
        <relativePath />
    </parent>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <!--安装这个依赖后，执行将程序将会开启8080端口-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        </dependencies>
    </project>
  ```
- 我们可以从框架中创建一个SpringbootApplication类, 使用@SpringBootApplication注解将这个类注册成为一个配置类(这个注解其实和Spring中的@Configuration注解是一样的功能,抛弃xml配置文件)。从这个SpringbootApplication类可以直接启动tomcat服务。
- 自动搜索: SpringBoot会自动搜索SpringbootApplication类同级目录下/子目录下的所有java类进行自动装配。
- SpringBoot会自动搜索classes目录下的**application.properties或者**application.yml配置文件(编译前我们可以在resources这个文件夹下创建这个配置文件, 编译后我们就可以在target目录下找到这个文件了),这个搜索是写死的，因此我们不要更改配置文件的名字。

### 9.2、SpringBoot结构解释
- SpringBoot将所有的功能场景配置成了一个一个启动器(也就是我们在pom.xml中导入的spring-boot-starter-xxx),如果我们想使用数据库那就导入spring-boot-starter-JDBC，如果我们想使用web,那么就导入spring-boot-starter-web(上面我们就是导入这个从而实现启动内置的tomcat的)
- @SpringBootApplication注解: 前面有介绍到这个注解是主程序启动必须的, 我们可以看看这个注解的源码。可知道这个是一个组合注解, 由多个注解构成。下面讲解其中的一些重要注解
  - @SpringBootConfiguration：SpringBoot的配置类, 其也是一个组合注解, 等同于@Configuration(之前学过的Spring中配置类)，表示入口类本身也是一个配置类
  - @EnableAutoConfiguration：自动导入配置, 自动加载已经添加依赖的功能组件的配置类
    - @AutoConfigurationPackage: 自动配置包
    - @Import(AutoConfigurationImportSelector.class): @Import之前也讲解过, 是将其他的Spring配置了导入进来。
  - @ComponentScan: SpringBoot项目会自动扫描和入口类同包以及入口类子包的组件类

### 9.3、SpringBoot配置文件介绍(SpringBoot-01)
- 在前面我们说到了可以使用application.properties或者application.yml进行配置。实际上官方推荐使用*.yml作为配置文件。因为我们可以在.yml文件中可以为我们自定义对象进行赋值。(注意yaml文件中每个:后面需要有空格才会生效)
- 注意：如果同时存在application.properties和application.yml，将会优先读取.properties
- 在自定义类上使用@Component(注册为Spring的Bean)和@ConfigurationProperties(prefix="配置名")这样在.yml中就可使用以下配置对自定义属性进行默认赋值(注意自定义类一定要存在get/set方法)
```yaml
配置名: 
  属性1: xxx
  属性2: [xxx,xxx]
  属性3: {key: value}
  ...
```
- yml文件特性:
  - 支持表达式: 在.yml文件中我们可以使用${属性值}的方式读取值进行注入.比如${person.hello: 其他}(表示读取person的hello属性值，如果不存在这个属性则用“其他”代替)，${random.uuid}(随机产生uuid)。
  - 支持数据校验: 使用@Validated注解在自定义类上(需要加上相关依赖)，并在类的属性中使用@Email(判断属性值set时是否是email格式)、 @NotEmpty(属性值是否为空)...
- yml多环境配置:
  - 我们可以在相关路径(./config/、./..)下我们可以创建多个配置文件, 命名为application-xxx.yml的方式，比如application-dev.yml、application-test.yml等
  - 在application.yml配置文件中(主配置文件, 这个配置文件会被优先读取的)进行以下配置导入application-dev.yml的配置
  ```yaml
  spring: 
    profiles: 
      active: dev
  ```
  - 在.yml中我们还可以进一步的直接在application.yml一个文件中完成多个环境的配置。注意在每个环境之间使用---进行分隔
  ```yaml
  ---
  server:
   port: 8084
  spring:
   config:
    activate:
     on-profile: dev
  ---
  server:
   port: 8085
  spring:
   config:
    activate:
     on-profile: test
  ```
- 










