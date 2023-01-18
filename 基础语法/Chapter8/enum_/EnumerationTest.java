package Chapter8.enum_;


public class EnumerationTest {
    public static void main(String[] args) {
        System.out.println(Enum01.AUTUMN);
        System.out.println(Enum01.SPRING);
        System.out.println("==================");
        System.out.println(Enum02.WINTER);
        System.out.println(Enum02.SUMMER);
        System.out.println("===============");

        // 练习enum类的方法(Enum父类很多方法)
        Enum02 winner = Enum02.WINTER;

        System.out.println(winner.toString());
        System.out.println(winner.ordinal()); // 返回该枚举对象在定义时候的次序
        System.out.println(winner.compareTo(Enum02.SUMMER)); // 返回两个枚举对象次序的差
        System.out.println(winner.name()); // 返回枚举对象的名称
        
        Enum02[] enum02s = Enum02.values(); // Enum02.values()得到包含所有枚举对象的数组
        for (Enum02 enumer : enum02s) { 
            System.out.print(enumer.name() + "\t"); 
        }

        Enum02 spring = Enum02.valueOf("SPRING"); // 返回符合字符串的枚举对象
        System.out.println("\n" + spring.name());

    }
}


