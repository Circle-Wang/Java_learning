package Demo1;
import java.io.File;
import java.io.IOException;

public class FileCreate {
    public static void main(String[] args) {

        // 创建方式1
        String filePath1 = "Demo1\\news1.txt";
        File file1 = new File(filePath1);

        try {
            file1.createNewFile(); // 执行创建命令
            System.out.println("文件1创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }


        // 创建方式2(通过父对象) 
        File parentPath = new File("Demo1"); 
        File file2 = new File(parentPath, "news2.txt");

        try {
            file2.createNewFile();   // 执行创建命令
            System.out.println("文件2创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        } 

    }

}
