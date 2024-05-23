public class AssignmentOperator {
    public static void main(String[] args) {
        int a = 3, b = 3, c = 3, d= 6;
        a += 3;
        b *= 3;
        c %= 2;
        System.out.println(a);
        a++;
        System.out.println(a);
        a = d++;
        System.out.println(a);
        a = ++d;
        System.out.println(a);

    }
}
