package Chapter6;

import Chapter6.override_.Dog;

public class OverrideTest {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.cry(); // 由于在子类中找到了重写后的cry方法,因此此处调用的是子类的cry

    }
}
