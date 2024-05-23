import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class boj7562 {
    static class Point {
        private int y;
        private int x;
        private int start;
        public Point(int y, int x, int moves) {
            this.y = y;
            this.x = x;
            this.start = moves;
        }
    }
    static Queue<Point> queue;
    static int[] dy = {2, 2, 1, 1, -1, -1, -2, -2};
    static int[] dx = {1, -1, 2, -2, 2, -2, 1, -1};
    static boolean[][] Visited;
    static int N;
    static int mapSize;
//    static int start1;
//    static int start2;
//    static int goal1;
//    static int goal2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            queue = new ArrayDeque<>();
            mapSize = Integer.parseInt(br.readLine());
            Visited = new boolean[mapSize][mapSize];

            st = new StringTokenizer(br.readLine());
            int start1 = Integer.parseInt(st.nextToken());
            int start2 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int goal1 = Integer.parseInt(st.nextToken());
            int goal2 = Integer.parseInt(st.nextToken());

            if (start1 == goal1 && start2 == goal2) System.out.println(0);
            else {
                queue.offer(new Point(start1,start2,0));
                Visited[start1][start2] = true;
                int result = BFS(goal1,goal2);
                System.out.println(result);
            }

        }
    }

    public static int BFS(int goal1, int goal2) {
        while (!queue.isEmpty()) {

            Point current = queue.poll();
            int cy = current.y;
            int cx = current.x;
            int moves = current.start;
            if (cy == goal1 && cx == goal2) {
                return moves;
            }

            for (int dir=0; dir<8; dir++) {
                int newY = cy + dy[dir];
                int newX = cx + dx[dir];
                if (isSafe(newY,newX)) {
                    Visited[newY][newX] = true;
                    queue.offer(new Point(newY,newX,moves+1));
                }
            }
        }
        return -1;
    }

    public static boolean isSafe(int y, int x) {
        return 0<=y && y<mapSize && 0<=x && x<mapSize && !Visited[y][x];
    }


}
