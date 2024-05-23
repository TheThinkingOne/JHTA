package sol2_readSol1;

import java.io.*;

public class lectureVer {
    public static void main(String[] args) {
        BufferedReader br = null;
        FileReader fileReader = null;
        File file = new File("C:\\Users\\jhta\\Desktop\\2024-lecture\\2024-lecture\\2024-lecture\\java-lecture\\practice07\\src\\sol1\\copyText.txt");
        int c;
        try {
            fileReader = new FileReader(file);
            br = new BufferedReader(fileReader);
            System.out.println("출력");
            System.out.println("-----------------");
            while (true) {
                String line = br.readLine();
                c = fileReader.read();
                if (line==null) break;
                System.out.println(line);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
