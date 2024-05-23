import java.util.Scanner;

public class ThreeTest {
    public static void main(String[] args) {
        //입력받은 숫자가 3의 배수인지 출력
        Scanner sc = new Scanner(System.in);

//        int num = sc.nextInt();
//
//        if (num % 3 == 0) {
//            System.out.println("3의 배수입니다.");
//        } else {
//            System.out.println("아닌데 ㅋ");
//        }
//
//        // 학점매기기
//        float score = sc.nextFloat();
//        if (score >= 4.5) System.out.println("A+");
//        else if (score >= 4.0) System.out.println("A");
//        else if (score >= 3.5) System.out.println("B+");
//        else if (score >= 3.0) System.out.println("B");
//        else if (score >= 2.5) System.out.println("C+");
//        else if (score >= 2.0) System.out.println("C");
//        else System.out.println("더 울어라 젊은 인생아");
//
//        // 점수와 학년을 입력받아 60이상이면 합격
//        // 4학년 일때는 70 이상이어야 합격

        int score2 = sc.nextInt();
        int grade = sc.nextInt();

        if (grade == 4) {
            if (score2 >= 70) {
                System.out.println("합격");
            }
        } else if (grade != 4) {
            if (score2 >= 60) {
                System.out.println("합격");
            } else System.out.println("불합격");
        }


    }
}
