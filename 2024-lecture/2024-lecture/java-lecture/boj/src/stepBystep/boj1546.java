package stepBystep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        double[] arr = new double[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            double num = Double.parseDouble(st.nextToken());
            arr[i] = num;
        }

        double sum = 0;
        Arrays.sort(arr);

        for (int i=0; i<N; i++) {
            sum += ((arr[i] / arr[N-1]) * 100);
        }
        System.out.println(sum/N);

    }
}
