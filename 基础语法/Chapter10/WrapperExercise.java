package Chapter10;

// 讲解包装类中常见的面试题
public class WrapperExercise {
    public static void main(String[] args) {

        // == 在判断引用类型时，只判断地址是否相同，由于是new的包装类，则地址一定不同
        Integer i1 = new Integer(127);
        Integer i2 = new Integer(127);
        System.out.println(i1 == i2);  // F

        // 自动装箱的本质是底层调用 Integer.valueOf(127)
        // 由Integer.valueOf底层可以知道，如果数值范围在【-128,127】则会返回类中储存好的一个对象
        // 因此此处i3和i4得到的都是Integer类中储存好的一个同一个对象
        Integer i3 = 127;
        Integer i4 = 127;
        System.out.println(i3 == i4); // T

        // 由于超出了【-128,127】范围，所以调用Integer.valueOf()会返回一个new的Integer对象
        Integer i5 = 128; // 此处其实等价于new Integer(128)
        Integer i6 = 128;
        System.out.println(i5 == i6); // F

        // i7得到的是Integer类中储存好的一个对象
        // i8是重新new的一个对象
        Integer i7 = 127; 
        Integer i8 = new Integer(127);
        System.out.println(i7 == i8);   // F

        // == 两边如果有基本数据类型，则==会变成 值比较
        Integer i9 = 127; 
        int i10 = 127;
        System.out.println(i9 == i10);  // T

    }
    
}
