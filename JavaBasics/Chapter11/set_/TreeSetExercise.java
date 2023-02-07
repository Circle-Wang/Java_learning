package Chapter11.set_;

import java.util.Comparator;
import java.util.TreeSet;

@SuppressWarnings({"all"})
public class TreeSetExercise {
    public static void main(String[] args) {

        TreeSet treeSet1 = new TreeSet();  // 无参构造器则不会排序
        treeSet1.add("jack");
        treeSet1.add("tom");
        treeSet1.add("sp");
        treeSet1.add("a");
        System.out.println(treeSet1);
        System.out.println("========加入比较器后==========");

        TreeSet treeSet2 = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                // 调用String类中compareTo方法(如果o1的字典序=o2则返回0, 若o1的字典序小于o2则返回负数，o1字典序大于o2则返回正数)
                return -((String) o1).compareTo((String) o2);  // 记忆: 小于0 o1放left，大于0 o1放right(排序树)
            }
        });  // 采用匿名内部类方式传入Comparator实现子类对象
        treeSet2.add("jack");
        treeSet2.add("tom");
        treeSet2.add("sp");
        treeSet2.add("a");
        System.out.println(treeSet2);

        // 重点注意，比较器如果发现两个key是相等的则会放弃添加这个key进入TreeSet中(只会更新Value，但此输的Value是个空Object)
        TreeSet treeSet3 = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                // 根据字符串长度来排序
                // o1长度=o2长度是返回0
                return ((String) o1).length() - ((String) o2).length();  
            }
        });  // 采用匿名内部类方式传入Comparator实现子类对象
        treeSet3.add("jack");
        treeSet3.add("tom");
        treeSet3.add("sp");
        treeSet3.add("a");
        treeSet3.add("wol"); // 该元素将不会被添加进TreeSet中，会返回一个false。(不会添加到左子树或右子树)

        System.out.println("========重点注意=======");
        System.out.println(treeSet3);


    }
    
}
