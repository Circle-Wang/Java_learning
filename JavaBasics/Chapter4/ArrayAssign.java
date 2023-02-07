package Chapter4;
public class ArrayAssign {
    public static void main(String[] args) {
        
        // 基础数据类型赋值
        int n1 = 10;
        int n2 = n1;  // 值拷贝
        n2 = 80;
        System.out.println("n1为:" + n1 + " n2为:" + n2); // n2变化不会改变n1

        // 数组类型赋值
        int[] arr1 = {1,2,3};
        int[] arr2 = arr1; // 引用赋值，赋值的是地址
        arr2[0] = 100;
        System.out.println("arr1的第一个位置的值为: "+arr1[0]);

        // 数组内容的拷贝(要求两个数组数据相互不影响)
        int[] arr4 = new int[arr1.length]; // 开辟一个和arr1一样大小空间
        for (int i = 0; i < arr1.length; i++) { // 循环arr1重新赋值
            arr4[i] = arr1[i];
        }
        System.out.println(arr4[0]);
        System.out.println("=======================");


        // 数组反转(开辟新数组空间)
        int[] arr5 = {1,2,3,4,5,6,7};
        int[] rever_arr5 = new int[arr5.length];
        for (int i = 0, j = arr5.length - 1; i < rever_arr5.length; i++, j--) {
            rever_arr5[i] = arr5[j];
        }
        System.out.print("反转后的数组:");
        for (int i : rever_arr5) {
            System.out.print("\t" + i);
        }


    }
    
}
