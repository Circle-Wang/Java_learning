package Chapter11.list_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.LinkedList;

@SuppressWarnings({"all"})
public class ListExercise {
    public static void main(String[] args) {
        List list = new ArrayList();  // 此处可以换成 LinkedList, 或 Vector都可以, 因为这仨都是List的子类
        list.add(new Book("三国演义", 20));
        list.add(new Book("红楼梦", 50));
        list.add(new Book("西游记", 110));
        list.add(new Book("三毛历险记", 70));

        //  - 对象.indexOf(Object): 返回目标对象在集合中首次出现的位置
    // - 对象.add(index, Object): 将对象插入到集合下标为index的位置, 其余元素向后推移
    // - 对象.addAll(index, Collection): 从集合的index位置插入参数集合中的所有元素
    // - 对象.set(index, Object): 将集合的index位置的元素替换为Object。
    // - 对象.subList(fromIndex, toIndex): 返回下标从[fromIndex, toIndex)的子集合
        // 在指定位置插入对象
        list.add(2, new Book("白发魔女传", 110)); 
        System.out.println("插入后List: " + list);

        // 使用.get获取指定下标对象(返回的是Object对象)
        Book book1 = (Book) list.get(3);
        System.out.println("获取的书是: " + book1);

        // 删除指定对象的元素(采用的是.equals(obj)来比较判别两个元素是否相等)
        System.out.println(list.remove(new Book("三国演义", 20))); // F
        System.out.println("删除后的List: " + list);

        // 进行排序
        sort(list);
        System.out.println("=======排序后List=======");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i)); 
        }
    }

    // 采用冒泡排序将List集合中元素排序
    public static void sort(List list) {
        int listSize = list.size();

        for (int i = 0; i < listSize; i++) {
            for (int j = 0; j < listSize - 1 - i; j++) {
                Book b1 = (Book) list.get(j);  // 需要向下转型才能使用getPrice()方法
                Book b2 = (Book) list.get(j + 1);
                if (b1.getPrice() > b2.getPrice()) { // b1价格大于b2价格则交换
                    list.set(j, b2);
                    list.set(j + 1, b1);
                }
            }
        }
    }
    
}

class Book {
    private String name;
    private int price;

    public int getPrice() {
        return price;
    }

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "书名:" + name + "\t价格:" + price;
    }

}



