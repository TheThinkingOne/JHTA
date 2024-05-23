//import java.util.Scanner;
//
//public class DivideZero {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num01, num02;
//        System.out.println("숫자 입력");
//        num01 = sc.nextInt();
//        System.out.println("어떤 수로 나눌지 입력");
//        num02 = sc.nextInt();
//        try {
//            //예외가 발생할 수 있는 실행문
//            System.out.printf("%d를 %d로 나누면 %d 입니다.", num01,num02,num01/num02);
//            break;
//
//        } catch (Exception e) {
//            //예외를 어떻게 처리할거냐
//            System.out.println("0으로 나눌 수 없습니다.");
//
//        } finally {
//            //예외발생 여부와 상관없이 무조건 실행해야 하는 문장
//        }
//    }
//}
