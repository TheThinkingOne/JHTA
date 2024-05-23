package sol5;

import java.io.*;

public class Sol5 {

    private static boolean compare(FileInputStream text01, FileInputStream text02) {
        // 반복문 돌려서 byte 단위로 비교해서 하나라도 다르면 false 리턴

        byte buffer01[] = new byte[1024];
        byte buffer02[] = new byte[1024]; // 1kb씩 읽음
        int count01; int count02;
        while (true) {
            try {
                count01 = text01.read(buffer01,0,buffer01.length);
                count02 = text02.read(buffer02,0,buffer02.length);
//                for(int i=0; i<count01; i++) {
//                    // System.out.print(buffer01[i] + "|" + buffer02[i] + "|");
//                }
                if (count01 != count02) { // 하나라도 다르면 false 리턴
                    return false;
                }
                if(count01==-1) break;
                for(int i=0; i<count01; i++) {
                    if (buffer01[i]!= buffer02[i]) { // buffer로 읽어온 것의 갯수가 다르면 false 리턴
                        return false;
                    }
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        return true;
    }

    public static void main(String[] args) {
        try { // 파일리더, 스트림, 파일 등등 하나의 트라이캐치 문 안에 넣고 예외처리 가능
            FileInputStream text01 = new FileInputStream("C:\\Users\\jhta\\Desktop\\2024-lecture\\2024-lecture\\2024-lecture\\java-lecture\\practice07\\src\\sol5\\elvis01");
            FileInputStream text02 = new FileInputStream("C:\\Users\\jhta\\Desktop\\2024-lecture\\2024-lecture\\2024-lecture\\java-lecture\\practice07\\src\\sol5\\elvis02");
            if (compare(text01,text02)) {
                System.out.println("같다");
            } else {
                System.out.println("다르다");
            }
            text01.close();
            text02.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
