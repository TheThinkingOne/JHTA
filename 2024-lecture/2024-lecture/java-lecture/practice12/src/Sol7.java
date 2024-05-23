//import javax.swing.*;
//import java.awt.*;
//import java.util.ArrayList;
//import java.util.List;
//
////JPanel에 이미지 그리고
////fillOval
//// SnowFlake 객체를 만들어서
//// x, y, radius, speedY를 가지는
//class SnowFlake {
//    private int loadX;
//    private int loadY;
//    private double radius;
//    private int speedY;
//
//    // 데이터 은닉 캡슐화
//
//    public int getLoadX() {
//        return loadX;
//    }
//
//    public void setLoadX(int loadX) {
//        this.loadX = loadX;
//    }
//
//    public int getLoadY() {
//        return loadY;
//    }
//
//    public void setLoadY(int loadY) {
//        this.loadY = loadY;
//    }
//
//    public double getRadius() {
//        return radius;
//    }
//
//    public void setRadius(double radius) {
//        this.radius = radius;
//    }
//
//    public int getSpeedY() {
//        return speedY;
//    }
//
//    public void setSpeedY(int speedY) {
//        this.speedY = speedY;
//    }
//
//    public SnowFlake(int loadX, int loadY, int speedY, int radius) {
//        this.loadX = loadX;
//        this.loadY = loadY;
//        this.speedY = speedY;
//        this.radius = radius;
//    }
//
//}
//
//class SnowPanel extends JPanel implements Runnable {
//    private List<Point> snowList = new ArrayList(); //x,y
//    private ImageIcon bgIcon = new ImageIcon("src/images/피흘남.png");
//    private Image bg = bgIcon.getImage();
//    //배경 그리기
//
//    public SnowPanel() {
//        makeSnow();
//        Thread thread = new Thread(this);
//        thread.start();
//    }
//
//    @Override
//    public void run() {
//        while (true) {
//            //여기다가 눈 내리는 코드
//            for(int i=0;i<snowList.size();i++) {
//                SnowFlake snowFlake = snowList.get(i);
//                //Point point = snowList.get(i);
//                int speedY = (int)(Math.random()*3+1); // 교칙적인 값을 가여
//                snowFlake.y +=speedY;
//
//            }
//            repaint();
//            try {
//                Thread.sleep(20);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//    private void makeSnow() {
//        //System.out.println(this.getWidth());
//        for(int i=0;i<100;i++) {
//            int loadX = (int)(Math.random()*640);
//            int loadY = (int)(Math.random()*440);
//            int radius = (int)(Math.random()*10+5);
//            int speedY = radius/2;
//            SnowFlake snowFlake = new SnowFlake(loadX,loadY,radius,speedY);
//            snowList.add(snowFlake);
//            //g.fillOval(loadX,loadY,radius,radius);
//        }
//    }
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        g.drawImage(bg, 0, 0, this.getWidth(), this.getHeight(), this);
//        g.setColor(Color.WHITE);
//        for(int i=0;i<snowList.size();i++) {
//            SnowFlake snowFlake = snowList.get(i);
//            //System.out.println(point.x+"==="+point.y);
//            g.fillOval(point.x, point.y, 10,10);
//        }
//    }
//}
//
//public class Sol7 extends JFrame {
//    public Sol7() throws HeadlessException {
//        this.setTitle("타이머");
//        this.setSize(640,440);
//        this.setContentPane(new SnowPanel());
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        new Sol7();
//    }
//}