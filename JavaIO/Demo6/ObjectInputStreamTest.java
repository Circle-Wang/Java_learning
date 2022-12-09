package Demo6;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import Demo5.Dog;

public class ObjectInputStreamTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream obis = new ObjectInputStream(new FileInputStream("Demo6/序列化生成文件.dat"));

        // 需要按生成顺序, 依次读取
        System.out.println(obis.readInt());
        System.out.println(obis.readBoolean());
        System.out.println(obis.readChar());
        System.out.println(obis.readUTF());
        
        Object dog = obis.readObject();  // 此时程序会根据"序列化生成文件.dat"文件中记录的类路径去找到该类。(此时类的方法才被载入)
        System.out.println(dog);  // 会执行dog类中toString方法
        System.out.println("================");

        Dog dog2 = (Dog) dog;  // 向下转型
        dog2.myPrint();


        obis.close();

    }
    
}
