import java.util.Arrays;

public class sol7 {
    public static void main(String[] args) {

        int[] arr = new int[10];

        for (int i=0; i<10; i++) {
            int num = (int)(Math.random()*10 + 1);
            arr[i] = num;
        }
        System.out.println(Arrays.toString(arr));
    }
}
