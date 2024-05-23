import java.util.Scanner;

public class OperatorTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("정수를 입력하면 시/분/초로 바꿔줍니다.");

        int time = sc.nextInt();
        int sec = time % 60;
        int min = (time/60) % 60;
        int hour = time/60/60;
        System.out.println(time+"은 " + hour + "시간 " + min + "분 " + sec + "초 입니다.");
        System.out.printf("입력한 숫자 %d는 %d시 %d분 %d초 입니다.", time,hour,min,sec);
        System.out.println();

        sc.close();

        var flNum = Math.floor(10.23423);
        System.out.println(flNum);


    }
}
