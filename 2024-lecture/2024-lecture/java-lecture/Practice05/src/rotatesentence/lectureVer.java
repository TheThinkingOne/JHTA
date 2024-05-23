package rotatesentence;

import java.util.Scanner;

public class lectureVer {
    public static void main(String[] args) {
        System.out.print("문자열을 입력하세요 >> ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        for (int i=0; i<str.length(); i++) {
            // substring 사용
            String first = str.substring(0,1);
            String rest = str.substring(1);
            str = rest + first;
            System.out.println(str);

        }


    }
}
