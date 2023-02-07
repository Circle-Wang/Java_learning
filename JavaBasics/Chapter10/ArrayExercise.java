package Chapter10;

import java.util.Arrays;
import java.util.Comparator;

@SuppressWarnings({"all"})
// 完成对对象的定制排序
public class ArrayExercise {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦", 100);
        books[1] = new Book("金瓶梅", 90);
        books[2] = new Book("青年文摘", 5);
        books[3] = new Book("java从入门到放弃", 300);

        Arrays.sort(books, new Comparator(){
            
            @Override
            public int compare(Object o1, Object o2) {
                Book b1 = (Book) o1;
                Book b2 = (Book) o2;
                if (b1.price > b2.price) { // 如b1价格大于b2价格
                    return -1;  // 让b1排在前面
                } else {
                    return 1; 
                }
            }
            
        });
        System.out.println(Arrays.toString(books));
        
        
    }
    
}

class Book {
    String name;
    double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book [name=" + name + ", price=" + price + "]";
    }
    
}
