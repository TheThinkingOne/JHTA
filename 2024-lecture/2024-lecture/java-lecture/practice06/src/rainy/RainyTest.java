package rainy;

import java.util.Scanner;
import java.util.Vector;

public class RainyTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vector<Integer> vector = new Vector<>();
        int avg = 0;
        while (true) {
            System.out.print("강수량 입력 (0 입력시 종료) >> ");
            int rain = sc.nextInt();
            if (rain == 0) {
                System.out.println("프로그램 종료");
                break;
            }
            vector.add(rain);
            avg += rain;
            for (int i=0; i<vector.size(); i++) {
                System.out.print(vector.get(i) + " ");
            }
            System.out.println();
            System.out.println("현재 평균: " + avg/vector.size());


        }
    }
}
