import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class RunGame extends JFrame {
    private Container c;
    MapSize size = new MapSize();
    GameMethod gm = new GameMethod();

    public RunGame(String title) {
        this.setTitle(title);
        this.createMenu();
        this.setBounds(200, 20, 650, 800);
        this.c = this.getContentPane();
        this.c.setLayout((LayoutManager)null);

        this.setLayout(new BorderLayout());
        // 타이머 패널 추가
        TimerPanel timerPanel = new TimerPanel();
        this.add(timerPanel, BorderLayout.SOUTH);
        this.setVisible(true);

        ShowMap m = new ShowMap(this.size, this.gm);
        this.setContentPane(m);
        MouseAction Mc = new MouseAction(this.gm, this.size, m, this);
        this.addMouseListener(Mc);
        this.setVisible(true);
        this.setDefaultCloseOperation(3);
    }

    public void createMenu() {
        JMenuBar mb = new JMenuBar();
        JMenuItem[] menuItem = new JMenuItem[2];
        String[] itemTitle = new String[]{"2인", "3인"};
        JMenu screenMenu = new JMenu("게임모드선택");
        MenuActionListener listener = new MenuActionListener();

        for(int i = 0; i < menuItem.length; ++i) {
            menuItem[i] = new JMenuItem(itemTitle[i]);
            menuItem[i].addActionListener(listener);
            screenMenu.add(menuItem[i]);
        }

        mb.add(screenMenu);
        this.setJMenuBar(mb);
    }

    class MenuActionListener implements ActionListener {
        MenuActionListener() {
        }

        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "2인":
                    RunGame.this.gm.setGameMode(2);
                    RunGame.this.gm.init();
                    break;
                case "3인":
                    RunGame.this.gm.setGameMode(3);
                    RunGame.this.gm.init();
            }

        }
    }
}
