import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ChattingClient extends JFrame implements ActionListener {
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;
    Socket socket; // 연결된 소켓
    JTextField sender;
    Receiver receiver;
    class Receiver extends JTextArea implements Runnable {

        @Override
        public void run() {
            String msg = null;
            while (true) {
                try {
                    Thread.sleep(100);
                    msg = bufferedReader.readLine();
                    this.append("server : "+msg+"\n");
                    //this.append("찍혀라 \n");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public ChattingClient() throws HeadlessException {
        this.setTitle("채팅 클라이언트");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        sender = new JTextField();
        receiver = new Receiver();
        receiver.setEditable(false);
        sender.addActionListener(this);
        container.add(new JScrollPane(receiver),BorderLayout.CENTER);
        container.add(sender, BorderLayout.SOUTH);
        this.setSize(400, 300);
        this.setVisible(true);
        try {
            socket = new Socket("localhost",9977);
            receiver.append("서버에 연결 \n");
            bufferedReader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            bufferedWriter = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Thread thread = new Thread(receiver);
        thread.start();
        //실시간으로 뭔가를 할 수 있게 됐음... 즉 client에서 넘어온 데이터를 받아서 처리 가능
    }

    public static void main(String[] args) {
        new ChattingClient();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = sender.getText();
        if(!msg.equals("")) {
            try {
                bufferedWriter.write(msg+"\n");
                bufferedWriter.flush();
                receiver.append("client : "+msg+"\n");

                int posY = receiver.getText().length();  //길이  몇줄인지
                receiver.setCaretPosition(posY);

                sender.setText(null);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }
    }
}

