package sol2_readSol1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Sol2 {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("C:\\Users\\jhta\\Desktop\\2024-lecture\\2024-lecture\\2024-lecture\\java-lecture\\practice07\\src\\sol1\\copyText.txt");
            int c;
            while ((c = fileReader.read())!=-1) {
                System.out.print((char)c);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
