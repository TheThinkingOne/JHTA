//package socket;
//
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.OutputStreamWriter;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//class TimerThread extends Thread {
//
//    private BufferedWriter bw;
//    public TimerThread
//
//    @Override
//    public void run() {
//        System.out.println("thread 동작");
//        tr
//    }
//}
//
//public class TimeServer {
//    public static void main(String[] args) {
//        Socket socket;
//        BufferedWriter bw;
//        ServerSocket listener;
//
//        try {
//
//            listener = new ServerSocket(8877);
//            socket = listener.accept(); // 대기중에 있음
//            System.out.println("클라이어늩 연결됨");
//            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//
//            TimerThread timerThread = new TimerThread(bw);
//            timerThread.start();
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
