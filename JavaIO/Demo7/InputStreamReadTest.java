package Demo7;

import java.io.BufferedReader;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStreamReader;


public class InputStreamReadTest {
    public static void main(String[] args) throws IOException {
        InputStreamReader gbkReader = new InputStreamReader(new FileInputStream("Demo7/GKB编码文档.txt"), "GBK");
        InputStreamReader gbkReader2 = new InputStreamReader(new FileInputStream("Demo7/GKB编码文档.txt"), "GBK");
        
        // 我们可以根据Reader的方式进行读取
        char[] buffer = new char[3];
        int len = 0;
        while ((len = gbkReader.read(buffer)) != -1){
            System.out.print(new String(buffer,0,len));
        }

        System.out.println("\n=============");

        // 我们也可以采用包装流包装成BufferedReader
        BufferedReader br = new BufferedReader(gbkReader2);
        String str;
        while ((str = br.readLine()) != null){
            System.out.print(str);
        }

        gbkReader.close();
        br.close();


    }
    
}
