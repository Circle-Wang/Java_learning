package Chapter11.map_;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

@SuppressWarnings({"all"})
public class MapTraversal {
    public static void main(String[] args) {

        Map map = new HashMap();
        map.put("邓超","孙俪");
        map.put("王宝强","马蓉");
        map.put("宋喆","马蓉");
        map.put("鹿晗","关晓彤");
        map.put(null,"刘亦菲");
        System.out.println("map=" + map);

        
        System.out.println("=======遍历方法一========");
        Set keySet = map.keySet();
        for (Object key : keySet) {
            System.out.println(key + "-" + map.get(key));
        }

        System.out.println("=======遍历方法二========");
        Collection values = map.values();
        Iterator iterator = values.iterator();
        while (iterator.hasNext()) {
            Object value = iterator.next();
            System.out.println("Value=" + value);
        }

        System.out.println("=======遍历方法三========");
        Set entrySet = map.entrySet();
        for (Object obj : entrySet) {  
            Entry entry = (Entry) obj; // 需要向下转型才能使用.getKey()
            System.out.println(entry.getKey() + "-" + entry.getValue());  
        }
    }
    
}
