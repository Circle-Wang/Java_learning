package Chapter10.dateClass_;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) throws ParseException {
        Date dt = new Date(); // 获取当前时间, 未格式化
        System.out.println("未格式化时间: " + dt);

        // 得到格式类的对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分钟ss秒 E"); 
        // 将Date对象转化未格式化的String
        String formatDate = sdf.format(dt);
        System.out.println("格式化后的时间: " + formatDate);

        // 将String按格式化模板，转化为Date对象, 需要与格式化模板相等
        String dateString = "2012年3月5日 22时42分钟32秒 星期日";
        Date newDate = sdf.parse(dateString); // 此处需要抛出异常
        System.out.println("将String转化成Date对象后:" + newDate);
    }
    
}
