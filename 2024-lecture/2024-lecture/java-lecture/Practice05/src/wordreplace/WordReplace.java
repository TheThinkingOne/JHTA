package wordreplace;

import java.util.Scanner;

public class WordReplace {
    public static void main(String[] args) {
        System.out.println(">>");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuffer sb = new StringBuffer(str);
        while (true) {
            System.out.println("명령 : ");
            String command = sc.nextLine();
            if(command.equals("그만")) {
                System.out.println("프로그램 종료");
                break;
            }
            // we! 우리는 일때
            String word[] = command.split("!");
            int start = sb.indexOf(word[0]);
            sb.replace(start,start+word[0].length(),word[1]);
            System.out.println(sb.toString());
        }
    }
}
