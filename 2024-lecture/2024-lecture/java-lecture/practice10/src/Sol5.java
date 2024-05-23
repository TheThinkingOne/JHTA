import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sol5 extends JFrame {

    private JSlider sliderList[] = new JSlider[3];

    public Sol5(String title) throws HeadlessException {
        super(title);
        Container container = this.getContentPane(); //여기에 컴퍼넌트 앉히기...
        container.setLayout(new FlowLayout());
        for(int i=0;i<3;i++) {
            sliderList[i] = new JSlider(0,255,255);
            sliderList[i].setPaintTrack(true);
            sliderList[i].setPaintTicks(true);
            sliderList[i].setPaintLabels(true);
            sliderList[i].setMajorTickSpacing(50);
            sliderList[i].setMinorTickSpacing(10);
            container.add(sliderList[i]);
            sliderList[i].addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    int r = sliderList[0].getValue();
                    int g = sliderList[1].getValue();
                    int b = sliderList[2].getValue();
                    container.setBackground(new Color(r,g,b));
                }
            });
        }

//        JSlider rslider = new JSlider(0,255,0);
//        JSlider gslider = new JSlider(0,255,0);
//        JSlider bslider = new JSlider(0,255,0);
        //JSlider slider = new JSlider(100,200,0)
        //JLabel label = new JLabel("150");



//        slider.addChangeListener(new ChangeListener() {
//            @Override
//            public void stateChanged(ChangeEvent e) {
//                label.setText(Integer.toString(slider.getValue()));
//            }
//        });



        //container.add(slider);
        //container.add(label);


        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Sol5("money");
    }
}
