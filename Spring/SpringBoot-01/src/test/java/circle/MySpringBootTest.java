package circle;

import circle.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.Arrays;

@SpringBootTest
public class MySpringBootTest {
    @Autowired
    private Person person1;

    @Test
    void test1(){
        System.out.println(person1);
    }

    @Test
    void test2(){
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'.split(' ')[0]");
        String message = (String) exp.getValue();
        System.out.println(message);
    }

//    @Test
//    void test3(){
//        //正常使用
//        Day[] ds=Day.values();
//        //向上转型Enum
//        Enum e = Day.MONDAY;
//        System.out.println(Arrays.toString(e.values()));
//        System.out.println(e.getDeclaringClass());
//    }
}
