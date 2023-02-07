package Chapter12;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"all"})
public class GenericExtends {
    public static void main(String[] args) {
        List<? extends Animal> list1;  // 该引用只能指向泛型类型是Animal及其子类
        // list1 = new ArrayList<Object>();  // 不通过
        list1 = new ArrayList<Animal>();     // 编译通过
        list1 = new ArrayList<Dog>();        // 编译通过
        

        List<? super Animal> list2;  // 该引用只能指向泛型类型是Animal及其父类
        list2 = new ArrayList<Object>();  // 编译通过
        list2 = new ArrayList<Animal>();  // 编译通过
        // list2 = new ArrayList<Dog>();     // 不通过

        
        // <? extends Animal>无法进行添加操作，但可以进行读取操作(虽然目前list1并没有元素在里面)
        // list1.add(new Dog());    // 报错, 因为list1里面的元素是Animal类型或者是继承于Animal的类，并没有给定一个具体的类型，因此编译器并不知道里面究竟能放什么特定的对象(Cat或者Dog都是Animal子类，哪这个list究竟可以放什么进去呢?)
        // list1.add(new Animal()); // 报错
        Animal animal0 = list1.get(0);  // 可以看到编译器自动使用Animal变量接收
        Animal animal1 = list1.get(1);  // 因为list1中存放的必须是Animal的子类对象/本身，我当然可以使用Animal引用变量来接收

        // <? super Animal>可以进行添加操作(但只能添加Animal及其子类)，读取操作只会读取出Object类型
        // 因为<? super Animal>此时只是限定了list2里面的元素是Animal类型或者是Animal类的父类，当添加一个Animal的父类时候会失败，因为Animal类的父类可能有很多，并不能确实其父类的类型。
        // 相反，添加Animal类的子类是可以的，因为子类可以向上转型为父类类型。
        // list2.add(new Object());
        list2.add(new Animal());
        list2.add(new Dog());
        Object animal = list2.get(1); // 此时我们取出的类型只知道是Animal类型或者是Animal类的父类(但并不知道究竟是那个父类)，因此只能采用Object的引用来接收


        // 常用情景: 实现方法的多态
        List<Object> l1 = new ArrayList<>();
        List<Animal> l2 = new ArrayList<>();
        List<Dog> l3 = new ArrayList<>();

        // printList1(l1); // 不能通过编译，因为l1的泛型类型是Object，而printList1中形参只能接收泛型为Animal类型或者是Animal类的子类的List
        printList1(l2); // 可以通过
        printList1(l3); // 可以通过

        printList2(l1);
        printList2(l2);
        // printList2(l3); // 不能通过编译，因为l3的泛型类型是Dog，而printList2中形参只能接收泛型为Animal类型或者是Animal类的父类的List
    }

    public static void printList1(List<? extends Animal> list) {
        for (Animal animal : list) {
            System.out.println(animal.getClass());
        }
    }

    public static void printList2(List<? super Animal> list) {
        for (Object object : list) {
            System.out.println(object.getClass());
            
        }
    }

    
    
}



class Animal {
}

class Dog extends Animal {
}


