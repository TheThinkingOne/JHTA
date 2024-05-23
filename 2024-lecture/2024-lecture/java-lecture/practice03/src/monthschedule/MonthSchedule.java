package monthschedule;

import java.util.Scanner;

public class MonthSchedule {

    private Day dayList[]; // Day class, dayList 는 클래스 내의 전역변수

    private Scanner sc = null;

    MonthSchedule(int num) { // 생성자 만듦
        sc = new Scanner(System.in);
        dayList = new Day[num]; // 중괄호 안에 변수를 만들면 지역변수가 된다. (다른곳에서 사용 불가)

        for (int i=0; i<num; i++) {
            dayList[i] = new Day();
        }
    }

    public void input() {
        System.out.println("날짜를 입력하세요.(1~30)");
        int day = sc.nextInt();
        day--; // 배열은 0부터 시작이므로
        System.out.println("할일을 입력합니다. 엔터키는 동작 안합니다.");
        String work = sc.next();
        dayList[day].set(work);
        // 예를들어 22일 이터널리턴 하면 dayList 안에 dayList[21] = 이터널리턴
    };

    public void view() {
        System.out.println("해야할 일을 보여줍니다. 날짜를 입력하세여");
        int day = sc.nextInt();
        day--; // 배열은 0부터 시작이므로
        System.out.println(day + "의 할 일은  ");
        dayList[day].show();
    }

    public void finish() {
        System.out.println("프로그램을 종료합니다.");
    }

    public void run() {

        while (true) {
            System.out.println("todo list (입력 : 1, 보기 : 2, 종료 : 3");
            int menu = sc.nextInt();

            if (menu == 1) input();
            else if (menu == 2) view();
            else {
                finish();
                break;
            };

        }
    }

}
