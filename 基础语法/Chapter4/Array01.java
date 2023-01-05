package Chapter4;

public class Array01 {
    public static void main(String[] args) {
        
        // 静态初始化数组
        // 可以通过hens[下标]取得数据
        double[] hens = {3,5,1,3.4,2,50};
        System.out.println("hens的长度:" + hens.length);

        // 可以通过增强for的方法循环整个数组里的值
        for (double j : hens) {
            System.out.println(j);
        }

        // 动态初始化数组
        double nums1[]; // 声明数组，还没有分配空间
        nums1 = new double[10];  // 分配数组空间

        // 动态初始化数组2
        double nums2[] = new double[10]; // 直接分配空间

        
        // 二维数组
        int[][] array = {{1,2},{3,4},{5,6}}; // 一维数组的每个元素又是一维数组
        for (int i=0 ; i < array.length ; i++){
            for(int j=0 ; j < array[i].length ; j++){
                System.out.println(array[i][j]);
            }
        }

    }
    
}
