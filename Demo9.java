import java.util.Arrays;

public class Demo9 {
    public static void main(String[] args) {

        int[][] a = {{1},{2},{3},{4},{5}}; // 打印多维数组需要使用deepToString
        int[] b = {12,11,5,4,11,62};  // 打印一维数组需要使用toString

        // 使用Arrays类的方法可以将数组直接打印
        System.out.println(Arrays.deepToString(a));
        System.out.println(Arrays.toString(b));

        // 排序
        Arrays.sort(b);

        // 将b中元素全部填写为0
        Arrays.fill(b, 0);
    }
    
}
