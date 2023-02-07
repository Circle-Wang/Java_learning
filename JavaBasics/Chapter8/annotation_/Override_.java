package Chapter8.annotation_;


class OverA {

    public void hi(){

    }

}

class OverB extends OverA {

    // 编译器会检查hi()是否真的是在 重写/实现 父类/接口的方法，如果不是会编译报错
    // @Override只能修饰方法
    @Override 
    public void hi(){

    }

}