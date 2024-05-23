package stepBystep;


import java.util.Scanner;

public class boj1316_ver2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int count = N;

        for (int i = 0; i < N; i++) {
            String word = sc.next();
            boolean[] visited = new boolean[26]; // 알파벳 소문자만 고려

            for (int j = 1; j < word.length(); j++) {
                // 현재 문자와 바로 전 문자가 다르면서 이미 등장한 문자라면
                if (word.charAt(j) != word.charAt(j - 1) && visited[word.charAt(j) - 'a']) {
                    count--;
                    break;
                }
                // 현재 문자를 방문 처리
                visited[word.charAt(j - 1) - 'a'] = true;
            }
        }

        System.out.println(count);
    }
}

