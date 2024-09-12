package pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class People {

    public String name;
    public int age;

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    // 用于在多个构造器的情况下, 这个可以注解可以指定在默认情况下使用那种自动注入
    @Autowired
    public People(String name) {
        this.name = name;
    }

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }




}
