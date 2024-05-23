package sol8;

import java.io.File;

public class Sol8 {
    // C 폴더 안에서 가장 용량이 큰 파일의 용량 출력하기
    public static void main(String[] args) {
        File file = new File("C:\\");
        File files[] = file.listFiles(); // .listFiles() : 해당 경로에 있는 파일 전부 읽어오기

        long biggestSize = 0;
        File biggestFileName = null;
        for(int i=0; i<files.length; i++) {
            File temp = files[i];
            if (!temp.isFile()) continue; // .isFile() : 대상이 파일이면(폴더가 아니면)
            System.out.println(temp.getName() + " : " + temp.length());
        }

        for(int i=0; i<files.length; i++) {
            File temp = files[i];
            if (!temp.isFile()) continue; // .isFile() : 대상이 파일이면(폴더가 아니면)
            long fileSize = temp.length();
            if (biggestSize<fileSize) {
                biggestSize = fileSize;
                biggestFileName = temp;
            }
        }
        System.out.println("제일 큰 파일의 이름 : " + biggestFileName.getName() + ", 용량: " + biggestSize/1024 + "kb");

    }
}
