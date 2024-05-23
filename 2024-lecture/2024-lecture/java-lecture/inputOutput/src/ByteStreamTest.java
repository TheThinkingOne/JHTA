import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteStreamTest {
    public static void main(String[] args) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\jhta\\Desktop\\fileoutputstreamTest.txt");
            String txt = "\uD83C\uDF85";
            byte bytes[] = txt.getBytes();
            //byte bytes[] = {65,66,67,68,69};
            // 영어는 1바이트, 한글은 3바이트 문자임 (컴퓨터에서)
            System.out.println(Arrays.toString(bytes));
            fileOutputStream.write(bytes);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
