package Chapter10;

import java.util.Arrays;
import java.util.Comparator;

@SuppressWarnings({"all"})
public class ArraysTset {
    public static void main(String[] args) {
        
        // 数组字符串显示
        Integer[] ints = {1,2,3,4,3,2,1};
        System.out.println(Arrays.toString(ints));

        // 将数组排序
        Integer[] arr = {1,2,3,4,3,2,1};
        Arrays.sort(arr);  // 由于数组时引用类型，因此排序后arr将改变
        System.out.println(Arrays.toString(arr));

        // 定制排序
        Integer[] arr2 = {1,2,3,4,3,2,1};
        Arrays.sort(arr2, new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                Integer i1 = (Integer) o1;
                Integer i2 = (Integer) o2;

                if (i1 < i2) { // 若i1 < i2
                    return 1;  // 则i1在后面
                } else {
                    return -1;
                }

            }
        });
        System.out.println("定制排序后:" + Arrays.toString(arr2));

        // 二分查找
        Integer[] arr3 = {14,25,36,90,101}; // 必须是从小到大排序的数组
        System.out.println(Arrays.binarySearch(arr3, 90));

        // 数组元素复制
        Integer[] arr4 = Arrays.copyOf(arr3, 8);
        System.out.println(Arrays.toString(arr4));

        // 数组填补
        Arrays.fill(arr4, 999);
        System.out.println(Arrays.toString(arr4));

        // 数组比较
        System.out.println(Arrays.equals(arr3, arr4));
    }
}
