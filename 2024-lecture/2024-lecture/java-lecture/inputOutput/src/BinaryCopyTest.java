import java.io.*;

public class BinaryCopyTest {
    public static void main(String[] args) {
        File originalEmma = new File("C:\\Users\\jhta\\Desktop\\ch15.png");
        File copy = new File("C:\\Users\\jhta\\Desktop\\myFolder\\newEmma2.png");
        int c;
        try {
            FileInputStream fileInputStream = new FileInputStream(originalEmma);
            FileOutputStream fileOutputStream = new FileOutputStream(copy);
            while ((c=fileInputStream.read())!=-1) {
                fileOutputStream.write((byte)c);
                System.out.print((char)c);
            }
            fileInputStream.close();
            fileOutputStream.close();
            // 속도가 느리다. 1픽셀씩 하나씩 읽어오기 때문
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
