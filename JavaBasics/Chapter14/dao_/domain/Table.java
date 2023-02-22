package Chapter14.dao_.domain;


// 表示一张表的每行数据的类
public class Table {
    private String id;  // 表中的一个字段
    private String supplier; 

    // 必须保留无参构造器(反射时会使用)
    public Table() {
    }

    public Table(String id, String supplier) {
        this.id = id;
        this.supplier = supplier;
    }


    @Override
    public String toString() {
        return "Table [id=" + id + ", supplier=" + supplier + "]";
    }

    // 需要具有get和set方法
    public String getId() {
        return id;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    
}
