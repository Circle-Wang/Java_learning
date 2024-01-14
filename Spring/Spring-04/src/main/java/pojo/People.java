package pojo;


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

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public People() {
    }


}
