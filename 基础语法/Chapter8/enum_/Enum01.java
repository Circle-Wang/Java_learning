package Chapter8.enum_;

class Enum01 {
    private String name;
    private String feel;
    public static final Enum01 SPRING = new Enum01("春天", "温暖");
    public static final Enum01 WINTER = new Enum01("冬天", "寒冷");
    public static final Enum01 AUTUMN = new Enum01("秋天", "凉爽");
    public static final Enum01 SUMMER = new Enum01("夏天", "炎热");

    // 私有化构造器外部不能new
    private Enum01(String name, String feel) {
        this.name = name;
        this.feel = feel;
    }

    @Override
    public String toString() {
        return "Enum01 [name=" + name + ", feel=" + feel + "]";
    }

}