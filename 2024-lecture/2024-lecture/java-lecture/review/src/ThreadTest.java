class TimerThread extends Thread {
    int num = 0;
    @Override
    public void run() {
        //super.run();
        while (true) {
            System.out.println(num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            num++;
        }
    }
}

class TimerThread02 implements  Runnable {
    int num = 0;
    @Override
    public void run() {
        //super.run();
        while (true) {
            System.out.println(num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            num++;
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
//        TimerThread timerThread = new TimerThread();
//        timerThread.start();

        Thread thread = new Thread(new TimerThread02());
        thread.start();
    }
}
