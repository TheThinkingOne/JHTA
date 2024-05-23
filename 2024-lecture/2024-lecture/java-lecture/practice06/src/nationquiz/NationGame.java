package nationquiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class NationGame {

    private List<Nation> nationList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public NationGame() {
        nationList.add(new Nation("미국","워싱턴"));
        nationList.add(new Nation("한국","서울"));
        nationList.add(new Nation("중국","베이징"));
        nationList.add(new Nation("일본","도쿄"));
        nationList.add(new Nation("영국","런던"));
        nationList.add(new Nation("프랑스","파리"));

    }

    private boolean contain(String country) {
        for(int i=0; i<nationList.size(); i++) {
            Nation nation = nationList.get(i);
            if(nation.getCountry().equals(country)) {
                return true;
            }
        }
        return false;
    }

    public void read() {
        int num = nationList.size();
        System.out.println("현재 " + num +"개 나라가 입력되어 있습니다.");
        num++;
        while (true) {
            System.out.println("나라와 수도를 입력하세요 " + (num+1) + "==>>");
            String country = sc.next();
            if(country.equals("그만")) break;
            String capital = sc.next();
            if (contain(country)) {
                System.out.println(country + "는 이미 있는 나라입니다.");
                continue;
            }
            nationList.add(new Nation(country,capital));
        }
    }
    public void quiz() {
        while (true) {
            int random = (int)(Math.random()*nationList.size());
            // 나라이름
            Nation selectedNation = nationList.get(random);
            String question = selectedNation.getCountry();
            String answer = selectedNation.getCapital();
            System.out.println(question+"의 수도는 ");
            String userCapital = sc.next();
            if (userCapital.equals("그만")) break;
            if (userCapital.equals(answer)) System.out.println("정답입니다!");
            else System.out.println("틀렸습니다! " + question + "의 수도는" + answer + " 입니다.");
        }
    }

    public void finish() {
        System.out.println("게임을 종료합니다.");
    }

    public void run() {
        System.out.println("수도 맞추기 게임 시작합니다!!");
        while (true) {
            System.out.println("입력 : 1, 퀴즈 : 2, 종료 : 3");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 : read(); break;
                case 2 : quiz(); break;
                case 3 : finish(); break;
                default:
                    System.out.println("잘못 눌렀습니다.");
            }
        }

    }


}
