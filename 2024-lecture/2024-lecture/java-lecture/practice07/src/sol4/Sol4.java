package sol4;

import java.io.*;
import java.util.Scanner;

public class Sol4 {
    // Reader / Writer는 문자 데이터를 읽고 쓰겠다는 뜻
    public static void main(String[] args) {
        Scanner sc;
        // 자바에서 입출력 관련된 것들은 전부 try catch를 해줘야 한다
        try {
            FileReader fileReader = new FileReader("C:\\Windows\\system.ini");
            BufferedReader br = new BufferedReader(fileReader);
            // bufferReader 안에 fileReader 넣기 가능
            // 출력
            String str = null;
            int count = 0;
            String strNum = null;
            // eof (end of file) 에서 -1을 리턴
            while ((str = br.readLine())!= null) {
                strNum = count+1 + ": ";
                strNum = strNum.substring(strNum.length());

                str = str.replace("\t", " ");
                str = strNum + ": " + str;

                System.out.println(str);
            }

        } catch (FileNotFoundException e) {
            //throw new RuntimeException(e);
            System.out.println("정해진 경로에 파일이 없습니다.");
        } catch (IOException e) {
            System.out.println("파일 읽기에 실패하였습니다.");
        }
    }
}
