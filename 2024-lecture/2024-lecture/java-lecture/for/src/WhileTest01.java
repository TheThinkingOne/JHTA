import java.util.Scanner;

public class WhileTest01 {
    public static void main(String[] args) {

//        int i=0;
//        while(i<10) {
//            System.out.print(i+ " ");
//            i++;
//        }
        // 끝을 예측하기 어려울때 while 문을 사용

        //계속 입력받아서 -1을 입력하면 while 빠져나가기
        int sum = 0;
        int count = 0;
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        while (num != -1) {
            sum += num;
            count++;
            num = sc.nextInt();
        }
        System.out.println((double) sum/count);

        // for while do-while
    }
}
