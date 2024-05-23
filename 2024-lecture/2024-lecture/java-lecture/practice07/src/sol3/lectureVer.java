package sol3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class lectureVer {
    public static void main(String[] args) {
        File file = new File("C:\\windows\\system.ini");
        int c;
        try {
            FileReader fileReader = new FileReader(file);
            while ((c=fileReader.read())!=-1) {
                char character = (char)c;
                character = Character.toUpperCase(character);
                System.out.print(character);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
