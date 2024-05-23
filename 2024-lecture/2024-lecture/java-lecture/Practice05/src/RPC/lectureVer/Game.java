package RPC.lectureVer;

public class Game {
    private final String arr[] = {"가위","바위","보"};
    private Player player;
    private Computer computer;

    public Game() {
        player = new Player("철수");
        computer = new Computer("인공지능");

    }

    public void run() {
        while (true) {
            int playerChoice = player.turn();
            int computerChoice = computer.turn(); // 1,2,3
            if(playerChoice== 4) {
                break;
            }
            if (playerChoice < 1 || playerChoice > 4) {
                System.out.println("잘못 눌렀습니다");
            } else {
                System.out.print(player.getName()+ "(" + arr[playerChoice-1] + ")");
                System.out.println(computer.getName()+ "(" + arr[playerChoice-1] + ")");
                if (playerChoice == 1) { // 가위
                    if (playerChoice == computerChoice) System.out.println("무승부입니다");
                    else if (computerChoice == 2) System.out.println("컴퓨터 승리");
                    else if (computerChoice == 3) System.out.println("철수 승리");
                } else if (playerChoice == 2) { // 바위
                    if (playerChoice == computerChoice) System.out.println("무승부입니다");
                    else if (computerChoice == 3) System.out.println("컴퓨터 승리");
                    else if (computerChoice == 1) System.out.println("철수 승리");
                } else if (playerChoice == 3) { // 보
                    if (playerChoice == computerChoice) System.out.println("무승부입니다");
                    else if (computerChoice == 1) System.out.println("컴퓨터 승리");
                    else if (computerChoice == 2) System.out.println("철수 승리");
                }
            }

        }
    }

    public static void main(String[] args) {
        String arr[] = {"가위","바위","보"};
        Player player = new Player("철수");
        Computer computer = new Computer("인공지능");



    }
}
