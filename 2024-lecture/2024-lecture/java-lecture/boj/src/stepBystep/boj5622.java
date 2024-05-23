package stepBystep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj5622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close();

        char[] charArray = str.toCharArray();
        int count = 0;

        for (int i=0; i<charArray.length; i++) {
            char temp = charArray[i];
            if ('A' <= temp && temp <= 'C' ) count += 3;
            else if ('D' <= temp && temp <= 'F') count += 4;
            else if ('G' <= temp && temp <= 'I') count += 5;
            else if ('J' <= temp && temp <= 'L') count += 6;
            else if ('M' <= temp && temp <= 'O') count += 7;
            else if ('P' <= temp && temp <= 'S') count += 8;
            else if ('T' <= temp && temp <= 'V') count += 9;
            else if ('W' <= temp && temp <= 'Z') count += 10;
        }
        System.out.println(count);

    }
}
