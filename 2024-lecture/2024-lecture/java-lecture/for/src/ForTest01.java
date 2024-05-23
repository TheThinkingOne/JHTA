public class ForTest01 {
    public static void main(String[] args) {
        int sum = 0;
        for(int i=1; i<=10; i++) {
            sum += i;
            System.out.print(sum + " ");
        }
        System.out.println();
        sum = 0;
        for(int j=0; j<=10; j++) {
            if (j%2 == 1) {
                sum += j;
                System.out.print(sum + " ");
            }
        }
    }
}
