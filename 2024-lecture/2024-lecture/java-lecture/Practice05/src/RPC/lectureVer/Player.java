package RPC.lectureVer;

import java.util.Scanner;

public class Player {
    private String name;
    private Scanner sc = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int turn() {
        System.out.println(name + "[가위(1), 바위(2), 보(3), 끝내기(4)]");
        return sc.nextInt();
    }

}
