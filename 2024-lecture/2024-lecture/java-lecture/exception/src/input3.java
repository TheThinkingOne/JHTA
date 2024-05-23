import java.util.InputMismatchException;
import java.util.Scanner;

public class input3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("세 개의 정수 입력");
        int sum = 0, num = 0;
        for (int i=0; i<3; i++) {
            System.out.println(i + 1 + "번째 숫자 입력");
            try {
                num = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("정수를 입력");
                sc.next();
                i--;
                continue;
            }
            sum += num;
        }
        System.out.println(sum);
    }
}
