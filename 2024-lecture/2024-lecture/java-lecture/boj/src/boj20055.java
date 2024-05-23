import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj20055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> MyMap = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<2*N; i++) {

            int num = Integer.parseInt(st.nextToken());
            MyMap.add(num);
        }

        //MyMap[0] = start, MyMa[N-1] = outpoint




    }
}
