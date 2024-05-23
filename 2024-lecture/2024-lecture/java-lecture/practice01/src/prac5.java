import java.util.Scanner;

public class prac5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("세 변의 길이 입력>>");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();

        if (num1 + num2 > num3 || num1 > num3 + num2 || num2 > num1 + num3) {
            System.out.println("삼격형이 됩니다.");
        } else {
            System.out.println("삼각형이 아닙니다.");
        }
    }
}
