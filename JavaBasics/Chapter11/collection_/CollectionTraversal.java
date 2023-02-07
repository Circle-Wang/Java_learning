package Chapter11.collection_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@SuppressWarnings({"all"})
public class CollectionTraversal {
    public static void main(String[] args) {
        Collection coll = new ArrayList();
        coll.add(new Book("三国演义", 20));
        coll.add(new Book("红楼梦", 50));
        coll.add(new Book("西游记", 110));
        coll.add(new Book("三毛历险记", 70));
        System.out.println(coll); // 可以直接打印集合，集合内部将会自动调用对象的toString方法

        System.out.println("=========迭代器遍历======");
        traversal1(coll);
        System.out.println("=========增强for循环遍历======");
        traversal2(coll);

        
    }

    // 采用iterator(迭代器)方式遍历集合
    public static void traversal1(Collection coll) {

        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) { // 需要判断下一行是否有对象
            Book nextBook = (Book) iterator.next(); // .next()得到的是Object，此处向下转型
            System.out.println("该本书是:" + nextBook);
        }
        // iterator.next(); // 会报异常NoSuchElementException
        
    }

    // 采用增强for循环方式遍历集合
    public static void traversal2(Collection coll) {

        for (Object obj : coll) {
            Book book = (Book) obj;
            System.out.println("该本书是:" + book);
        }
        
    }
    
}

class Book {
    String name;
    int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book [书名=" + name + ", 价格=" + price + "]";
    }

}
