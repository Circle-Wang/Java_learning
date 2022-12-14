package Chapter3;
import java.util.Scanner;

public class Demo6 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入分数");
        int s = scanner.nextInt();

        // if 选择结构
        if (s > 0 && s < 60) {
            System.out.println("不及格");
        } else if (s >= 60 && s <= 70) {
            System.out.println("等级为C");
        } else if (s > 70 && s <= 80) {
            System.out.println("等级为B");
        } else if (s > 80 && s <= 100) {
            System.out.println("等级为A");
        } else {
            System.out.println("成绩不合法");
        }


        // switch多选择结构
        System.out.println("请输入等级");
        String grade = scanner.next();

        switch (grade) {
            case "A":
                System.out.println("等级为A");
                break;
            case "B":
                System.out.println("等级为B");
                break;
            case "C":
                System.out.println("等级为C");
                break;
            default:
                System.out.println("未知等级");
        }
        System.out.println("==================");


        // 利用switch穿透特性解决季节打印
        System.out.println("请输入(1-12)月份");
        int month = scanner.nextInt();
        switch (month) {
            case 3:
            case 4:
            case 5:
                System.out.println("这是春季");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("这是夏季");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("这是秋季");
                break;
            case 12:
            case 1:
            case 2:
                System.out.println("这是冬季");
                break;
            default:
                System.out.println("输入月份不对");
        }
        System.out.println("==================");


        // while语句
        int count = 4;//
        int i = 1;
        while(i <= count){
            System.out.println("复制语言");
            i += 1;
        }

        // do{}while{}语句
        int count2 = 4;
        int i2 = 1;
        do {
            System.out.println("复制语言");
            i2++;
        } while (i2 <= count2);

        // for循环
        for (int j = 1; j <= 1; j++) {
            System.out.println(j);
            System.out.println("循环结束");
        }

        // 增强的for循环(遍历集合/数组)
        int[] numbers = {1,3,12,31,2,1}; // 定义了一个数组
        for(int j:numbers){
            System.out.println(j);
        }

        scanner.close();
    }
}
