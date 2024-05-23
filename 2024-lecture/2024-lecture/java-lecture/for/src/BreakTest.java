import java.util.Scanner;

public class BreakTest {
    public static void main(String[] args) {
        System.out.println("exit을 쓰면 종료");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(">>>");
            String str = sc.nextLine();
            if (str.equals("exit")) {
                break;
            }
        }
        System.out.println("이제 다른 세상으로...");
    }
}
