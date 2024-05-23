package stepBystep;

import java.util.ArrayList;
import java.util.Scanner;

public class boj10798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] myMap = new String[5][15];

        for (int i=0; i<5; i++) {
            String line = sc.next();
            for (int j=0; j<line.length(); j++) {
                myMap[i][j] = String.valueOf(line.charAt(j));
            }
        }

        for (int i=0; i<15; i++) {
            for (int j=0; j<5; j++) {
                if(myMap[j][i]!=null) System.out.print(myMap[j][i]);
            }
        }

    }
}
