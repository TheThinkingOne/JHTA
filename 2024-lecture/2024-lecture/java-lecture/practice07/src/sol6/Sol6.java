package sol6;

import java.io.*;
import java.util.Scanner;

public class Sol6 {
    private static void writeFile(FileReader fileReader, FileWriter fileWriter) throws IOException {
        char buffer [] = new char[50];
        int count = 0;
        while(true) {
            try {
                count = fileReader.read(buffer,0,buffer.length);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if(count==-1) {
                break;
            }
            if(count>0) {
                fileWriter.write(buffer,0,count);
            }
        }
        fileReader.close();
    }
    public static void main(String[] args) {
        //파일을 읽어서 새로운 파일로 만들기...
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader =
                    new FileReader("C:\\Users\\jhta\\Desktop\\2024-lecture\\2024-lecture\\2024-lecture\\java-lecture\\practice07\\src\\sol6\\lyric01.txt");
            fileWriter =
                    new FileWriter("C:\\Users\\jhta\\Desktop\\2024-lecture\\2024-lecture\\2024-lecture\\java-lecture\\practice07\\src\\sol6\\new.txt");
            writeFile(fileReader,fileWriter);
            fileReader =
                    new FileReader("C:\\Users\\jhta\\Desktop\\2024-lecture\\2024-lecture\\2024-lecture\\java-lecture\\practice07\\src\\sol6\\lyric02.txt");
            writeFile(fileReader,fileWriter);
            fileWriter.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
