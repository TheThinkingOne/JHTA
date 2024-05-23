package stepBystep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ArrayList<Integer> arrayList = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int count = 0;
        int temp = 0;

        for (int i=0; i<10; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            arrayList.add(num);
        }

        for (int i=0; i<arrayList.size(); i++) {
            int rest = arrayList.get(i) % 42;
            set.add(rest);

        }
        System.out.print(set.size());

    }
}

