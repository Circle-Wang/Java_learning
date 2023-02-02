package Chapter11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings({"all"})
public class CollectionsExercise1 {
    public static void main(String[] args) {
        // 以ArrayList为例
        List list = new ArrayList();
        list.add("tom");
        list.add("smith");
        list.add("king");
        list.add("ronald");
        System.out.println("===原始数组===" + "\n" + list + "\n");

        // 反转数组
        Collections.reverse(list);
        System.out.println("===反传后数组===" + "\n" + list + "\n");

        // 随机排列
        Collections.shuffle(list);
        System.out.println("===随机排列后数组===" + "\n" + list + "\n");

        // 数组排序(字典序)
        Collections.sort(list);
        System.out.println("===自然排序后数组===" + "\n" + list + "\n");

        // 数组排序(字符长度)
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).length() - ((String) o2).length();
            }
            
        });
        System.out.println("===字符长度排序后数组===" + "\n" + list + "\n");

    }
    
}
