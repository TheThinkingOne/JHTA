class Board {
    // 칠판을 하나 공유해서 할거임
    private int sum = 0;
    synchronized public void add() { // synchronize 하면 200까지 딱 떨어진다
        // 싱크로 하는 순간 임계영역 설정되서 한번에 하나씩만 들어가게 막힌다.
        // Lock 이 걸림, 다른 스레드 접근 불가
        // synchronize 없으면 스레드가 순서없이 접근하게됨
        int num = sum;
        Thread.yield(); // 스레드 양보
        num += 1;
        sum = num;
        System.out.println(Thread.currentThread().getName()+"=="+sum);
    }
}
// 임계영역

class StudentThread extends Thread {
    private Board board;
    public StudentThread(String name, Board board) {
        super(name);
        this.board  = board;
    }

    @Override
    public void run() {
        for (int i=0; i<100; i++) {
            board.add();
        }
    }
}

public class ThreadSync {
    public static void main(String[] args) {
        Board board = new Board();
        StudentThread studentThread01 = new StudentThread("이기예",board);
        StudentThread studentThread02 = new StudentThread("엠마 하디",board);
        studentThread01.start();
        studentThread02.start();
    }
}
