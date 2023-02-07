package ExerciseProject.SmallChange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class SmallChangeSysOOP {
    
    boolean loop=true;
    Scanner scanner=new Scanner(System.in, "GBK");
    String key="";
    String detailStr="";
    double count;
    Date date;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");


    public void mainMenu() {
        do {
            System.out.println("========== 零钱通OOP =======");
            System.out.println("\t1、零钱通明细");
            System.out.println("\t2、收     入");
            System.out.println("\t3、支     出");
            System.out.println("\t4、退     出");

            System.out.print("请输入你的选择: ");
            key = scanner.next();

            switch (key) {
                case "1":
                    this.detail();
                    break;

                case "2":
                    this.income();
                    break;

                case "3":
                    this.pay();
                    break;

                case "4":
                    this.exit();
                    break;
            }
        } while (loop);


    }

    // 输入出明细
    public void detail() {
        System.out.println("\n----------零钱通明细-----------\n项  目\t金额\t时间\t\t\t余额");
        System.out.println(detailStr);
    }

    public void income() {
        System.out.print("请输入收益金额: ");
        double money = scanner.nextDouble();

        // 收入金额验证(对错误条件进行验证)
        if (money < 0) {
            System.out.println("请输入不小于0的收益金额");
            return;
        }

        count += money;
        date = new Date();
        detailStr += "收入\t" + money + "\t" + sdf.format(date) + "\t" + count + "\n";
    }

    // 支出功能
    public void pay() {
        System.out.print("请输入消费的金额: ");
        double money = scanner.nextDouble();

        // 错误金额验证
        if (money > count || money < 0) {
            System.out.println("您的消费金额应在0-" + count + "之间");
            return;
        }

        System.out.print("消费信息: ");
        String payStr = scanner.next();

        count -= money;

        date = new Date();
        detailStr += payStr + "\t" + money + "\t" + sdf.format(date) + "\t" + count + "\n";

        
    }

    public void exit(){
        String choice = "";

        // 用于检验合法输入
        while (true) {
            System.out.println("您是否要退出: 请输入y/n");
            choice = scanner.next();
            if (choice.equals("y") || choice.equals("n")) {
                break;                
            }
        }

        // 用于判断是否退出，通过loop属性将信息传递给其他方法
        if (choice.equals("y")) {
            loop = false;
        }

    }
    
}
