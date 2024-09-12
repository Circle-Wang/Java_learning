import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pojo.People;

@Configuration
@ComponentScan(basePackages = "pojo")
public class AppConfig {

    // 在使用getBean时需要传入creatPerson作为name
    @Bean
    public People getPerson() {  // 这个方法名在Spring中可以索引到这个
        return new People("circle", 13);
    }

    // 返回一个String, 将这个字符串对象给到Spring管理, 这样在需要String对象是就可以被使用
    @Bean
    public String getString() {  // 这个方法名在Spring中可以索引到这个
        return "wang";
    }

}
