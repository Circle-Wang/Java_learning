package Chapter13;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;


public class ReflectionTest2 {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException,
            NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException {

        String classFullPath = "Chapter13.Dog";
        String fieldName = "name";

        // 通过反射得到Class对象
        Class<?> cls = Class.forName(classFullPath);
        Object o = cls.newInstance(); // 默认使用无参构造器得到对象

        // 对象成员属性的获得
        // 得到非公有的属性对象(Field对象)
        Field field = cls.getField(fieldName);

        // 通过Field对象的.get(o)方法得到属性值
        System.out.println(field.get(o));

        // 对象构造器的获得
        Constructor<?> constructor1 = cls.getConstructor(); // 返回无参构造器
        Constructor<?> constructor2 = cls.getConstructor(String.class); // 返回有参构造器对象
        constructor1.newInstance(); // 可以使用构造器得到对象
        constructor2.newInstance("小狗");

    }
    
}
