package Chapter9;

import java.util.Scanner;

public class TryCatchExercise {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in, "GBK");
        int num;
        System.out.print("请输如一个整数:");

        while (true) {
            try {
                num = Integer.parseInt(scanner.next()); // 此处可能出现异常
                break; // 如果能进入到这一步说明上条语句没有异常, 退出循环
            } catch (Exception e) {
                System.out.print("你输出的数据有误, 请重新输入: ");
            }
        }

        System.out.println("你输入的数据是: " + num);

    }
    
}
