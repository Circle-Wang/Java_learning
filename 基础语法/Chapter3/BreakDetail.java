package Chapter3;


public class BreakDetail {
    public static void main(String[] args) {
        // break 中标签的使用
        label1:
        for (int j = 0; j < 4; j++) {
        label2:
            for (int i = 0; i < 10; i++) {
                if (i == 2){
                    break label1;
                }
                System.out.println("i=" + i);
            }
            
        }
        
    }
    
}
