package RPC;

class Game {
    private int userChoice;
    private int computerChoice;

    public String[] RCP = {"가위","바위","보"};

    public Game(int userChoice, int computerChoice) {
        this.userChoice = userChoice;
        this.computerChoice = computerChoice;
    }

    public void matchResult(int userChoice, int computerChoice) {
        System.out.println("철수" + "(" + RCP[userChoice-1] + ")" + " : " + "컴퓨터" + "(" + RCP[computerChoice-1] + ")");
    }

    public void isUserWin(int userChoice, int computerChoice) {
//        if (userChoice == computerChoice) System.out.println("무승부입니다");
//        else if (userChoice == 1) {
//            if (computerChoice == 2) System.out.println("컴퓨터 승리");
//            else System.out.println("철수 승리");
//        }
        if (userChoice == 1) { // 가위
            if (userChoice == computerChoice) System.out.println("무승부입니다");
            else if (computerChoice == 2) System.out.println("컴퓨터 승리");
            else if (computerChoice == 3) System.out.println("철수 승리");
        } else if (userChoice == 2) { // 바위
            if (userChoice == computerChoice) System.out.println("무승부입니다");
            else if (computerChoice == 3) System.out.println("컴퓨터 승리");
            else if (computerChoice == 1) System.out.println("철수 승리");
        } else if (userChoice == 3) { // 보
            if (userChoice == computerChoice) System.out.println("무승부입니다");
            else if (computerChoice == 1) System.out.println("컴퓨터 승리");
            else if (computerChoice == 2) System.out.println("철수 승리");
        }


    }
}
