package sol10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Sol10 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        File file = new File("C:\\Users\\jhta\\Desktop\\2024-lecture\\2024-lecture\\2024-lecture\\java-lecture\\practice07\\src\\sol10\\phone.txt");
        try {
            Scanner phoneBook = new Scanner(file);
            while(phoneBook.hasNext()) { // 다음것이 있으면, 공백 무시함
                //System.out.println(phoneBook.nextLine());
                String name = phoneBook.next();
                String phoneNum = phoneBook.next();
                map.put(name,phoneNum);
            }
            phoneBook.close();
            System.out.println("총 " + map.size() + "개의 전화번호가 있습니다.");
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.print("찾을 이름을 입력 >> ");
                String searchName = sc.next();
                if(searchName.equals("그만")) {
                    System.out.println("프로그램 종료");
                    break;
                }
                if(map.get(searchName)==null) System.out.println("등록되지 않은 이름입니다.");
                else {
                    String tel = map.get(searchName); // searchName 이라는 키 값을 넣어서 전화번호 라는 벨류를 출력
                    System.out.println(tel);
                    // map은 동명이인 동시 검색이 안된다
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
