package Chapter7;

public class CodeBlockTest03 {
    public static void main(String[] args) {
        // 首先进行类的加载才能创建对象，因此先加载父类 再 加载子类
        // 在加载类信息时开始执行了静态相关内容(静态代码块/静态属性初始化)
        new BB(); // 开始进入构造器, 触发super()
    }
    
}


class AA {
    
    {
        System.out.println("--AA(父类)的普通代码块--");
    }

    static {
        System.out.println("--AA(父类)的静态代码块--");
    }

    public AA() {
        // 隐藏了 super()
        // 隐藏了 执行普通代码块/普通属性初始化
        System.out.println("AA(父类) 构造器被调用");
    }

}

class BB extends AA {
    
    {
        System.out.println("--BB(子类)的普通代码块--");
    }

    static {
        System.out.println("--BB(子类)的静态代码块--");
    }

    public BB() {
        // 隐藏了两个部分
        // 隐藏了 super()
        // 隐藏了 执行普通代码块/普通属性初始化
        System.out.println("BB(子类) 构造器被调用");
    }
    
}