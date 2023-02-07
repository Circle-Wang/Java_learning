package Chapter7;

// 模板设计模式讲解
public class TemplateTest {
    public static void main(String[] args) {
        TempB bb = new TempB();
        TempC cc = new TempC();
        bb.calculateTimes();
        cc.calculateTimes();
    }
}

abstract class TempA {
    // 需要子类重写该方法
    public abstract void job();

    // 调用job()的方法
    public void calculateTimes() {
        long start = System.currentTimeMillis(); // 统计当前时间到1970-1-1 0:0:0 的时间差 单位ms
        job(); // 此处如果子类调用该方法则会触发动态绑定机制
        long end = System.currentTimeMillis();
        System.out.println("job()耗时" + (end - start));
    }
}

class TempB extends TempA {

    int num = 0;
    // 重写抽象方法
    @Override
    public void job() {
        for (int i = 0; i < 3; i++) {
            num += 1;
            try {
                Thread.sleep(30); // 暂停30ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("TempB类job()被调用");
    }
}


class TempC extends TempA {

    int num = 0;
    // 重写抽象方法
    @Override
    public void job() {
        for (int i = 0; i < 2; i++) {
            num += 1;
            try {
                Thread.sleep(20); // 暂停20ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("TempC类job()被调用");
    } 
}