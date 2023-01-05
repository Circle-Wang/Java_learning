package Chapter4;

public class TwoDimensionArray {
    public static void main(String[] args) {
        
        int[][] arr = new int[4][]; // 创建二维数组，但只确定了一维数组的个数，一维数组并没有被开空间，此时arr[i] = null
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[i+1];  // 为每一个一维数组开辟数据空间

            // 为一维数组进行赋值
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = i+1;
            }
        }

        // 遍历打印二维数组
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println("");
        }


    }
    
}
