import java.io.*;

public class FileReaderHangul {
    // Reader / Writer는 문자 데이터를 읽고 쓰겠다는 뜻
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null; // 보조 스트림
        // 매개변수로 스트림을 받아서 처리할 수 있음
        // 보조 스트림 (fileInputStream)
        // FileReader fileReader = new FileReader("C:\\Users\\jhta\\Desktop\\wing2.txt"); => UTF-8 읽기
        try {
            // ANSI 는 거의 안쓰지만 옛날문서 중에 ANSI로 저장되어 있는 경우 이렇게 해줘야 함
            fileInputStream = new FileInputStream("C:\\Users\\jhta\\Desktop\\wing2.txt");
            inputStreamReader = new InputStreamReader(fileInputStream,"MS949");
            int c;
            while ((c = inputStreamReader.read())!=-1) {

                //System.out.print((char)c);
            }
            inputStreamReader.close();
            fileInputStream.close();
            // 닫을땐 역순으로 닫는게 좋다. 국룰임.

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
