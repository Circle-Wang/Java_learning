package Demo5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;


public class TalkSend implements Runnable{


    DatagramSocket socket = null;
    BufferedReader read = null;
    InetSocketAddress targetIp = null;

    private String toIP;
    private int toPart;

    public TalkSend(String toIP, int toPart) {
        this.toIP = toIP;
        this.toPart = toPart;
        // 生成目标IP和端口
        this.targetIp = new InetSocketAddress(this.toIP, this.toPart);

        try {
            socket = new DatagramSocket();  // 初始化发送信息的对象
            read = new BufferedReader(new InputStreamReader(System.in, "GBK"));
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {

        while (true) {
            try {
                String data = read.readLine();  // 读取控制台的输入
                byte[] dataByte = data.getBytes();
                DatagramPacket packet = new DatagramPacket(dataByte, 0, dataByte.length, this.targetIp);
                socket.send(packet);  // 向目标发送信息

                if (data.equals("bye")){
                    break;
                }
    
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        // 关闭数据流
        System.out.println("\n已经结束对话");
        socket.close();
    }


}
