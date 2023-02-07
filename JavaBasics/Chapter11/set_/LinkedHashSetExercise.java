package Chapter11.set_;

import java.util.LinkedHashSet;

@SuppressWarnings({"all"})
public class LinkedHashSetExercise {
    public static void main(String[] args) {
        LinkedHashSet set = new LinkedHashSet();

        set.add(123);
        set.add(456);
        set.add(new Boy("小明",12));
        set.add(123);
        set.add("可爱");

        System.out.println(set); // 遍历顺序与插入顺序一样
    }
    
}

class Boy {
    String name;
    int age;
    public Boy(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Boy[name=" + name + ", age=" + age + "]";
    }

    

}
