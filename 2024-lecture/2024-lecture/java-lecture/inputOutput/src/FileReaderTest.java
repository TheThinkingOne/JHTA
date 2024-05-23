import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
    // Reader / Writer는 문자 데이터를 읽고 쓰겠다는 뜻
    public static void main(String[] args) {
        // 자바에서 입출력 관련된 것들은 전부 try catch를 해줘야 한다

        try {
            FileReader fileReader = new FileReader("C:\\Users\\jhta\\Desktop\\sample.txt");
            // 출력
            int c;
            // eof (end of file) 에서 -1을 리턴
            while ((c = fileReader.read())!=-1) {
                System.out.print((char)c);
            }
        } catch (FileNotFoundException e) {
            //throw new RuntimeException(e);
            System.out.println("정해진 경로에 파일이 없습니다.");
        } catch (IOException e) {
            System.out.println("파일 읽기에 실패하였습니다.");
        }
    }
}
