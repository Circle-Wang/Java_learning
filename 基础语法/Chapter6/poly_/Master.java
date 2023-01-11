package Chapter6.poly_;


public class Master {
    
    private String name;

    public static void main(String[] args) {
        Master wang = new Master("小王");
        Dog dog = new Dog("大黄");
        Cat cat = new Cat("小花");
        Bone bone = new Bone("大棒骨头");
        Fish fish = new Fish("大黄鱼");

        wang.feed(cat, fish);
        wang.feed(dog, bone);

    }

    public Master(String name) {
        this.name = name;
    }


    // 采用多态特性
    // 形参列表 指定的是编译类型
    // animal 编译类型是 Animal, 可以指向(接收)Animal的任何子类
    // food 编译类型是 Food, 可以指向(接收)Food的任何子类
    // 无论任何食物或者动物，只要是Animal的子类和Food的子类，都可以使用这个方法。
    public void feed(Animal animal, Food food) {
        System.out.println("主人 " + name + " 给 " + animal.getName() + " 吃 " + food.getName());
    }
    
}



// 两个继承自Animal的动物类
class Cat extends Animal{

    public Cat(String name) {
        super(name);
    }
    
}

class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }
    
}

// 两个继承自Food的食物类
class Fish extends Food {

    public Fish(String name) {
        super(name);
    }
    
}

class Bone extends Food {

    public Bone(String name) {
        super(name);
    }
    
}