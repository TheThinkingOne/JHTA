package sol3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Sol2and3 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\jhta\\Desktop\\2024-lecture\\2024-lecture\\2024-lecture\\java-lecture\\practice07\\src\\sol1\\copyText.txt");
        try {
            FileReader fileReader = new FileReader(file);
            Scanner sc = new Scanner(fileReader);
            while (sc.hasNext()) {
                String line = sc.nextLine();
                System.out.println(line);
            }
            fileReader.close();
            sc.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
