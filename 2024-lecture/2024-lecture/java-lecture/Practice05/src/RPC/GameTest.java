package RPC;

import java.util.Scanner;

public class GameTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //String[] RCP = {"가위","바위","보"};

        while (true) {
            System.out.print("철수[가위(1), 바위(2), 보(3), 끝내기(4)]>> ");
            int userSelect = sc.nextInt();
            int computerSelect = (int)(Math.random()*3);

            if (userSelect == 4) {
                System.out.println("프로그램 종료");
                break;
            } else {
                Game game = new Game(userSelect, computerSelect);
                game.matchResult(userSelect, computerSelect);
                game.isUserWin(userSelect, computerSelect);
            }
        }
    }
}
