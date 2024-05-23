import java.io.*;
import java.util.Scanner;

public class IOTest {
    public static void main(String[] args) {
        // file 복사, txt 복사, 이미지 복사
        File img = new File("src/images/Emma.webp");
        File copyImg = new File("copyEmma.jpg");
        int c;
        try {
            FileInputStream fileInputStream = new FileInputStream(img);
            FileOutputStream fileOutputStream = new FileOutputStream(copyImg);
            byte buffer[] = new byte[1024];
            while (true) {
                int num = fileInputStream.read(buffer);
                fileOutputStream.write(buffer,0,num);
                if (num<buffer.length) break;
            }
            fileInputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
