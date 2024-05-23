import java.util.Scanner;

public class Sol1 extends Thread {
    Scanner sc = new Scanner(System.in);
    int i=1;
    @Override
    public void run() {
        while (i<11) {
            System.out.print(i + " ");
            i++;
        }
    }

    public static void main(String[] args) {
        Sol1 sol1 = new Sol1();
        sol1.start();
    }
}
