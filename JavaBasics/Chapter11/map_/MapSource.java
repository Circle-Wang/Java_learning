package Chapter11.map_;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;


// 用于探究Map原码
@SuppressWarnings({"all"})
public class MapSource {
    public static void main(String[] args) {
        Map map = new HashMap();
        
        // 使用put将K-V键值对添加进集合
        map.put("no1", "张三");
        map.put("no2", "李四");
        System.out.println(map);

        Set set = map.entrySet();
        System.out.println(set.getClass()); // 运行类型是HashMap$EntrySet内部类
        for (Object entry : set) {  // 其实调用的就是iterator()方法, 每一次返回的是HashMap$Node对象
            System.out.println("=================");
            System.out.println(entry.getClass());         // 获得集合中每个元素运行类型HashMap$Node 
            System.out.println(((Entry) entry).getKey()); // 由于HashMap$Node不是一个public的静态内部类无法强转
            System.out.println(((Entry) entry).getValue());
            
        }
    }
    
    
    
}
