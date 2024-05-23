package stepBystep;

import java.util.Scanner;

public class boj10988 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        sc.close();
        char[] charArray = str.toCharArray();

        int length = str.length();
        int answer = 1;

        for (int i=0; i<length/2; i++) {
            if (str.charAt(i) != str.charAt(length-1-i)) {
                answer = 0;
            }
        }

        // 입력값이 level 일 경우
        // i=0 -> l != l ? true ( charAt(0) != charAt(4) ? )
        // i=1 -> e != e ? true ( charAt(1) != charAt(3) ? )

        System.out.println(answer);

    }
}
