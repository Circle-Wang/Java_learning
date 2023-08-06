package circlewang.pojo;

/*
pojo层与与entity、domain类似，是存放实体的类，
类中定义了多个类属性，并与数据库表的字段保持一致，一张表对应一个model类。
主要用于定义与数据库对象应的属性，提供get/set方法,toString方法,有参无参构造函数。
 */


public class User {
    // 该类的字段需要对应上数据库中的字段
    private int id;
    private String name;
    private String pwd;

    public User() {
    }

    public User(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
