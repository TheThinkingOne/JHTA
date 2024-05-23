import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import javax.swing.JPanel;

public class ShowMap extends JPanel {
    private MapSize size;
    private GameMethod gm;
    private final int STONE_SIZE = 27;

    public ShowMap(MapSize m, GameMethod gm) {
        this.setBackground(new Color(200, 165, 63));
        this.size = m;
        this.setLayout((LayoutManager)null);
        this.gm = gm;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        this.board(g);
        this.drawStone(g);
    }

    public void board(Graphics g) {
        for(int i = 1; i <= this.size.getSize(); ++i) {
            g.drawLine(this.size.getCell(), i * this.size.getCell(), this.size.getCell() * this.size.getSize(), i * this.size.getCell());
            g.drawLine(i * this.size.getCell(), this.size.getCell(), i * this.size.getCell(), this.size.getCell() * this.size.getSize());
        }

    }

    public void drawStone(Graphics g) {
        for(int y = 0; y < this.size.getSize(); ++y) {
            for(int x = 0; x < this.size.getSize(); ++x) {
                if (this.gm.getMap()[y][x] == 1) {
                    this.drawBlack(g, x, y);
                } else if (this.gm.getMap()[y][x] == 2) {
                    this.drawWhite(g, x, y);
                } else if (this.gm.getMap()[y][x] == 3) {
                    this.drawRed(g, x, y);
                }
            }
        }

    }

    public void drawRed(Graphics g, int x, int y) {
        g.setColor(Color.RED);
        g.fillOval(x * this.size.getCell() + 15, y * this.size.getCell() - 15, 27, 27);
    }

    public void drawBlack(Graphics g, int x, int y) {
        g.setColor(Color.BLACK);
        g.fillOval(x * this.size.getCell() + 15, y * this.size.getCell() - 15, 27, 27);
    }

    public void drawWhite(Graphics g, int x, int y) {
        g.setColor(Color.WHITE);
        g.fillOval(x * this.size.getCell() + 15, y * this.size.getCell() - 15, 27, 27);
    }
}

