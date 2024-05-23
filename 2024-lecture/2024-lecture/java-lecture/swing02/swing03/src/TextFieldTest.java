import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;

public class TextFieldTest extends JFrame {
    public TextFieldTest() throws HeadlessException {
        super("삼라만상");

        Container container = this.getContentPane(); // 여기에 컴포넌트 앉히기
        container.setLayout(new FlowLayout());

        JLabel label01 = new JLabel("id");
        JTextField textField01 = new JTextField(20);
        container.add(label01);
        container.add(textField01);

        JLabel label02 = new JLabel("pw");
        JPasswordField textField02 = new JPasswordField(20);
        container.add(label02);
        container.add(textField02);

        JButton login = new JButton("login");
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 보안문제 때문에 리턴 타입을 스트링으로 하지 않는다 보통은
                // gc(garbage collector)가 가져가기 전까지 남아있다.
                char password[] = textField02.getPassword();
                char password02[] = {'1','2','3','4'};
                if (Arrays.equals(password, password02)) {
                    System.out.println("로그인 되었습니다.");
                }


//                String password02 = new String(password); // new String 안에 캐릭터 배열을 넣을 수 있다
//                if (textField01.getText().equals("jjang051") && password02.equals("1234")) {
//                    System.out.println("로그인 되었습니다.");
//                } else {
//                    System.out.println("아이디 혹은 비밀번호가 맞지 않습니다.");
//                }
                // id가 jjang051 pw가 1234 일때 로그인 되게끔 하기
            }
        });
        container.add(login);

        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new TextFieldTest();
    }
}