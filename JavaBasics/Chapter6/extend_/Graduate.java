package Chapter6.extend_;


public class Graduate extends Student {
    

    public Graduate() {
        // super(); // 这句会默认执行，如果父类没有无参构造器则我们需要指定执行父类的哪个构造器
        System.out.println("子类Graduate的无参构造器被调用");
    }

    public void testing() {
        System.out.println("大学生 " + name + "正在考大学数学...");  // 此处name不报错是因为此处name指向的是父类Student中name的。
        
    }
    
}
