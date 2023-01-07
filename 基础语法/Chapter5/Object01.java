package Chapter5;

public class Object01 {
    public static void main(String[] args) {
        
        Cat cat1 = new Cat();  // 创建一个cat类的对象
        cat1.name = "小花";
        cat1.age = 12;
        cat1.color = "白色";
        cat1.son = new int[]{1,2,3,4};

        Cat cat2 = new Cat();  // 创建一个cat类的另一对象
        cat2.name = "小白";
        cat2.age = 3;
        cat2.color = "黑色";


        // 复制一个新的对象，但只复制了一层
        Cat cat3 = new Cat();  // 创建一个cat类的另一对象
        cat3.name = cat1.name;
        cat3.age = cat1.age;
        cat3.color = cat1.color;
        cat3.son = cat1.son;
        
        cat3.son[1] = 1000; // 此时cat3.son和cat1.son其实指向的是同一个地址，因此此时cat3.son的改变，仍会影响到cat1.son
        cat3.name = "可以"; // 虽然String类也是传递的地址，但是由于String类是交由常量池管理，因此可以将String类看成基本数据的值拷贝.

        System.out.println("cat1.son" + cat1.son[0] + "\t" + cat1.son[1] + "\t" + cat1.son[2] + cat1.name);
        System.out.println("cat3.son" + cat3.son[0] + "\t" + cat3.son[1] + "\t" + cat3.son[2] + cat3.name);
        
        
    }
    
}

// 定义一个猫类
class Cat{
    // 定义猫类所包含的属性
    String name;
    int age;
    String color;
    int[] son;
}
