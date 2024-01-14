import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pojo.People;

@Configuration
public class AppConfig {

    @Bean
    public People creatPerson() {  // 这个方法名在Spring中可以索引到这个
        return new People("circle",13);
    }
}
