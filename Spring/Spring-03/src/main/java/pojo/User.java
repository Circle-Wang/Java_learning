package pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// 等价于在xml 文件中显式定义 <bean id="user" class="pojo.User"></bean>
@Component
public class User {
    public String name = "CircleWang";

    @Value("13")  // 直接为基本数据类型+String注入。等价于在bean中加入<property name="age" value="13"></property>
    public int age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
