package sol1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Sol1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            FileWriter fileWriter = new FileWriter("C:\\Users\\jhta\\Desktop\\2024-lecture\\2024-lecture\\2024-lecture\\java-lecture\\practice07\\src\\sol1\\copyText.txt");
            while (true) {
                System.out.println("이름과 전하번호 입력 >> ");
                String inputName = sc.nextLine();
                if (inputName.equals("그만")) break;
                fileWriter.write(inputName + "\r\n"); // \r\n : 줄띄우기

            }
            System.out.println("저장되었습니다.");
            sc.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}
