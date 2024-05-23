package stepBystep;

import java.io.BufferedReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class boj1316 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int count = N;

        for (int i=0; i<N; i++) {
            String str = sc.next();

            char[] charArray = str.toCharArray();
            Set<Character> charSet = new HashSet<>();

            for (int j=0; j<charArray.length; j++) {
                char temp = charArray[j];

                if (charSet.contains(temp)) {
                    count -= 1;
                    break;
                }

                if (j < charArray.length-1) {
                    if (temp == charArray[j+1]) continue;
                    else {
                        charSet.add(temp);
                    }
                }

                else if (j==charArray.length-1) {
                    if (charSet.contains(charArray[j])) {
                        count -= 1;
                        break;
                    }
                }


            }

        }
        System.out.println(count);
    }
}
