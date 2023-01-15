package Chapter7;


public class SingletonTest {
    public static void main(String[] args) {
        GirlFriend gf1 = GirlFriend.getInstance();  // 通过公有方法获取类中的对象
        GirlFriend gf2 = GirlFriend.getInstance();

        System.out.println(gf1);
        System.out.println(gf2);
        System.out.println(gf1 == gf2); // 指向的时同一个内存地址
        System.out.println("============");

        BoyFriend bf1 = BoyFriend.getInstance();
        BoyFriend bf2 = BoyFriend.getInstance();
        System.out.println(bf1);
        System.out.println(bf2);
        System.out.println(bf1 == bf2); // 指向的时同一个内存地址
        System.out.println("============");
    }
    
}

// 饿汉模式
// 在加载类的同时，已经完成了类对象的实例化
class GirlFriend {
    private String name;

    // 在类加载时就实例化了对象
    private static GirlFriend gf = new GirlFriend("小静");

    public GirlFriend(String name) {
        this.name = name;
    }

    // 公共方法: 将对象地址传递出去
    public static GirlFriend getInstance() {
        return gf;
    }

    @Override
    public String toString() {
        return "GirlFriend [name=" + name + "]";
    }
}

// 懒汉模式
// 当第一次调用getInstance方法时初始化对象
class BoyFriend {
    private String name;

    // 在类加载时就实例化了对象
    private static BoyFriend bf;

    public BoyFriend(String name) {
        this.name = name;
    }

    // 公共方法: 将对象地址传递出去
    public static BoyFriend getInstance() {
        // 如果类对象没有被初始化过就执行初始化
        // 在多线程时，可能存在线程不安全
        if (bf == null) {
            bf = new BoyFriend("小王");
        }
        return bf;
    }

    @Override
    public String toString() {
        return "BoyFriend [name=" + name + "]";
    }
}