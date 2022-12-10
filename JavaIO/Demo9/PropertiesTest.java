package Demo9;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        // 载入配置文件
        properties.load(new FileReader("Demo9/mysql.properties"));

        // 将配置文件显示
        properties.list(System.out);

        // 根据key获得值
        String user = properties.getProperty("user");
        String IP = properties.getProperty("ip");
        String pwd = properties.getProperty("pwd");
        System.out.println(user + IP + pwd);
        
        // 修改/创建properties的内容(注意此时只是在内存中更新了键值对)
        properties.setProperty("pwd", "new_pwd");
        properties.setProperty("new_property", "新属性值");
        // 将修改后的properties
        properties.list(System.out);
        // 将修改后的重新保存
        properties.store(new FileOutputStream("Demo9/mysql.properties"), null);


        // 创建一个新的配置文件，并写入一些信息
        Properties properties2 = new Properties();
        properties2.setProperty("姓名", "CircleWang");
        properties2.setProperty("age", "18");
        properties2.setProperty("pwd", "12546");
        // 保存
        properties2.store(new FileOutputStream("Demo9/新配置文件.properties"), "这是文件的注释");
        System.out.println("保存成功");

    }
    
}
