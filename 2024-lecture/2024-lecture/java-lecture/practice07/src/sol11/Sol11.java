package sol11;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sol11 {
    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        File file = new File("C:\\Users\\jhta\\Desktop\\2024-lecture\\2024-lecture\\2024-lecture\\java-lecture\\practice07\\src\\sol11\\word.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            Scanner sc = new Scanner(fileInputStream);
            while (sc.hasNext()) {
                wordList.add(sc.nextLine());
            }
            sc.close();
            Scanner sc02 = new Scanner(System.in);
            boolean isContain = false;
            while (true) {
                System.out.println("찾을 단어를 입력하세요");
                String searchWord = sc02.next();
                if(searchWord.equals("그만")) {
                    System.out.println("프로그램 종료");
                    break;
                }
                for (int i=0; i<wordList.size(); i++) {
                    if(wordList.get(i).startsWith(searchWord)) {
                        System.out.println(wordList.get(i));
                        isContain = true;
                    } else {
                        if(i == wordList.size()-1 && !isContain) { // 찾는 단어가 없을 경우 없음을 한번만 출력하게 함
                            System.out.println("찾는 단어가 없습니다.");
                        }
                    }
                }

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
