import java.util.Scanner;

public class ContinueTest {
    public static void main(String[] args) {
//        for (int i=0; i<10; i++) {
//            if (i==5) {
//                continue; // 건너뛰기
//                // break; // 빠져 나가기
//            } else {
//                System.out.println(i);
//            }
//        }
        // 숫자 5개를 입력받아서 양수의 합만 구하기

        Scanner sc = new Scanner(System.in);
        int count = 0;
        int sum = 0;

        for (int i=0; i<5; i++) {
            int num = sc.nextInt();
            if (num < 0) {
                continue;
            }
            else {
                sum += num;
            }
        }

        System.out.println(sum);
    }


}
