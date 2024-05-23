import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerSocketTest {

    public static void main(String[] args) {
        ServerSocket listener;
        Socket socket;
        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter;
        Scanner scanner = new Scanner(System.in);
        try {
            //"192.168.0.83"
            listener = new ServerSocket(9988); //
            System.out.println("나는 서버 소켓입니다. 클라이언트의 연결을 기다리고 있습니다.");
            socket = listener.accept();
            System.out.println("클라이언트 소켓 연결됨");
            bufferedWriter = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream())
            );
            bufferedReader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            while(true) {
                String inputMsg = bufferedReader.readLine();
                System.out.println("socket에서 보낸 메세지 : "+inputMsg);
                String outputMsg = scanner.nextLine();
                bufferedWriter.write(outputMsg + "\n"); // 줄바꿈 표시
                bufferedWriter.flush();// buffer가 차지 않아서 안나갈 경우 한번에 남아 있는거 보내기
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

