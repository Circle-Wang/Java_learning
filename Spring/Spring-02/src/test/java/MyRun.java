import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.spel.standard.SpelCompiler;

public class MyRun {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
        People people = context.getBean("people", People.class);
        people.getCat().shot();
        people.getDog().shot();
        System.out.println(people.getName());
    }
}
