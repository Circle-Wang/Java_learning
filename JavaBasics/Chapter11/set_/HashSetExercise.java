package Chapter11.set_;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@SuppressWarnings({"all"})
public class HashSetExercise {
    public static void main(String[] args) {
        Set hashSet = new HashSet();

        // 添加
        hashSet.add("jack");
        System.out.println(hashSet.add("jackWang"));  // add方法会返回一个boolean值，表示是否添加成功
        System.out.println(hashSet.add("jack"));      // 重复数据添加会返回false,表明添加失败
        hashSet.add(null);
        System.out.println("Set:" + hashSet); // 遍历顺序与添加顺序不同(但是是固定的)
        System.out.println("==================");

        // 自定义集合元素除重
        Set mySet = new HashSet();
        mySet.add(new Employee("小红", 24));
        mySet.add(new Employee("小红", 24)); // 无法被加入
        mySet.add(new Employee("小华", 14));
        mySet.add(new Employee("小红", 15));
        mySet.add(new Employee("小明", 24));

        System.out.println(mySet);

    }
}

// 重写equals() 和 hashCode() 方法使得其在集合中能根据姓名和年龄不同存储
class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 这是采用Objects的方法进行重写的hashCode()和equals()
    @Override
    public int hashCode() {
        return Objects.hash(name,age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())  // 如果不是来自同一个类
            return false;
        Employee other = (Employee) obj;
        return age == other.age &&
        Objects.equals(name, other.name);

    }
    
    
    // // 这是快捷键自动生成的hashCode()和equals()
    // @Override
    // public int hashCode() {
    //     final int prime = 31;
    //     int result = 1;
    //     result = prime * result + ((name == null) ? 0 : name.hashCode());
    //     result = prime * result + age;
    //     return result;
    // }

    // @Override
    // public boolean equals(Object obj) {
    //     if (this == obj)
    //         return true;
    //     if (obj == null)
    //         return false;
    //     if (getClass() != obj.getClass())
    //         return false;
    //     Employee other = (Employee) obj;
    //     if (name == null) {
    //         if (other.name != null) // 虽然是另外的Employee对象，但仍可以访问其私有属性
    //             return false;
    //     } else if (!name.equals(other.name))
    //         return false;
    //     if (age != other.age)
    //         return false;
    //     return true;
    // }
    
    @Override
    public String toString() {
        return age + "岁的" + name;
    }

    
}
