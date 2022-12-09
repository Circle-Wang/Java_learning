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

        // // 创建方式3(通过父目录+子路径) 
        File file3 = new File("C:/Users/CircleWang/Desktop/JAVA/JavaIO/Demo1", "news3.txt");

        try {
            file3.createNewFile();   // 执行创建命令
            System.out.println("文件3创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        } 

        // 文件常用方法
        System.out.println(file3.getAbsolutePath());
        System.out.println(file3.exists());


        // 文件删除
        if(file3.delete()){
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }

        // 目录的删除
        File file4 = new File("Demo1/子目录");
        if (file4.exists()){
            System.out.println("目录已存在");
        } else {
            if (file4.mkdirs()){
                System.out.println("该目录创建成功");
            }
        }
        

    }

}
