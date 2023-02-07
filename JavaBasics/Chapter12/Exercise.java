package Chapter12;

import java.util.ArrayList;
import java.util.Comparator;

public class Exercise {
    public static void main(String[] args) {
        Employee Ros1 = new Employee("Ros", 15000, new MyDate(2000, 5, 15));
        Employee Ros2 = new Employee("Ros", 15000, new MyDate(2001, 5, 15));
        Employee Smith = new Employee("Smith", 15000, new MyDate(1998, 3, 5));
        Employee Jack = new Employee("Jack", 15000, new MyDate(2001, 4, 25));
        
        ArrayList<Employee> arrayList = new ArrayList<>();
        arrayList.add(Smith);
        arrayList.add(Ros2);
        arrayList.add(Ros1);
        arrayList.add(Jack);


        System.out.println("排序前:" + arrayList);

        arrayList.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getName().compareTo(o2.getName()) != 0){
                    return o1.getName().compareTo(o2.getName());
                }
                // 如果名字相同，则比较birthday
                MyDate birthday1 = o1.getBirthday();
                MyDate birthday2 = o2.getBirthday();
                return birthday1.compareTo(birthday2);


                // 如果没有MyData没有实现compareTo则需要挨个比较
                // if (birthday1.year != birthday2.year) {
                //     return birthday1.year - birthday2.year;
                // } else if (birthday1.month != birthday2.month) {
                //     return birthday1.month - birthday2.month;
                // } else {
                //     return birthday1.day - birthday2.day;
                // }
            }
        });
        System.out.println("排序后:" + arrayList);
    }

}

class Employee {
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "\n Employee [姓名=" + name + ", 薪水=" + sal + ", 生日="
                + String.format("%d年%d月%d日",
                        birthday.getYear(),
                        birthday.getMonth(),
                        birthday.getDay())
                + "]";
    }

    

    
}


class MyDate implements Comparable<MyDate>{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // 我们可以重写compareTo方法，用于比较两个对象的大小
    @Override
    public int compareTo(MyDate other) {
        if (this.year != other.year) { // 这里注意可以使用other的私有属性(因为这就是在MyDate类中嘛)
            return this.year - other.year;
        } else if (this.month != other.month) {
            return this.month - other.month;
        } else {
            return this.day - other.day;
        }
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
    
 
}
