package checkwords;

import java.util.Scanner;
import java.util.StringTokenizer;

public class SplitTest_lecture {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String str = sc.next();
            if(str.equals("그만")) {
                System.out.println("프로그램 종료");
                break;
            }
            StringTokenizer st = new StringTokenizer(str," ");
            System.out.println("단어의 개수는 " + st.countTokens());
            while (st.hasMoreTokens()) System.out.println(st.nextToken());

        }
    }
}
