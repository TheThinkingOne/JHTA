package grade;

import java.util.Scanner;

public class GradeMain {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        System.out.print("수학, 과학, 영어 순으로 3개의 정수 입력 >> ");
        int math = sc.nextInt();
        int science = sc.nextInt();
        int english = sc.nextInt();
        Grade me = new Grade(math, science, english);
        // private 을 안 하면 외부에서 me.science = 1000 이런식으로 접근하게 될 수 있음
        System.out.println("평균은 "+me.average()); // average()는 평균을 계산하여 리턴
        //Grade 클래스 내에 있는 average 메서드

        sc.close();
    }
}
