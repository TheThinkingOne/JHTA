import java.io.*;

public class BinaryBufferTest {
    public static void main(String[] args) {
        File originalEmma = new File("C:\\Users\\jhta\\Desktop\\emmaScreen.jfif");
        File copy = new File("C:\\Users\\jhta\\Desktop\\myFolder\\newEmmaScreen.png");
        int c;
        try {
            FileInputStream fileInputStream = new FileInputStream(originalEmma);
            FileOutputStream fileOutputStream = new FileOutputStream(copy);
            byte buffer [] = new byte[1024*10];
            while (true) {
                int num = fileInputStream.read(buffer);
                fileOutputStream.write(buffer,0,num);
                if (num< buffer.length) break;
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
