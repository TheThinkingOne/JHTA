package rotatesentence;

import java.util.Scanner;

public class RotateSentence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열을 입력하세요>> ");
        String stn = sc.nextLine();
        StringBuffer sb = new StringBuffer(stn);
        int stnLen = stn.length();


        for (int i=0; i<stnLen; i++) {
            sb.append(stn.charAt(i));
            sb.deleteCharAt(0);
            System.out.println(sb);
        }

        //System.out.println(stnLen);
    }
}
