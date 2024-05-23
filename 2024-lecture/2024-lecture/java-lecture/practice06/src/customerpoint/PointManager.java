package customerpoint;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class PointManager {
    // 이름과 포인트
    private Scanner sc = new Scanner(System.in);
    private Map<String,Integer> pointMap = new HashMap<>();
    public void run() {
        System.out.println("포인트 추가 관리 프로그램입니다.");
        while (true) {

            System.out.println("이름과 포인트를 입력하세요--->");
            String name = sc.next();
            if (name.equals("그만")) break;

            int point = sc.nextInt(); // 고객 이름이 같으면 포인트를 누적해야함
            Integer currentPoint = pointMap.get(name);
            if(currentPoint!=null) point += currentPoint;
            pointMap.put(name,point);
            showAll();
        }
    }
    public void showAll() {
        for(Map.Entry<String,Integer> entry: pointMap.entrySet()) {
            String selectedName = entry.getKey();
            Integer selectedPoint = entry.getValue();
            System.out.println("("+selectedName+")"+"("+selectedPoint+")");
        }
    }



}
