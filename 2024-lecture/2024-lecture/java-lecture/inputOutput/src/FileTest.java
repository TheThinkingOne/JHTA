import java.io.File;
import java.util.Arrays;

public class FileTest {
    public static void main(String[] args) {
        // 컴퓨터에서 가장 작은 단위 file
        // folder
        // file을 다룰 수 있는 class File
        // file인지 폴더인지 알 수 있고 생성,복사 가능
        File file = new File("C:\\Users\\jhta\\Desktop\\ch15.png");
        System.out.println(file.isFile());
        System.out.println(file.getPath());
        System.out.println(file.getName());
        String filename = file.getName();
        System.out.println(filename);
        String arr[] = filename.split("\\.");
        System.out.println(file.length()+"byte");
        File dir = new File("C:\\Windows");
        File dir02 = new File("C:\\Users\\jhta\\Desktop\\myFolder"); // myFolder 라는 폴더 생성

        System.out.println(dir.isFile());
        File subFiles[] = dir.listFiles();
        System.out.println(dir02.exists());
        if(!dir02.exists()) {
            dir02.mkdir(); // 찾는 폴더가 없을 경우 폴더를 생성(mkdir)ㅇ
        }
        for(int i=0; i<subFiles.length; i++) {
            File file02 = subFiles[i];
            System.out.println(file02.getName());
        }

    }
}
