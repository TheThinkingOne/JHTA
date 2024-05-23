import java.util.Scanner;

public class prac2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        if (num/10 == num%10){
            System.out.println("Yes! 10의 자리와 1의 자리가 같습니다.");
        }
    }
}
