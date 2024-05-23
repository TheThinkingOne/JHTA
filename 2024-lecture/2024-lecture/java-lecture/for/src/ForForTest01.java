public class ForForTest01 {
    public static void main(String[] args) {
        int i=1;
        while (i<=9) {
            System.out.println();
            int j = 1;

            if (i==5) {
                i++;
                continue;
            }

            while (j<=9) {
                System.out.println(j+"x"+i+"="+i*j + " ");
                j++;
            }
            i++;
        }
    }
}
