import java.util.Arrays;
import java.util.Scanner;

public class sol8 {
    public static void main(String[] args) {
        System.out.println("정수 몇 개?");
        Scanner sc = new Scanner(System.in);
        int arrSize = sc.nextInt();

        int[] arr = new int[arrSize];
        for (int i=0; i<arr.length; i++) {
            int num = (int)(Math.random()*100 + 1);
            arr[i] = num;
        }
        System.out.println(Arrays.toString(arr));
    }
}
