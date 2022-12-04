package Demo5;

public class Talker1 {

    public static void main(String[] args) {

        new Thread(new TalkReceive(6685)).start(); // 监听6685端口，用于接收信息
        new Thread(new TalkSend("localhost", 8888)).start();  // 向8888发送信息
        
    }


}
