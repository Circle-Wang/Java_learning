package Chapter6.Object_;

public class EqualsExercise {
    public static void main(String[] args) {
        Person person = new Person("小王", 18, '男');
        Person person2 = new Person("小李", 18, '男');
        Person person3 = new Person("小李", 18, '男');

        System.out.println(person.equals(person2)); // false
        System.out.println(person2.equals(person3)); // true
    }
    
}

class Person {
    private String name;
    private int age;
    private char gender;

    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // 重写equals
    public boolean equals(Object obj) {
        // 如果比较的对象指向的同一个则直接返回true
        if (this == obj) {
            return true;
        }

        // 如果obj的属性是一个人则继续比较
        if (obj instanceof Person) {
            // 先向下转型, 得到obj的各个属性
            Person p = (Person) obj; 
            return this.name.equals(p.name) && this.age == p.age && this.gender == p.gender;
        }

        return false;
    }
    
}
