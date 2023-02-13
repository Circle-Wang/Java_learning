package Chapter1;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;


public class PictureDownload extends Thread {

    private String url;  // 网络图片地址
    private String file_name;  // 

    // 定义构造方法创建类时需要传入两个参数
    public PictureDownload(String url, String file_name){
        this.url = url;
        this.file_name = file_name;
    }

    @Override
    public void run() {
        // run 方法体
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(this.url, this.file_name); // 可以省略this关键字
        System.out.println("已下载图片"+file_name);
        
    }

    // 主线程
    public static void main(String[] args) {

        // 此处是随意从网上找的三张图片链接
        PictureDownload t1 = new PictureDownload("https://t7.baidu.com/it/u=1819248061,230866778&fm=193&f=GIF", "1.jpg");
        PictureDownload t2 = new PictureDownload("https://t7.baidu.com/it/u=4036010509,3445021118&fm=193&f=GIF", "2.jpg");
        PictureDownload t3 = new PictureDownload("https://t7.baidu.com/it/u=963301259,1982396977&fm=193&f=GIF", "3.jpg");
        
        t1.start();
        t2.start();
        t3.start();
        
        System.out.println("完成所有图片下载");

    }
    
}


// 创建下载方法类
class WebDownloader{
    public void downloader(String url, String file_name) {
        try {
            // 别人写好的类：将网络上的图片下载到指定本机地址
            FileUtils.copyURLToFile(new URL(url), new File(file_name));
        } catch (IOException e) {
            // 捕获IO异常
            e.printStackTrace();
            System.out.println("IO异常, downloader异常");
        }
    }

}

