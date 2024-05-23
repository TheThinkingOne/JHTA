import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocketTest {
    public static void main(String[] args) {
        //new Socket(127.0.0.1,9900);
        Socket socket;
        BufferedWriter bufferedWriter;
        BufferedReader bufferedReader;
        Scanner scanner = new Scanner(System.in);
        try {
            socket  = new Socket("192.168.0.86",9988);
            //1. socket.getOutputStream() 바깥으로 나갈때  byte
            //2. new OutputStreamWriter(socket.getOutputStream()) // 텍스트 한글자씩 내보내기
            //3. bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            //한번에 내보내기...
            bufferedWriter = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream())
            );
            bufferedReader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            while (true) {
                String outputMsg = scanner.nextLine();
                bufferedWriter.write(outputMsg + "\n"); // 줄바꿈 표시
                bufferedWriter.flush();// buffer가 차지 않아서 안나갈 경우 한번에 남아 있는거 보내기
                String inputMsg = bufferedReader.readLine();
                System.out.println("socket에서 보낸 메세지 : "+inputMsg);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

