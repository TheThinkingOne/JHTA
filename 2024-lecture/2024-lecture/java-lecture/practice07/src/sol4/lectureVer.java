package sol4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class lectureVer {
    public static void main(String[] args) {
        File file = new File("C:\\windows\\system.ini");
        try {
            FileReader fileReader = new FileReader(file);
            Scanner sc = new Scanner(fileReader); // 스캐너 안에 fileReader 넣는거 가능
            //System.out.println(sc.nextLine());
            int lineNum = 1;
            while(sc.hasNext()) {  // hasNext : 다음 줄이 있는지 판단
                String line = sc.nextLine(); // 한줄 읽기
                System.out.printf("%04d",lineNum);
                System.out.println(" " + line);
                lineNum += 1;
            }
            sc.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
