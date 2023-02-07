package Chapter7.interface_;

// 非公开接口, 只能同包访问
interface InterB {

    // 可以省略public和abstract
    void hello();

    void hi();
    
}


// 可以implement多个接口
class CC implements InterA, InterB {

    @Override
    public void hi() {
        System.out.println("这是BB的hi");
        
    }

    @Override
    public void hello() {
        
    }
    
}


