package randomgame;

import java.util.Scanner;

public class Game {
    private Person playerList[];

    private Scanner sc = new Scanner(System.in);

    public Game() {
        this(2);
    }

    public Game(int num) {
        playerList = new Person[num];
        for (int i=0; i< playerList.length; i++) {
            System.out.println(i+1 + "번째 선수의 차례");
            String name = sc.nextLine();
            playerList[i] = new Person(name);
        }
    }

    public void run() {
        // 두 사람이 번갈아가면서 출력
        int i=0;
        while (true) {
            if(playerList[i].turn()) {
                System.out.println(playerList[i].getName() + " 님이 이겼습니다.");
                break;
            } else {
                System.out.println("안타깝네요");
                i=++i% playerList.length;
            }
        }
    }
}
