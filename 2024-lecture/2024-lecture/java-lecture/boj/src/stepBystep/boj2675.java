package stepBystep;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj2675 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i=0; i<N; i++) {
            int num = sc.nextInt();
            String str = sc.next();

            char[] charArray = str.toCharArray();

            for (int j=0; j<charArray.length; j++) {
                for (int k=0; k<num; k++) {
                    System.out.print(charArray[j]);
                }
            }
            System.out.println();
        }

    }
}
