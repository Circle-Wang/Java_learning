import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class People {
    @Autowired  // Spring会在容器中寻找有没有可以被dog1指向的对象，分配发给dog1
    @Qualifier("dog")
    private Dog dog1;  // 注意此时Dog没有set方法, 并且xml中没有id=dog1的Bean
    private Cat cat;
    private String name;

    public Dog getDog() {
        return dog1;
    }

    public Cat getCat() {
        return cat;
    }

    @Autowired
    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
                "dog=" + dog1 +
                ", cat=" + cat +
                ", name='" + name + '\'' +
                '}';
    }
}
