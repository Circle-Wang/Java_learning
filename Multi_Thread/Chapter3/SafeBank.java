package Chapter3;

// 安全的银行
public class SafeBank {
    public static void main(String[] args) {
        Account account = new Account(100, "结婚基金");

        SafeDrawing you = new SafeDrawing(account, 50, "你");  // 取50
        SafeDrawing girlFriend = new SafeDrawing(account, 70, "女朋友"); // 女朋友也取50
        
        you.start();
        girlFriend.start();

    }
    
}

// 安全的银行模拟取款
class SafeDrawing extends Thread{
    Account account;  // 账户 
    int drawingMoney; // 取了多少钱
    int nowMoney;     // 手里现在的钱

    public SafeDrawing(Account account, int drawingMoney, String name){
        super(name); // 调用父类有参构造
        this.account = account;
        this.drawingMoney = drawingMoney;

    }

    @Override
    public void run() {

        // 使用synchronized块, 锁的对象是account，同一时间只有一个线程能操作该对象
        synchronized (account){
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
}
