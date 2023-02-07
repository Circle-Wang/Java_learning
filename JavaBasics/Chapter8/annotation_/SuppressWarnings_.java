package Chapter8.annotation_;

public class SuppressWarnings_ {
    @SuppressWarnings({"unused"}) // 忽略不使用的警告
    private int n1;

    public void m1() {
        int j; // 此时不在抑制范围以内因此，也会报警告

        
    }

}
