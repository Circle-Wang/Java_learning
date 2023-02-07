package Chapter12;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class Generic_ {
    public static void main(String[] args) {

        Set<Student> set = new HashSet<Student>();  // 使用泛型规定HashSet中只能放Student对象
        set.add(new Student("李华", 15));
        set.add(new Student("小明", 14));
        set.add(new Student("李明", 12));

        // 获取迭代器
        Iterator<Student> iterator = set.iterator();
        while (iterator.hasNext()) {
            // 使用泛型后，.next方法会返回的数据类型自动是Student了
            Student p = iterator.next();
            System.out.println(p);
        }

        // 使用增强for循环
        for (Student student : set) {  // 可以看到会自动使用Student类型来获取元素
            System.out.println(student);
        }
        
        // 通过泛型得到HashMap
        HashMap<String,Student> map = new HashMap<String,Student>();
        map.put("tom", new Student("tom", 22));
        map.put("smith", new Student("smith", 25));
        map.put("king", new Student("king", 13));

        Set<Entry<String,Student>> entrySet = map.entrySet(); // 得到entrySet
        for (Entry<String,Student> entry : entrySet) {        // 可以自动识别出Entry
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
        
    }
    
}

class Student {
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }
    
    


}