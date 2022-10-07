package Demo10;

// 不安全的取钱
public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account(100, "结婚基金");

        Drawing you = new Drawing(account, 50, "你");  // 取50
        Drawing girlFriend = new Drawing(account, 70, "女朋友"); // 女朋友也取50
        
        you.start();
        girlFriend.start();

    }
    
    
}

// 账户
class Account{
    int money;   // 账户余额
    String name; // 卡名

    public Account(int money, String name){
        this.money = money;
        this.name = name;
    }

}

// 银行模拟取款
class Drawing extends Thread{
    Account account;  // 账户 
    int drawingMoney; // 取了多少钱
    int nowMoney;     // 手里现在的钱

    public Drawing(Account account, int drawingMoney, String name){
        super(name);  // 调用父类的构造方法, 传递一个名字进去(可以使用this.name得到这个东西)
        this.account = account;
        this.drawingMoney = drawingMoney;

    }

    @Override
    public void run() {
        // 判断有没有钱
        if (account.money < drawingMoney){
            System.out.println(Thread.currentThread().getName() + "钱不够");
            return;
        }
        

        account.money -= drawingMoney;  // 更新卡内余额
        nowMoney += drawingMoney;       // 更新手里的钱

        System.out.println(account.name + "余额为:" + account.money);
        System.out.println(this.getName() + "手里的钱:" + nowMoney);  // 此处this = Thread.currentThread()

    }

    

}
