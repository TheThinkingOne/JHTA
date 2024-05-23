package stepBystep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj18111_correct {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 세로
        int M = Integer.parseInt(st.nextToken()); // 가로
        int B = Integer.parseInt(st.nextToken()); // 인벤토리 안에 있는 블록 수

        int[][] myMap = new int[N][M];

        int max = 256;
        int min = 0;

        int minCount = 0;
        int maxCount = 0;

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                myMap[i][j] = Integer.parseInt(st.nextToken());
                if(min > myMap[i][j]) min = myMap[i][j];
                if(max < myMap[i][j]) max = myMap[i][j];
            }
        }

        int timeCount = 0;
        int height = 0;
        for (int i=min; i<=max; i++) {
            int count = 0;
            int block = B;
            for (int j=0; j<N; j++) { // 세로
                for (int k=0; k<M; k++) { // 가로
                    if (i < myMap[i][j]) {
                        count += ((myMap[j][k] - i) * 2);
                        block += (myMap[j][k] - i);
                    } else {
                        count += (i - myMap[j][k]);
                        block -= (i - myMap[j][k]);
                    }

                }
            }
            if(block < 0) break;

            if(timeCount >= count) {
                timeCount = count;
                height = i;
            }

        }
        System.out.println(timeCount + " " + height);

//                // arrayList.add(height);
//                if (height > max) {
//                    max = height;
//                }
//                if (height == max) maxCount += 1;
//                if (height < min) {
//                    min = height;
//                }
//            }

    }
}
