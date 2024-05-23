import java.util.Scanner;

public class sol5 {
    public static void main(String[] args) {
        int arr[] = new int[10];
        Scanner sc = new Scanner(System.in);

        System.out.println("양의 정수 10개 입력");
        for (int i=0; i<10; i++) {
            int num = sc.nextInt();
            arr[i] = num;
        }
        for (int i=0; i<arr.length; i++) {
            if (arr[i] % 3 == 0) {
                System.out.println(arr[i]);
            }
        }
    }
}
