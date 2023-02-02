package Chapter11.map_;

import java.util.Comparator;
import java.util.TreeMap;

@SuppressWarnings({"all"})
public class TreeMapExercise {
    public static void main(String[] args) {
        TreeMap treeMap1 = new TreeMap();
        treeMap1.put("jack", "杰克");
        treeMap1.put("tom", "汤姆");
        treeMap1.put("Keven", "凯文");
        treeMap1.put("Smith", "史密斯");
        System.out.println("=======无参构造器========");
        System.out.println(treeMap1);

        TreeMap treeMap2 = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                // 根据k的字典序倒序排列
                return -((String) o1).compareTo((String) o2);
            }
        });
        treeMap2.put("jack", "杰克");
        treeMap2.put("tom", "汤姆");
        treeMap2.put("Keven", "凯文");
        treeMap2.put("Smith", "史密斯");
        System.out.println("=======传入比较器后========");
        System.out.println(treeMap2);


        TreeMap treeMap3 = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                // 根据长度排序
                return ((String) o1).length() - ((String) o2).length();
            }
        });
        treeMap3.put("jack", "杰克");
        treeMap3.put("tom", "汤姆");
        treeMap3.put("Keven", "凯文");
        treeMap3.put("Smith", "史密斯"); // 注意此处"Smith"和"Keven"长度相同(会被认为是相同的Key)，因此会将"Keven"的Value替换成"史密斯"
        System.out.println("=======根据长度排序========");
        System.out.println(treeMap3);


    }
    
}
