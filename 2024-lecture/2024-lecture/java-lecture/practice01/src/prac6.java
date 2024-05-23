import java.util.Scanner;

public class prac6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1에서 99까지의 정수값 입력 >>");

        int num = sc.nextInt();

        if (1<=num && num<=99) {
            if (num>=10) {
                if ((num/10)%3 == 0) {
                    num %= 10;
                    if (num%3 == 0) {
                        System.out.println("박수짝짝");
                    } else {
                        System.out.println("박수짝");
                    }
                } else {
                    num %= 10;
                    if (num%3==0) {
                        System.out.println("박수짝");
                    } else {
                        System.out.println("...");
                    }
                }
            }

            else if (num < 10) {
                if (num%3 == 0) {
                    System.out.println("박수짝");
                } else {
                    System.out.println("...");
                }
            }
        }
        else {
            System.out.println("1에서 99까지의 숫자만 입력하세요.");

        }
    }


}

