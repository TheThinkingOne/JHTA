import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class CalcClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bufferedWriter;
        BufferedReader bufferedReader;
        try {

            Socket socket = new Socket("localHost",9988);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (true) {
                String outputMsg = sc.nextLine();
                bufferedWriter.write(outputMsg+"\n");
                bufferedWriter.flush();
                String result = bufferedReader.readLine();
                System.out.println("계산 결과 : " + result);
                // 엔터 침과 동시에 외부로 송출
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
