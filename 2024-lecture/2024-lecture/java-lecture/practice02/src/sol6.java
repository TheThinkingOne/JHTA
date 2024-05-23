import java.util.Scanner;

public class sol6 {
    public static void main(String[] args) {
        int []unit = {50000,10000,5000,1000,500,100,50};

        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();

        for (int i=0; i<unit.length; i++) {
            int val = 0;
            val = money/unit[i];
            System.out.print(val + " ");
            money %= unit[i];
        }
    }
}
