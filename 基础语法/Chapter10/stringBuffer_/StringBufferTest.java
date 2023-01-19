package Chapter10.stringBuffer_;

public class StringBufferTest {
    public static void main(String[] args) {

        // 默认value长度16
        StringBuffer stringBuffer1 = new StringBuffer();
        // 指定value长度28
        StringBuffer stringBuffer2 = new StringBuffer(28);
        // 通过字符串创建(字符串对象——>StringBuffer对象)
        StringBuffer stringBuffer3 = new StringBuffer("字符串长度");

        // 通过append从字符串类创建StringBuffer
        StringBuffer stringBuffer4 = new StringBuffer();
        stringBuffer4.append("新字符串"); // 将会直接修改stringBuffer4中字符串
        System.out.println(stringBuffer4);

        // StringBuffer转化为String类，方式一
        String s1 = stringBuffer4.toString();
        // StringBuffer转化为String类，方式二
        String s2 = new String(stringBuffer4);
        
    }
    
}
