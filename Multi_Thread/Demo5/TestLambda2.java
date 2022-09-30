package Demo5;


// lambda在有参数的情况
public class TestLambda2 {

    public static void main(String[] args) {

        ILove person = (int a) ->{
            System.out.println("我接收到的参数是"+a);
        }; // 此处person得到的是一个实现ILike接口的接口类

        // 1、进一步简化：去掉参数
        ILove person2 = (a) -> {
            System.out.println("我接收到的参数是"+a);
        };

        // 2、再次简化：去掉括号，但只能由一个参数的情况，多个参数或者无参数的情况不能去括号
        ILove person3 = a -> {
            System.out.println("我接收到的参数是"+a);
        };

        // 3、再再简化去掉{}括号, 但只能有一行代码的情况
        ILove person4 = a->System.out.println("我接收到的参数是"+a);

        person.love(12);
        person2.love(520);
        person3.love(1314);
        person4.love(5201314);
    }
    
}

// 注意此处不能叫ILike了,因为在另一个包里有这个接口了
interface ILove{
    void love(int a);
}