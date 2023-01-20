package Chapter10.dateClass_;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LocalDateTimeTest {
    public static void main(String[] args) {
        // 获得当前时间对象
        LocalDateTime nowDate = LocalDateTime.now();  // LocalDate.now()、LocalTime.now()
        System.out.println("未格式化时间:" + nowDate);

        // 使用DateTimeFormatter类进行格式化
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH小时mm分钟ss秒 E");
        String formatDate = dtf.format(nowDate);
        System.out.println("格式化后的时间: " + formatDate);

        // 使用LocalDateTime的某些方法可以进行日期的加减
        LocalDateTime plusDays = nowDate.plusDays(10);; // 获得增加10天的LocalDateTime对象
        System.out.println("增加10天后的日期: " + dtf.format(plusDays));
        LocalDateTime minusHours = nowDate.minusHours(26);; // 获得减少120小时的LocalDateTime对象
        System.out.println("减少120小时后的日期: " + dtf.format(minusHours));


        // Instant类 时间戳对象
        Instant ins = Instant.now(); // 返回当前时间戳
        Date fromIns = Date.from(ins); // 从Instant对象转换为Date对象
        Instant instant = fromIns.toInstant(); // 从Date对象转化为Instant对象
        System.out.println(instant);

    }
    
}
