import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    private GamePanel gamePanel;
    public Game() throws HeadlessException {
        this.setTitle("벽돌깨기");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gamePanel = new GamePanel();
        this.setContentPane(gamePanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
    }

    public static void main(String[] args) {
        new Game();
    }
}
