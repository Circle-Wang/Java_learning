package Demo5;

public class Talker2 {

    public static void main(String[] args) {

        new Thread(new TalkReceive(8888)).start(); // 监听8888端口，用于接收信息
        new Thread(new TalkSend("localhost", 6685)).start();  // 向6685发送信息
        
    }


}
