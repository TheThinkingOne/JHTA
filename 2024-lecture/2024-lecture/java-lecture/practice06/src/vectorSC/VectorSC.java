package vectorSC;

import java.util.Scanner;
import java.util.Vector;

public class VectorSC {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("정수(-1이 입력 될 때 까지)계속 입력");
        while (true) {
            int num = sc.nextInt();
            if (num == -1) {
                break;
            } else {
                vector.add(num);
            }
        }
        int max = 0;
        for (int i=0; i<vector.size(); i++) {
            if (max<vector.get(i)) max = vector.get(i);
        }
        System.out.println("가장 큰 수는: " + max);

    }
}
