package Chapter9.throws_;

public class Throws02 {
    
}

class Father {

    public void f1() throws RuntimeException {
        
    }
}

class Son extends Father {

    @Override
    public void f1() throws RuntimeException { // 此处抛出的异常必须是RuntimeException或者其子类异常
        super.f1();
    }
}