package stepBystep;

import java.util.Scanner;

public class boj2908 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String num01 = sc.next();
        String num02 = sc.next();
        sc.close();

        char[] charArray01 = num01.toCharArray();
        char[] charArray02 = num02.toCharArray();

        String str01 = "";
        String str02 = "";

        for (int i = charArray01.length-1; i>=0; i--) {
            str01 += charArray01[i];
        }

        for (int i = charArray02.length-1; i>=0; i--) {
            str02 += charArray02[i];
        }

        int changedNum01 = Integer.parseInt(str01);
        int changedNum02 = Integer.parseInt(str02);

        if (changedNum01 >= changedNum02) System.out.println(changedNum01);
        else System.out.println(changedNum02);

    }
}
