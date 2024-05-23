package socre;

import java.util.ArrayList;
import java.util.Scanner;

public class Score {
    public static void main(String[] args) {
        ArrayList<String> scoreList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("6개의 학점을 빈 칸으로 분리 입력(A/B/C/D/E/F) >> ");
        for (int i=0; i<6; i++) {
            String score = sc.next();
            scoreList.add(score);
        }
        double sum = 0;
        for (int i=0; i<scoreList.size(); i++) {
            String score = scoreList.get(i);
            if (score.equals("A")) sum += 4.0;
            else if (score.equals("B")) sum += 3.0;
            else if (score.equals("C")) sum += 2.0;
            else if (score.equals("D")) sum += 1.0;
            else if (score.equals("F")) sum += 0;
        }
        System.out.println(sum/6);

    }
}
