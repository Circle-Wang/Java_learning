package Chapter6;

public class EncapTest {

    public static void main(String[] args) {
        Person p1 = new Person("CircleWang", 25, 25000);
        p1.setName("小明");
        p1.setAge(25);
        p1.setSalary(25000);
        System.out.println(p1.info());
    }
    
}


class Person {

    private String name;
    private int age;
    private double salary;

    // 构造器与set方法结合
    public Person(String name, int age, double salary) {
        setName(name);
        setAge(age);
        setSalary(salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() >= 2 && name.length() <= 6) {
            this.name = name;
        } else {
            System.out.println("姓名最低2个字符, 最多6个字符, 默认null");
            this.name = null;
        }

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 1 && age <= 120) {
            this.age = age;
        } else {
            System.out.println("你设置的年龄不对,需要在1-120,默认年龄为18");
            this.age = 18;
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String info() {
        return "这个人信息为 name=" + name + " age=" + age + " 薪水=" + salary;
    }

}