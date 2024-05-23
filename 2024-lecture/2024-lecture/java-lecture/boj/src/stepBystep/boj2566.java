package stepBystep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int max = -1;
        int cx = 0; int cy = 0;
        //int[][] myMap = new int[9][9];

        for (int i=0; i<9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<9; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num > max) {
                    max = num;
                    cx = i+1; cy = j+1;
                }
            }
        }

        System.out.println(max);
        System.out.print(cx + " ");
        System.out.print(cy);

    }
}
