package randomgame;

import java.util.Scanner;

public class Game02 {
    private Person playerList[];
    private Scanner scanner = new Scanner(System.in);

    private int numOfPlayer;
    public Game02() {
        System.out.println("게임에 참여할 선수 숫자 입력");
        numOfPlayer = scanner.nextInt();
        scanner.nextLine();
        playerList = new Person[numOfPlayer];
        for(int i=0;i< playerList.length;i++) {
            System.out.println(i+1+"번째 선수 입력");
            String name = scanner.nextLine();
            playerList[i] = new Person(name);
        }
    }
    public void run() {
        //2사람이 번갈아 가면서 출력
        int i=0;
        while(true) {
            if(playerList[i].turn()) {
                System.out.println( playerList[i].getName()+"님이 이겼습니다.");
                break;
            } else {
                System.out.println("안타깝네요.");
                i=++i%playerList.length;
            }
        }
    }
}
