package Chapter6.Object_;

public class ToStringExercise {
    public static void main(String[] args) {
        Monster monster = new Monster("小妖怪", 12.5);
        System.out.println(monster.toString()); 
        System.out.println(monster);
    }
    
}

class Monster {

    private String name;
    private double sal;
    
    public Monster(String name, double sal) {
        this.name = name;
        this.sal = sal;
    }




    // 重写toString方法(模板)
    public String toString() {
        return "Monster [name=" + name + ", sal=" + sal + "]";
    }

   
}
