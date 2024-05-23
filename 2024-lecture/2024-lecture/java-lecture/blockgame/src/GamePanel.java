import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements Runnable {
    ImageIcon imageIcon = new ImageIcon("src/images/icon_4.png");
    private int Life = 3;
    // 거리 측정하는법 방법 피타고라스 정리
    static final int GAME_WIDTH = 600;
    static final int GAME_HEIGHT = 600;
    private Ball ball;
    private Paddle paddle;
    Thread thread;
    public GamePanel() {
        //사이즈 정확하게 쓸때
        this.setPreferredSize(new Dimension(GAME_WIDTH,GAME_HEIGHT));
        this.setBackground(Color.BLACK);
        ball = new Ball(250,340);
        paddle = new Paddle(300,GAME_HEIGHT-10,100,10);
        thread=new Thread(this);
        thread.start();
        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_LEFT) {
                    paddle.setLeft(true);
                }
                if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
                    paddle.setRight(true);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_LEFT) {
                    paddle.setLeft(false);
                    paddle.setSpeedX(0);
                }
                if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
                    paddle.setRight(false);
                    paddle.setSpeedX(0);
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.
                setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g.setFont(new Font("맑은 고딕",Font.BOLD,24));
        g.setColor(Color.WHITE);
        //g.drawString(Integer.toString("LIFE : " + ball.getLife()),50,50);
//        for (int i=0; i<Life; i++) {
//            g.drawImage()
//        }

        g.setColor(Color.WHITE);
        g.fillOval(ball.getX(),ball.getY(),ball.getRadius(),ball.getRadius());
        g.fillRect(paddle.getX(),paddle.getY(),paddle.getWidth(),paddle.getHeight());
    }
    private void moveBall() {
        ball.setX(ball.getX()+ball.getSpeedX());
        ball.setY(ball.getY()+ball.getSpeedY());

        //전후 좌우 다 움직이게 해보기...
        if(ball.getX() >= GAME_WIDTH - ball.getRadius()) {
            ball.setSpeedX(-5);
        } else if(ball.getX()<=0) {
            ball.setSpeedX(5);
        }
        if(ball.getY() >= GAME_HEIGHT - ball.getRadius()) {
            // 여기서 바닥에 공이 닿으면 게임오버 처리
            // 스레드 죽이고 공이 패들 가운데 붙어있어야 함
            // space 누르면 다시 시작하게...
            ball.setSpeedY(-5);
        } else if(ball.getY()<=0) {
            ball.setSpeedY(5);
        }
        if(hitObject(
                new Rectangle(ball.getX(),ball.getY(),ball.getRadius(),ball.getRadius()),
                new Rectangle(paddle.getX(),paddle.getY(),paddle.getWidth(),paddle.getHeight())
        )){
            //System.out.println("충돌");
            ball.setSpeedY(-5);
        }
    }
    private void movePaddle() {
        paddle.setX(paddle.getX()+paddle.getSpeedX());
        if(paddle.isLeft()) {
            paddle.setSpeedX(-10);
        }
        if(paddle.isRight()) {
            paddle.setSpeedX(10);
        }
        if(paddle.getX()>=GAME_WIDTH - paddle.getWidth()) {
            // 오른쪽 막침
            //System.out.println("오른쪽 막힘");
            paddle.setX(GAME_WIDTH - paddle.getWidth());
        }
        if (paddle.getX()<=0) {
            paddle.setX(0);
        }

    }
    @Override
    public void run() {
        while (true) {

            moveBall();
            movePaddle();


            //오른쪽 벽돌 충돌했을때 왼쪽으로 보내기...
            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private boolean hitObject(Rectangle rect01, Rectangle rect02) {
        return rect01.intersects(rect02); // 교집합
    }
}
