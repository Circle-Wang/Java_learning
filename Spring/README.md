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
```xml
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
```java
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
<bean id="命名" class="类路径" name="别名1,别名2"></bean>
```
并且这个name跟的别名可以采用,分割。

### 2.3、import配置
可以将多个配置文件导入到当前配置文件中。
如果一个项目由多个人开发, 那么会存在多个Bean.xml文件, 如果在我们的项目想希望能使用到这些配置, 我们可以在当前的xml文件中使用import导入配置文件。
```xml
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
```xml
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
单例模式
<bean id="命名" class="类" scope="singleton"/>
原型模式
<bean id="命名" class="类" scope="prototype"/>
```


## 第五章：基于注解的注入 (Spring-02)
- 在前面我们都是通过自己手动配置XML, 从而实现对Bean的属性注入以及装配。
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
  
      <!--让静态web文件.css .js .html等不经过视图解析, 过滤-->
      <mvc:default-servlet-handler/>
  
      <!--支持注解驱动：不用再手动注入处理器映射器(BeanNameUrlHandlerMapping), 处理器适配器(SimpleControllerHandlerAdapter)
      -->
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

下面我们将详细介绍上面的注释以及其还可以如何使用(重定向和转发、接受前端参数和数据回显、乱码解决)。
- Controller
















