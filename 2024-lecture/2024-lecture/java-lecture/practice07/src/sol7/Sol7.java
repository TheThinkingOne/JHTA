package sol7;

import java.io.*;

public class Sol7 {
    public static void main(String[] args) {

        File file = new File("C:\\Users\\jhta\\Desktop\\2024-lecture\\2024-lecture\\2024-lecture\\java-lecture\\practice07\\src\\sol7\\newEmmaScreen.png");
        File copyFile = new File("C:\\Users\\jhta\\Desktop\\2024-lecture\\2024-lecture\\2024-lecture\\java-lecture\\practice07\\src\\sol7\\copiedEmmaScreen.png");
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {

            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(copyFile);
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            System.out.println("원본 파일의 크기=="+file.length());
            long percent = file.length() / 10; // 20000 2000/2000/2000
            byte buffer[] = new byte[2];
            long process = 0;
            int count = 0;
            int num = 1;

            while (true) {
                count = fileInputStream.read(buffer,0, buffer.length);
                if(count==-1) break;
                if(count>0) {
                    fileOutputStream.write(buffer,0, buffer.length);
                }
                process+=count; //
                if(process>percent*num) {
                    num++;
                    System.out.print("*");
                }
            }

            bufferedInputStream.close();
            bufferedOutputStream.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
