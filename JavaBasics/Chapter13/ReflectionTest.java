package Chapter13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

// 反射的快速入门
public class ReflectionTest {
    public static void main(String[] args) throws FileNotFoundException, IOException,
            ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException,
            SecurityException, InvocationTargetException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("Chapter13//配置文件.properties"));

        // 读取配置文件中对应字段
        String classFullPath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();


        // 使用反射机制
        // (1) 使用Class类从类路径得到Class对象
        Class<?> cls = Class.forName(classFullPath);

        // (2) 从Class中得到 指定路径的对象
        Object o = cls.newInstance();
        System.out.println("O的运行类型是:" + o.getClass());

        // (3) 得到Method对象
        Method method1 = cls.getMethod(methodName);
                

        // (4) 通过Method对象的.invoke()方法执行
        method1.invoke(o);
    }
    
}
