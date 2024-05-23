import java.util.Scanner;

public class boj1213 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int[] alpCount = new int[26];

        // 각 대문자 알파벳의 등장 횟수 카운트
        for (int i=0; i< str.length(); i++) {
            char c = str.charAt(i);
            alpCount[c - 'A']++; // 각 알파벳 등장횟수 만큼 ++
        }
        // 유니코드

        int oddAlp = 0;
        for (int i=0; i<26; i++) {
            if (alpCount[i] % 2 != 0) {
                oddAlp++;
            }
        }

        if (oddAlp > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder palindrome = new StringBuilder();
        char oddChar = '\0';

        for (int i=0; i<26; i++) {
            char c = (char) ('A' + i); // ex) A + 1 = B (유니코드상)
            if (alpCount[i] % 2 == 1) oddChar = c; // ABACABA 예제일때 alpCount : [4, 2, 1, 0, 0, .....]
            // 홀수번 등장하는 알파뱃일 경우 oddChar에 임시 저장

            for (int j=0; j < alpCount[i]/2; j++) {
                palindrome.append(c); // 등장횟수의 절반만큼 문자 추가 (절반만 봐도 되므로)
            }
        }

        StringBuilder result = new StringBuilder(palindrome);
        if (oddChar != '\0') {
            result.append(oddChar); // 홀수 번 등장하는 문자를 중간에 추가하기
        }
        result.append(palindrome.reverse()); // 팰린드롬 앞부분 데칼코마니(중간빼고)

        System.out.println(result);

    }
}
