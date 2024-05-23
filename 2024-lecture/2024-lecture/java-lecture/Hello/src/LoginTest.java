import java.util.Scanner;

public class LoginTest {
    public static void main(String[] args) {
        // String id = "jhta";
        // String pw = "1234";

        // String Constant pool
        // new String heap 영역에 저장됨
        // 저장되는 곳이 다르다! => 동명이인 이지만 사는곳이 다른

        // 스트링 비교할때 == 메모리에 주소 비교
        // equals는 내용 비교


//        String objId = new String("jhta");
//        System.out.println(id=="jhta");
//        System.out.println(id==objId);
//        System.out.println(id.equals(objId));
        System.out.println("아이디 비번을 입력하세요");
        // String 비교할 때 == 은 주소 비교
        // equals(스트링)은 값을 비교함 (주소가 달라도 된다)
        Scanner sc = new Scanner(System.in);

        String id = sc.nextLine();
        String password = sc.nextLine();
        //System.out.println("id==%s, pw==%s",id,password);

        if ((id == "jhta") && (password == "1234")) {
            System.out.println("로그인됨");
        } else {
            System.out.println("아이디비번 확인");
        }

        if ((id.equals("jhta")) && (password.equals("1234"))) {
            System.out.println("로그인됨");
        } else {
            System.out.println("아이디비번 확인");
        }

    }
}
