import java.util.Arrays;
import java.util.Scanner;

public class sol8_ver2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1~100 사이의 정수를 입력하세요");
        int num = sc.nextInt();
        int arr[] = new int[num]; // 입력한 정수만큼 배열 생성

        int count = 0;

        for (int i=0; i<num; i++) {
            int random = (int)(Math.random()*100+1);
            int check = random;
            for (int j=0; i<arr.length; j++) {
                if (arr[j] == check) {
                    count += 1;
                }
            }
            if (count == 0) {
                arr[i] = random;
            }


//            for (int j=0; j<=i; j++) {
//                if (arr[j] == arr[i]) {
//                    i--;
//                }
//            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
