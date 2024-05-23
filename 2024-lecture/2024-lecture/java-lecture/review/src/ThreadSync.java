//공유자원
class ShareBoard {
    //context switching
    private int sum  =0;
    //동기화시키기... 순서를 기다려줌...
    synchronized void add() {
        int num = sum;
        num+=10;
        sum = num;
        System.out.println(Thread.currentThread().getName()+":"+sum);
    }
    public int getSum() {
        return sum;
    }
}

class StudentThread extends Thread {
    private ShareBoard shareBoard;

    public StudentThread(ShareBoard shareBoard, String name) {
        super(name); // 부모 생성자
        this.shareBoard = shareBoard;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++) {
            shareBoard.add();
        }
    }
}
public class ThreadSync {
    public static void main(String[] args) {
        ShareBoard shareBoard = new ShareBoard();
        StudentThread studentThread01 = new StudentThread(shareBoard,"장성호");
        StudentThread studentThread02 = new StudentThread(shareBoard,"장동건");
        studentThread01.start();
        studentThread02.start();

    }
}
