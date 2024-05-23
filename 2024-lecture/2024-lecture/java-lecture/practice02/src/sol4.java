import java.util.Scanner;

public class sol4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("알파벳 한글자만 입력");
        String alp = sc.next();

        char ch = alp.charAt(0); // 알파벳으로 리턴
        for(char i=ch; i>='a'; i--) {
            for(char j='a'; j<=i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }

    }
}
