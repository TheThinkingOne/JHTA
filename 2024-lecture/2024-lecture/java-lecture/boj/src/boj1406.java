import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1406 {
    public static void main(String[] args) throws IOException {
        // 백준 1406 에디터
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = br.readLine();
        char[] charArray = str.toCharArray();
        int M = Integer.parseInt(st.nextToken());

        for (int i=0; i<M; i++) {

        }

        System.out.println(charArray);
    }
}
