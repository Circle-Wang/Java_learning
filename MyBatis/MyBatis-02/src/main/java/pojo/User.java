package pojo;

/*
这里使用Lombok包的注解
@Data: 实现自动的重写全参数的get set 以及 toString方法
@AllArgsConstructor: 自动实现全参数的有参构造(会自动删除无参构造)
@NoArgsConstructor: 自动实现无参构造
@Getter: 如果只是想在某个字段上生成get方法可以在修饰字段
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    // 该类的字段需要对应上数据库中的字段
    private int id;
    @Getter
    private String name;
    private String pwd;


//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPwd() {
//        return pwd;
//    }
//
//    public void setPwd(String pwd) {
//        this.pwd = pwd;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", pwd='" + pwd + '\'' +
//                '}';
//    }
}
