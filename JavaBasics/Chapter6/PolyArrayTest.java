package Chapter6;

import Chapter6.poly_.Person;
import Chapter6.poly_.Student;
import Chapter6.poly_.Teacher;

// 多态数组的应用
public class PolyArrayTest {
    public static void main(String[] args) {
        Person[] persons = new Person[5];

        // 将子类对象可以放父类型数组
        persons[0] = new Person("Jack", 25);
        persons[1] = new Student("小明", 18, 96);
        persons[2] = new Student("李华", 19, 99);
        persons[3] = new Teacher("王老师", 32, 1500);
        persons[4] = new Teacher("李老师", 45, 2500);

        // 循环多态数组，调用方法
        for (int i = 0; i < persons.length; i++) {
            // 动态绑定机制
            // persons[i]编译类型是Person，运行类型为子类类型。
            System.out.println(persons[i].say());    

            // 无法使用persons[i].study() 或者 .teach 因为编译类型是Person找不到这些方法。
            // 使用instanceof确定向下转换类型
            if (persons[i] instanceof Student) {
                ((Student) persons[i]).study();
            } else if (persons[i] instanceof Teacher) {
                ((Teacher) persons[i]).teach();
            }
            
        }
        
        
    }
    
}
