package stepBystep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        char[] charArray = str.toCharArray();
        int count = 0;

        //System.out.println(charArray.length);
        for (int i=0; i< charArray.length-1; i++) {
            char now = charArray[i];
            char next = charArray[i+1];
            if (now == 'l') {
                count += 1;
                if (next == 'j') {
                    continue;
                }
            }
            else if (now == 'c') {
                count += 1;
                if (next =='=' || next == '-') continue;
            }
            else if (now == 'd') {
                count += 1;
                if (next == 'z' && charArray[i+2] == '=') {
                    continue;
                }
                else if (next == '-') continue;
            }
            else if (now == 's') {
                count += 1;
                if (next == '=') continue;
            }
            else if (now == 'z') {
                count += 1;
                if (next == '=') continue;
            }
            else count += 1;
        }
        System.out.println(count);

    }
}
