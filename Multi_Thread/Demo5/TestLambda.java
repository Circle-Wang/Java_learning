package Demo5;

/*
 * 推导Lambda表达式
*/
public class TestLambda {

    // 3、也可以使用静态内部类来实现
    static class Like2 implements ILike{

        @Override
        public void lambda() {
            System.out.println("I like lambda2");
            
        }
    
    }


    public static void main(String[] args) {
        ILike like = new Like();  // 注意此处是使用ILike从接口去创建的对象
        like.lambda();

        like = new Like2(); // 此处是接口引用指向了Like2对象，不再指想Like1对象了
        like.lambda();


        // 4、局部内部类
        class Like3 implements ILike{
            @Override
            public void lambda() {
                System.out.println("I like lambda3");
                
            }
        }

        like = new Like3();  // 此处接口引用又指向了Like3对象
        like.lambda();

        // 5、匿名内部类：没有类的名称，必须借助接口或者父类
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("I like lambda4");
                
            }
        };   // 此时like又指向了匿名内部类对象
        like.lambda();

        // 6、使用lambda表达式简化
        like = () -> {
            System.out.println("I like lambda5");  
        };
        like.lambda();

        // 7、新建一个接口对象
        ILike like2 = () -> {
            System.out.println("I like lambda6");  
        };
        like2.lambda();


    }
}


// 1、定义一个接口类，只包含一个抽象方法 = 函数式接口
interface ILike{
    void lambda();
}

// 2、实现接口类
class Like implements ILike{

    @Override
    public void lambda() {
        System.out.println("I like lambda");
        
    }

}
