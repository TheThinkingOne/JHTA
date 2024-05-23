public class RunnableTest implements Runnable { // Runnable을 보통 많이 더 사용한다
    @Override
    public void run() {
        int num = 0;
        while (true) {
            num++;

            System.out.println(num);
            try {
                Thread.sleep(1000); // sleep은 static기 때문에 import를 하거나 Thread를 붙여야 함
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableTest());
        thread.start(); // 스레드는 start 해줘야 실행됨
    }
}
