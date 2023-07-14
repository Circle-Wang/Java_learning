import org.springframework.beans.factory.annotation.Autowired;

public class Cat {

    public String name;

    public Cat(String name) {
        this.name = name;
    }

    public void shot(){
        System.out.println("小猫:" + this.name +"叫了一声：喵");
    }
}
