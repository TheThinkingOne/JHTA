package scholarship;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Scholarship {
    private String title;
    private Scanner sc = new Scanner(System.in);
    private HashMap<String,Double> scoreMap = new HashMap<>();

    public Scholarship(String title) {
        this.title = title;
    }

    public void read() {
        System.out.println("장학금 드립니다.");
        for (int i=0; i<5; i++) {
            System.out.println("이름과 학점 입력===>");
            String name = sc.next();
            double score = sc.nextDouble();
            scoreMap.put(name,score);
        }
    }

    public void setScholarship() {
        System.out.println("장학생 선발 기준 입력");
        double cutline = sc.nextDouble();

        System.out.println("장학생 명단");

        Set<String> keys = scoreMap.keySet();
        Iterator<String> iterator = keys.iterator();

        while (iterator.hasNext()) {
            String name = iterator.next(); // iterator 를 통해 key가 name인 이름 value 뽑기
            double score = scoreMap.get(name);
            if(score>cutline) System.out.println(name);
        }

    }
}
