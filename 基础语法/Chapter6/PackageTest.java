package Chapter6;

import java.util.Arrays;
import Chapter6.package_.xiaoqaing.Dog;

@SuppressWarnings({"unused"}) // 忽略不使用的警告
public class PackageTest {
    public static void main(String[] args) {

        // 选择导入不同的包
        Dog xiaoqinag_dog = new Dog();
        Chapter6.package_.lihua.Dog lihua_dog = new Chapter6.package_.lihua.Dog(); // 通过包名+类名的方式引用
        // 使用Array类多数组排序
        int[] arr = {3,2,11,34};
        Arrays.sort(arr);
        for (int i : arr) {
            System.out.print("\t" + i);
        }
        

    }

}
