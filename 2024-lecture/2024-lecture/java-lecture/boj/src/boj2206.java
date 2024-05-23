import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj2206 {

    static class Point {
        int y;
        int x;
        int count;
        boolean destoryed;

        Point(int y, int x, int count, boolean d) {
            this.y = y;
            this.x = x;
            this.count = count;
            this.destoryed = d;
        }
    }

    static int N, M;
    static int[][] myMap;
    static boolean[][][] visited;
    static int[] countList;

    public static boolean isSafe(int y, int x) { // 맵 범위 내에서만 이동
        return y >= 0 && y < N && x >= 0 && x < M;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        myMap = new int[N][M];
        visited = new boolean[N][M][2];
        // countList = new int[N * M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                myMap[i][j] = line.charAt(j) - '0';
            }
        }

        bfs();

    }

    public static void bfs() {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0, 0, 1, false));

        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int cy = current.y;
            int cx = current.x;

            // boolean isBreakAble = current.isBreakAble;

            if (cy == N - 1 && cx == M - 1) {
                System.out.println(current.count);
                return;
            }

            for (int dir = 0; dir < 4; dir++) {
                int newY = cy + dy[dir];
                int newX = cx + dx[dir];

                int currentCount = current.count + 1;

                if (isSafe(newY, newX)) {
                    if (myMap[newY][newX] == 0) { // 벽이 아니면
                        if(!current.destoryed && !visited[newY][newX][0]) { // 벽을 부순적이 없는 경우
                            queue.add(new Point(newY, newX, currentCount, false));
                            visited[newY][newX][0] = true;
                        } else if (current.destoryed && !visited[newY][newX][1]) { // 부순적이 있는 경우
                            queue.add(new Point(newY, newX, currentCount, true));
                            visited[newY][newX][1] = true;

                        }
                    }

                    else if (myMap[newY][newX] == 1) { // 벽이면
                        if (!current.destoryed) { // 부순적이 없으면
                            queue.add(new Point(newY,newX,currentCount,true));
                            visited[newY][newX][1] = true;
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }


}
