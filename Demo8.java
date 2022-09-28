/**
 * 数组定义一:
 * 变量类型[] 变量名 = 变量的值; 定义数组同时给定值
 * 
 * 数组定义二:
 * 变量类型[] 变量名; 只定义数组名
 * 变量名 = new 变量类型[数组长度] 定义数组长度
 * 也可以合成一步：变量类型[] 变量名 = new 变量类型[数组长度]
 * 
 * 数组特点:
 * 1、一个数组的长度一旦被创建则不能被改变
 * 2、一个数组中的元素必须是相同类型，不允许出现混合类型
 * 3、数组中的元素可以是任何数据类型，包括基本类型和引用类型
 * 4、数组变量属于引用类型，数组也可以看成是对象，数组中的每个元素相当于该对象的成员变量。
 * 
 * 多维数组的定义:
 * int[][] arrays;
*/

public class Demo8 {
    public static void main(String[] args) {
        // 定义第一种方式——静态初始化
        int nums[] = {1,2,3};

        // 定义第二种方式
        double nums2[];
        nums2 = new double[10];  // 分配数组空间，能由10个元素
        for(int i = 0 ; i < nums2.length ;i++){
            nums2[i] = i;
        }
        printArray(nums2);

        // 反转数组
        System.out.println("=========");
        printArray(reverse(nums2));

        // 二维数组
        int[][] array = {{1,2},{3,4},{5,6}};
        for (int i=0 ; i < array.length ; i++){
            for(int j=0 ; j < array[i].length ; j++){
                System.out.println(array[i][j]);
            }
        }
    }

    // 数组的使用:反转数组
    public static double[] reverse(double[] arrays) {
        double[] result = new double[arrays.length];

        for(int i = 0, j = arrays.length-1 ; i < arrays.length ; i++, j--){
            result[j] = arrays[i];
        }
        return result;
    }

    // 打印数组
    public static void printArray(double[] arrays) {
        for(double i:arrays){
            System.out.println(i);
        }
        
    }
}
