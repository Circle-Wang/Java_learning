package Chapter6.override_;

public class Dog extends Animal{
    
    // 这个方法与父类Animal的cry()方法三要素完全一样
    // 我们称Dog子类重写了Animal的cry方法
    public void cry() {
        System.out.println("小狗汪汪叫");
    }

    // 此处重写了父类的m1方法，尽管子类的m1返回值不是Object
    public String m1() {
        System.out.println("Animal的m1被调用");
        return null;
    }

}
