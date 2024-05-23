import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Sol3 extends JFrame {
    private String moneys[] = {"오만원","만원","오천원","천원","오백원","백원","오십원","십원"};
    public Sol3() throws HeadlessException {
        super("삼라만상");




        Container container = this.getContentPane(); // 여기에 컴포넌트 앉히기
        container.setLayout(null);

        JLabel titleLabel = new JLabel("금액");
        JTextField moneyTxt = new JTextField("");
        JButton btnCalc = new JButton("계산");

        titleLabel.setSize(50,20);
        titleLabel.setLocation(100,50);
        moneyTxt.setSize(100,30);
        moneyTxt.setLocation(150,50);
        btnCalc.setSize(50,50);
        btnCalc.setLocation(200,80);

        titleLabel.setLocation(170,50);


        container.add(titleLabel);
        container.add(moneyTxt);
        container.add(btnCalc);





        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new Sol3();
    }
}
