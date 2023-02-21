package Chapter13.class_;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;


import Chapter13.Car;

// 介绍Class的相关方法
public class ClassTest01 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException {

        String classAllPath = "Chapter13.Car";
        Class<?> cls = Class.forName(classAllPath);
        System.out.println(cls);  // 这里打印的是 cls 是谁的Class对象

        System.out.println("Class对象所在的包名:" + cls.getPackageName()); 

        System.out.println("Class对象的全路径:" + cls.getName());  

        // 通过无参构造器得到对象
        Car car1 = (Car) cls.getDeclaredConstructor().newInstance();
        System.out.println(car1);

        // 通过反射得到符合访问权限的属性 如果想操作私有属性，需要执行.setAccessible(true)
        Field name = cls.getField("name");
        System.out.println(name.get(car1));

        // 通过反射给符合访问权限的属性赋值/修改
        name.set(car1, "奔驰");
        System.out.println("修改属性后car: " + car1);

        // 得到类的所有属性
        Field[] fields = cls.getFields();
        for (Field f : fields) {
            System.out.print(f.getName() + "\t"); // 得到每个符合访问权限的属性的名字
        }




    }
    
}
