import java.util.Scanner;

public class sol9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] RCP = {"가위","바위","보"};

        while (true) {
            System.out.print("가위 바위 보! >>");
            String userSelect = sc.next();

            if (userSelect.equals("그만")) {
                System.out.println("게임을 종료합니다..");
                break;
            }

            String computerSelect = RCP[(int)(Math.random()*3)];

            System.out.println("사용자 = " + userSelect + ", 컴퓨터 = " + computerSelect);

            if (userSelect.equals("가위")) {
                if (computerSelect.equals("바위")) System.out.println("컴퓨터 승리");
                else if (userSelect.equals(computerSelect)) System.out.println("무승부!");
                else System.out.println("플레이어 승리");
            }

            else if (userSelect.equals("바위")) {
                if (computerSelect.equals("가위")) System.out.println("플레이어 승리");
                else if (computerSelect.equals("보")) System.out.println("컴퓨터 승리");
                else System.out.println("무승부!");
            }

            else if (userSelect.equals("보")) {
                if (computerSelect.equals("바위")) System.out.println("플레이어 승리");
                else if (computerSelect.equals("가위")) System.out.println("컴퓨터 승리");
                else System.out.println("무승부!");
            }
            System.out.println();
        }
        sc.close();
    }
}

