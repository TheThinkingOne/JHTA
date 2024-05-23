package socket;

import java.io.IOException;
import java.net.Socket;

public class TimeClient {
    public static void main(String[] args) {
        Socket socket;
        try {
            socket = new Socket("localhost",8877);
            System.out.println("서버 접속됨 bitch~");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
