import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

// socket이 전송한 데이터를 실시간으로 서버에 전달하고 서버가 데이터 받아서
// 나머지 애들에게 싹 다 보내주기

public class MultiChatServer {
    // 여러 소켓이 접속할 경우 담아두는 공간
    List<ServerWorker> socketList = new ArrayList<>();
    ServerSocket listener;

    class ServerWorker implements Runnable {
        BufferedReader br;
        BufferedWriter bw;

        Socket socket;
        public ServerWorker(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Reader Writer 가 붙어있는 것들은 텍스트 주고 받는 보조 스트림
            // 클라이언트에 이름 부여
            try {

                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                String userName = br.readLine();
                broadCasting(userName + "님이 접속했습니다. \n ");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            while (true) {
                try {
                    String inputMsg = br.readLine();
                    // 읽고나서 바로 모든 연결된 socket 들에게 송출해줌
                    broadCasting(inputMsg);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                // 넘어 들어온 데이터를 읽어서 나머지에게 실시간 전송해주는 코드 작성
            }
        }
    }
    public MultiChatServer() {
        try {
            listener = new ServerSocket(9977); // 서버소켓은 무조건 예외처리 해야함
            while (true) {
                Socket socket = listener.accept();
                ServerWorker serverWorker = new ServerWorker(socket);
                socketList.add(serverWorker);
                Thread thread = new Thread(serverWorker);
                thread.start();
                // 실시간 데이터 주고 받기 가능해짐...
            }
            //socket = listener.accept();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void broadCasting(String msg) {
        // 데이터 송출
        for (int i=0; i<socketList.size(); i++) {
            ServerWorker serverWorker = socketList.get(i);
            try {
                serverWorker.bw.write(msg+"\n");
                serverWorker.bw.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        // 몇명 들어와 있는지 dashboard 관리자가

    }

    public static void main(String[] args) {
        new MultiChatServer();
    }

}
