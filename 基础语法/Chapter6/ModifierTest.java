package Chapter6;

import Chapter6.modifier.A;

public class ModifierTest {
    public static void main(String[] args) {

        A a = new A();
        // 不同包下，我们只能访问到n1
        System.out.println(a.n1);

    }

}

