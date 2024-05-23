import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

public class MouseAction extends MouseAdapter {
    private GameMethod gm;
    private MapSize m;
    private ShowMap sm;
    private RunGame g;
    private Timer timer;

    public MouseAction(GameMethod gm, MapSize m, ShowMap mm, RunGame g) {
        this.gm = gm;
        this.m = m;
        this.sm = mm;
        this.g = g;
        this.timer = new Timer();
    }

    public void mousePressed(MouseEvent me) {
        // 마우스 클릭이 발생하면 타이머 시작
        startTimer();

        int x = (int)Math.round((double)me.getX() / (double)this.m.getCell()) - 1;
        int y = (int)Math.round((double)me.getY() / (double)this.m.getCell()) - 2;
        if (this.gm.checkInput(y, x)) {
            Word w = new Word(y, x, this.gm.getCun_GamePlayer());
            this.gm.inputWord(w);
            this.gm.nextPlayer(this.gm.getCun_GamePlayer());
            this.sm.repaint();
            if (this.gm.endGame(w)) {
                String ms;
                if (w.getColor() == 1) {
                    ms = "검돌승리!";
                } else if (w.getColor() == 2) {
                    ms = "백돌승리!";
                } else {
                    ms = "적돌승리!";
                }

                this.showWin(ms);
                this.gm.init();
            }

        }
    }

    // 타이머 시작 메서드
    private void startTimer() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // 타임 아웃 시 처리할 로직
                handleTimeout();
            }
        }, 30000); // 30초 후에 타임아웃
    }

    // 타임 아웃 시 처리할 메서드
    private void handleTimeout() {
        // 현재 플레이어가 백돌인 경우 흑돌이 이김
        if (this.gm.getCun_GamePlayer() == 2) {
            showWin("흑돌 시간 초과로 백돌이 승리했습니다.");
        } else {
            // 현재 플레이어가 검돌인 경우 백돌이 이김
            showWin("백돌 시간 초과로 흑돌이 승리했습니다.");
        }
        // 게임 초기화
        this.gm.init();
    }

    public void showWin(String msg) {
        JOptionPane.showMessageDialog(this.g, msg, "", 1);
    }
}

