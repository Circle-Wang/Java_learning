import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pojo.People;

public class MyRun {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        // 通过@Bean的方法名来得到对应的Bean
        People people1 = ctx.getBean("getPerson", People.class);
        People people2 = ctx.getBean("getPerson", People.class);
        System.out.println(people1);
        // 验证单例模式, 得到的对象都是同一个
        System.out.println(people1 == people2);

        // 直接通过小写类名来获得Bean, 这里生成People对象使用的是People(String name)有参构造
        People people3 = ctx.getBean("people", People.class);
        System.out.println(people3);
    }
}
