import java.io.*;

public class TextCopyTest {
    public static void main(String[] args) {
        File original = new File("C:\\Windows\\system.ini");
        File copy = new File("C:\\Users\\jhta\\Desktop\\myFolder\\system.txt");
        int c;
        try {
            FileReader fileReader = new FileReader(original);
            FileWriter fileWriter = new FileWriter(copy);
//            while((c==fileReader.read())!=-1) {
//                fileWriter.write((char)c);
//            }
            while(true) {
                c=fileReader.read();
                if(c==1) break;
                fileWriter.write((char)c);
            }
            fileReader.close();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
