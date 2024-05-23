import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Array01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        // primitive : 기본타입, reference :
        int arr[] = new int[10];
        int arr02[] = {1,2,3,4,5}; // 여기엔 추가 안됨

        int intArray[] = new int[5];
        intArray[0] = 10;
        int copyArray[] = intArray;

        System.out.println(copyArray[0]);
        System.out.println(intArray);
        System.out.println(copyArray);
        System.out.println(Arrays.toString(arr02));

        ArrayList<Integer> arrayList = new ArrayList<>();

        int fiveArray[] = new int[5];
        int max = 0;
        for (int i=0; i<5; i++) {
            int num = sc.nextInt();
            fiveArray[i] = num;
            if (fiveArray[i] > max) {
                max = arr[i];
            }
        }
        System.out.println();

    }
}
