import java.util.Scanner;

public class SwitchTest {
    public static void main(String[] args) {
        // switch
        System.out.println("학점 입력");
        int score = 88;
        switch (score / 10) {
            // case에 쓸 수 있는것들
            // 정수 또는 char, string,
            case 10:
            case 9:
                System.out.println("A");
                break;
            case 8:
                System.out.println("B");
                break;
            case 7:
                System.out.println("C");
                break;
            case 6:
                System.out.println("D");
                break;
            default:
                System.out.println("F");
        }

        System.out.println("커피 주문해라.");
        Scanner sc = new Scanner(System.in);
        String order = sc.next();
        switch (order) {
            case "아이스아메리카노":
                System.out.println("1500원");
                break;
            case "카페라때":
                System.out.println("2000");
                break;
            case "카푸치노":
                System.out.println("2500");
                break;
            default:
                System.out.println("사냥을 시작하지.");
                break;
        }
    }
}
