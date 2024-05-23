import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class boj11478 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        Set<String> stringSet = new HashSet<>();
        int count = 0;

        for (int i=0; i<charArray.length; i++) {
            for (int j=0; j< charArray.length-i; j++) {
                sb.append(charArray[j]);
            }
            stringSet.add(String.valueOf(sb));
            //sb = "";
        }

        System.out.println(stringSet.size());

        // 길이 2일 때 : 0~1, 1~2, 2~3,...
        // 길이 3일 때 : 0~2, 1~3, 2~4, 3~5
        // ...
        // 3중 for문?

    }
}
