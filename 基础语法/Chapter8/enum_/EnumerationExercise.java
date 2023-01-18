package Chapter8.enum_;

public class EnumerationExercise {
    public static void main(String[] args) {
        // 演示switch中对枚举对象的使用
        Color green = Color.GREEN; // 枚举对象通过类.枚举值得到
        green.show();

        // 在switch中放入枚举对象，在case后只用写枚举名即可。
        // 底层其实是通过调用ordinal()方式获得序列值从而进行判定的。
        switch (green) {
            case YELLOW:
                System.out.println("匹配到黄色");
                break;
            case RED:
                System.out.println("匹配到红色");
                break;
            case BLACK:
                System.out.println("匹配到黑色");
                break;
            case GREEN:
                System.out.println("匹配到绿色");
                break;
            case BLUE:
                System.out.println("匹配到蓝色");
                break;
        }

    }

}

interface IA {
    void show();
}

enum Color implements IA{
    RED(255,0,0), 
    BLUE(0,0,255),
    YELLOW(255,255,0), 
    GREEN(0,255,0),
    BLACK(0,0,0);

    private int redValue;
    private int greenValue;
    private int blueValue;

    private Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
        
    }

    @Override
    public void show() {
        System.out.println("属性值为" + redValue + "," + greenValue + "," + blueValue);
    }
    
}
