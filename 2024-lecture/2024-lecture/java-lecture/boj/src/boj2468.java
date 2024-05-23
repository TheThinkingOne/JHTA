import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2468 {

    static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static boolean[][] visited;
    static int[][] myMap;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        myMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                myMap[i][j] = num;
            }
        }

        int maxSafe = 1;
        for (int height = 1; height <= 100; height++) {
            maxSafe = Math.max(maxSafe, BFS(height));
        }

        System.out.println(maxSafe);

    }

    public static boolean isSafe(int y, int x) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    public static int BFS(int height) {
        visited = new boolean[N][N];
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (myMap[i][j] > height && !visited[i][j]) {
                    count += 1;
                    visited[i][j] = true;

                    Queue<Point> queue = new LinkedList<>();
                    queue.offer(new Point(i, j));

                    while (!queue.isEmpty()) {
                        Point current = queue.poll();

                        for (int dir = 0; dir < 4; dir++) {
                            int newY = current.y + dy[dir];
                            int newX = current.x + dx[dir];

                            if (isSafe(newY, newX) && myMap[newY][newX] > height && !visited[newY][newX]) {
                                visited[newY][newX] = true;
                                queue.offer(new Point(newY, newX));
                            }
                        }
                    }

                }
            }
        }
        return count;
    }
}

