package Chapter8.annotation_;

public class Deprecated_ {
    public static void main(String[] args) {
      DeprA deprA = new DeprA();

      deprA.hi();
        
    }
    
}

@Deprecated  // 在实例化对象是会出现一条横线
class DeprA {
    @Deprecated // 对象在使用n1时会出现一条横线
    public int n1 = 100;


    public void hi(){

    }

    @Deprecated // 对象在调用ok方法是也会出现一条横线
    public void ok(){

    }

}
