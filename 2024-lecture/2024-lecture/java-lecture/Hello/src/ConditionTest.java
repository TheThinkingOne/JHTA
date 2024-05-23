import java.util.Scanner;

public class ConditionTest {
    public static void main(String[] args) {
        // 조건문
        //System.out.println("나이를 정수로 입력해라. 18세 미만은 입구컷");
        Scanner sc = new Scanner(System.in);
//        int age = sc.nextInt();
//
//        if(false) {
//            System.out.println("이건 때려죽여도 출력되지 않는다");
//        } else if (true) {
//            System.out.println("이건 무조건출력된다");
//        }
//
//        if (age >= 18) {
//            System.out.println("사고치지마라");
//        } else {
//            System.out.println("맘마좀더쳐먹고오라");
//        }

        //아이디비번 입력받아 jhta, 1234면 로그인, 아니면 아이디비번 확인해주세요 출력
        String id = sc.nextLine();
        String password = sc.nextLine();

        if ((id == "jhta") && (password == "1234")) {
            System.out.println("로그인됨");
        } else {
            System.out.println("아이디비번 확인");
        }
    }
}
