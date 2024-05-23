import java.util.Scanner;

public class prac4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 3개 입력 >>");
        int num1 = sc.nextInt(), num2 = sc.nextInt(), num3 = sc.nextInt();
        if (num1 <= num2 && num2 <= num3) {
            System.out.println("중간값은 " + num2);
        } else if (num2 <= num1 && num1 <= num3) {
            System.out.println("중간값은 " + num1);
        } else if (num1 <= num3 && num3 <= num2) {
            System.out.println("중간값은 " + num3);
        }
    }
}
