package nation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class NationTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<NationInfo> nationInfoList = new ArrayList<>();
        System.out.println("나라 이름과 인구를 입력하세요 >> (예 : Korea 5000) ");
        while (true) {
            String nationName = sc.next();
            int personNum = sc.nextInt();
            if (nationName.equals("그만")) {
                break;
            } else {
                nationInfoList.add(new NationInfo(nationName, personNum));
            }
        }
        while (true) {
            System.out.print("인구 검색할 나라명 입력 >>");
            String findNation = sc.next();
            if (findNation.equals("그만")) {
                System.out.println("프로그램 종료");
                break;
            } else {
                for (NationInfo nationInfo : nationInfoList) {
                    if (findNation.equals(nationInfo.nation)) {
                        System.out.println(nationInfo.nation + "의 인구는 " + nationInfo.personNum);
                    }
                }
            }
        }

    }
}
