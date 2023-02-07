package Chapter8.enum_;

public enum Enum02 {
    // 需要将枚举对象放在第一行
    SPRING("春天", "温暖"), WINTER("冬天", "寒冷"),
    AUTUMN("秋天", "凉爽"), SUMMER; // 使用无参构造器可以直接省略小括号

    private String name;
    private String feel;

    // 私有化构造器外部不能new
    private Enum02(String name, String feel) {
        this.name = name;
        this.feel = feel;
    }

    private Enum02() {
    }


    @Override
    public String toString() {
        return "Enum02 [name=" + name + ", feel=" + feel + "]";
    }
}
