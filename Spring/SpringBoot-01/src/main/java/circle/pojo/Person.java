package circle.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "person")  // 绑定配置文件,从配置文件中读取默认值
public class Person {
    private String name;
    private Integer age;
    private Date birth;
    private Map<String,Object> maps;
    private List<Object> lists;

    public Person(String name, Integer age, Date birth, Map<String, Object> maps, List<Object> lists) {
        this.name = name;
        this.age = age;
        this.birth = birth;
        this.maps = maps;
        this.lists = lists;
    }

    public Person() {
    }
}
