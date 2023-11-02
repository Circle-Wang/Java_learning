import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pojo.People;

public class MyRun {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        People people1 = ctx.getBean("creatPerson", People.class);
        People people2 = ctx.getBean("creatPerson", People.class);
        System.out.println(people1);
        System.out.println(people1 == people2);
    }
}
