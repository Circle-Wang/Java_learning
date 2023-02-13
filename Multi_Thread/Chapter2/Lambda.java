package Chapter2;

public class Lambda {

    public static void main(String[] args) {

        // 采用匿名内部类的方式创建对象
        ILove like01 = new ILove() {
            @Override
            public void love(int a) {
                System.out.println("匿名内部类接收到的参数是:" + a);
                
            }
        }; 
        like01.love(12);

        // 采用lambda表达式的方式创建对象
        ILove like02 = (int b) -> {
            System.out.println("lambda表达式接收到的参数是" + b);
        };
        like02.love(15);
        
    }


    
}


// 定义一个函数式接口(只有一个待实现方法)
interface ILove{
    void love(int a);
}