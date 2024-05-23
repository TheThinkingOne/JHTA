import java.util.Scanner;

public class prac1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("달러 환전금 입력");
        int won = sc.nextInt();
        double dollar = won/1300.0;

        System.out.println(won + "원은" + "$" + dollar + "입니다.");
    }
}
