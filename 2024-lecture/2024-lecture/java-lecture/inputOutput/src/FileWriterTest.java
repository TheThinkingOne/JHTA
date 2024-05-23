import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            FileWriter fileWriter = new FileWriter("C:\\Users\\jhta\\Desktop\\sample03.txt");
            while (true) {
                String line = sc.nextLine();
                if (line.length() == 0) break; // 엔터 두번치면 프로그램 종료
                fileWriter.write(line,0,line.length());
                fileWriter.write("\r\n",0,2);
            }
            // fileWriter.write("날자꾸나 완벽한 날개야 \r\n");
            // fileWriter.write("내가 어떤 사람이 될 수 있는지 보여주자");
            // 간단한 텍스트 db 생성
            fileWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
