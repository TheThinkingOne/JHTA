import java.util.Scanner;

public class prac3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("금액을 입력하세요>>");
        int money = sc.nextInt();

        System.out.println("오만원권: " + money/50000);
        money -= 50000 * (money/50000); // money %= 50000;
        System.out.println("만원권: " + money/10000);
        money -= 10000 * (money/10000);
        System.out.println("오천원권: " + money/5000);
        money -= 5000 * (money/5000);
        System.out.println("천원권: " + money/1000);
        money -= 1000 * (money/1000);
        System.out.println("오백원권: " + money/500);
        money -= 500 * (money/500);
        System.out.println("백원권: " + money/100);
        money -= 100 * (money/100);
        System.out.println("오십원권: " + money/50);
        money -= 50 * (money/50);
        System.out.println("십원권: " + money/10);

    }
}
