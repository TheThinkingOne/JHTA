import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2615 {
    static int[] diagonalY = {-1, -1, 1, 1};
    static int[] diagonalX = {-1, 1, -1, 1};
    static int[] UDLR = {-1,1}; // Up Down Left Right
    static boolean[][] visited = new boolean[19][19];
    static int count = 1;
    static int[][] myMap = new int[19][19];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean[][] visited02 = new boolean[19][19];

        int player1 = 0;
        int player2 = 0;

        for (int i=0; i<19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<19; j++) {
                int num = Integer.parseInt(st.nextToken());
                myMap[i][j] = num;
            }
        }

        for (int y=0; y<19; y++) {
            for (int x=0; x<19; x++) {
                if (myMap[y][x] == 1) {
                    int startY = y;
                    int startX = x;
                    player1 = findWay(startY,startX);
                }
                else if (myMap[y][x] == 2) {
                    int startY = y;
                    int startX = x;
                    player2 = findWay(startY,startX);
                }
            }

        }

        if (player1 == 5) {
            System.out.println(1);
        } else if (player2 == 5) {
            System.out.println(2);
        } else {
            System.out.println(0);
        }

    }

    public static boolean isSafe(int y,int x) {
        return 0<y & y<19 & 0<x & x<19;
    }

    public static int findWay(int y, int x) {
        int upDownCount = UpDown(y,x);
        count = 1;
        int leftRightCount = LeftRight(y,x);
        count = 1;
        int diagnoalCount = Diagnoal(y,x);
        return upDownCount + leftRightCount + diagnoalCount;
    }

    public static int UpDown(int y, int x) {
        int playerNum = myMap[y][x];

        if (count == 5) {
            visited = new boolean[19][19];
            return count;
        }

        for (int dir=0; dir<2; dir++) {
            int newY = y + UDLR[dir];
            if (isSafe(newY,x) & !visited[newY][x] & myMap[newY][x] == playerNum) {
                count ++;
                visited[newY][x] = true;
                UpDown(newY,x);
            }
        }
        return -1;
    }

    public static int LeftRight(int y, int x) {
        int playerNum = myMap[y][x];
        if (count == 5) {
            visited = new boolean[19][19];
            return count;
        }

        for (int dir=0; dir<2; dir++) {
            int newX = x + UDLR[dir];
            if (isSafe(y,newX) & !visited[y][newX] & myMap[y][newX] == playerNum) {
                count ++;
                visited[y][newX] = true;
                UpDown(y,newX);
            }
        }
        return -1;
    }

    public static int Diagnoal(int y, int x) {
        int playerNum = myMap[y][x];
        if (count == 5) {
            visited = new boolean[19][19];
            return count;
        }

        for (int dir=0; dir<4; dir++) {
            int newX = x + diagonalX[dir];
            int newY = y + diagonalY[dir];
            if (isSafe(newY,newX) & !visited[newY][newX] & myMap[newY][newX] == playerNum) {
                count ++;
                visited[newY][newX] = true;
                Diagnoal(newY,newX);
            }
        }
        return -1;
    }



//    public static int UP(int y, int x) {
//        int count = 1;
//        while (count < 5) {
//            if (isSafe(y-1, x)) {
//                count += 1;
//                y--;
//            } else {
//                break;
//            }
//        }
//        return count;
//    }
//
//    public static int DOWN(int y, int x) {
//        int count = 1;
//        while (count < 5) {
//            if (isSafe(y-1, x)) {
//                count += 1;
//                y++;
//            } else {
//                break;
//            }
//        }
//        return count;
//    }
//
//    public static int LEFT(int y, int x) {
//        int count = 1;
//        while (count < 5) {
//            if (isSafe(y-1, x)) {
//                count += 1;
//                x--;
//            } else {
//                break;
//            }
//        }
//        return count;
//    }
//
//    public static int RIGHT(int y, int x) {
//        int count = 1;
//        while (count < 5) {
//            if (isSafe(y-1, x)) {
//                count += 1;
//                x++;
//            } else {
//                break;
//            }
//        }
//        return count;
//    }




}
