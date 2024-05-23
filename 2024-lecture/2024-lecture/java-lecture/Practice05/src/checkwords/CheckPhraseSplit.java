package checkwords;

import java.util.Scanner;
import java.util.StringTokenizer;

public class CheckPhraseSplit {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("문장을 입력하세요 >> ");
            String sentence = sc.nextLine();
            if (sentence.equals("그만")) {
                System.out.println("종료합니다");
                break;
            }
            else {
                String splitStr[] = sentence.split(" ");
                int stnLen = splitStr.length;
                System.out.println("어절 개수는 " + stnLen);
            }

        }


    }
}

