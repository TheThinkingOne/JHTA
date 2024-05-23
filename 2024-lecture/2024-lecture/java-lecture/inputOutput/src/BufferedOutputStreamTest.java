import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedOutputStreamTest {
    public static void main(String[] args) {
        FileReader fileReader = null;
        int c;
        try {
            fileReader = new FileReader("C:\\Users\\jhta\\Desktop\\flyMyWings.txt");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(System.out,5);
            while ((c = fileReader.read()) != -1) {
                bufferedOutputStream.write(c);
            }
            bufferedOutputStream.flush(); // 강제로 밀어넣기
            fileReader.close();
            bufferedOutputStream.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
