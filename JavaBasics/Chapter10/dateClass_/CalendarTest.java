package Chapter10.dateClass_;

import java.util.Calendar;

public class CalendarTest {
    public static void main(String[] args) {
        Calendar cld = Calendar.getInstance(); // 调用静态方法获得当前时间
        // 通过cld.get()方法得到相关的时间数据，需要我们自行格式化
        System.out.println(cld.get(Calendar.YEAR)+ "年" + (cld.get(Calendar.MONTH) + 1) + "月" + 
                         cld.get(Calendar.HOUR_OF_DAY) + "时" +
                         cld.get(Calendar.MINUTE) + "分");


    }
    
}
