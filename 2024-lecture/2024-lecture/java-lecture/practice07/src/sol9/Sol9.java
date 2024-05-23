package sol9;

import java.io.File;

public class Sol9 {
    public static void main(String[] args) {
        // 해당 경로에 있는 txt 파일만 삭제하는 프로그램
        File dir = new File("C:\\Users\\jhta\\Desktop\\temp");
        File files[] = dir.listFiles();
        int count = 0;
        for (int i=0; i< files.length; i++) {
            File temp = files[i];
            if (!temp.isFile()) continue;
            String fileName = temp.getName();
            int idx = fileName.lastIndexOf("."); // 인덱스가 .인 것을 판단하여 확장자 확인
            //System.out.println(idx);
            String extension = fileName.substring(idx); // 확장자명 뽑기
            if(extension.equals(".txt")) {
                temp.delete(); // 뽑아낸 확장자가 txt 일 경우 해당 파일 삭제
                count++;
            }
            // 또는 이렇게
//            if (fileName.endsWith(".txt")) {
//                temp.delete();
//                count++;
//            }
            //fileName.endsWith(".txt");
        }
        System.out.println(count + "개의 파일을 삭제했습니다.");
    }
}
