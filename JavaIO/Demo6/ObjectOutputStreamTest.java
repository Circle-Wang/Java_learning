package Demo6;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import Demo5.Dog;

public class ObjectOutputStreamTest {
    public static void main(String[] args) throws IOException {

        ObjectOutputStream obos = new ObjectOutputStream(new FileOutputStream("Demo6/序列化生成文件.dat"));
        // 基本数据类型序列化
        obos.writeInt(125);
        obos.writeBoolean(true);
        obos.writeChar('a');
        obos.writeUTF("君子慎独, 不欺暗室");

        // 自定义类序列化, 导入Demo5中的一个Dog类
        Dog dog1 = new Dog(12,"小花");
        obos.writeObject(dog1);

        System.out.println("序列化完成");


        obos.close();
    }
    
}
