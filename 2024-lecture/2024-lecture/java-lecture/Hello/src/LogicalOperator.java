public class LogicalOperator {
    public static void main(String[] args) {

//        System.out.println(3<2);
//        System.out.println(3>2);
//        System.out.println('a' < 'b');
//        System.out.println('a' == 'b');
//        System.out.println(3 != 3);

        // 비교 연산
        System.out.printf("3 > 2 는 %b%n", 3 > 2);
        System.out.printf("3 > 2 는 %b%n", 3 < 2);
        System.out.printf("'a' > 'b' = %b%n", 'a' < 'b');
        System.out.printf("'a' == 'b' = %b%n", 'a' == 'b');
        System.out.printf("'a' == 'A' = %b%n", 'a' == 'A');
        System.out.printf("3 != 2 = %b%n", 3 != 2);
        System.out.printf("3 == 2 = %b%n", 3 == 2);
        System.out.printf("!true = %b%n", !true );
        System.out.printf("!false = %b%n", !false );
        System.out.println((3 > 2) && (3 > 4));
        System.out.println((3 > 2) || (3 > 4));
        System.out.println((3 > 2) ^ (3 > 4));

        //엄친아의 조건
        int height = 180;
        int money = 100000000;
        int iq = 150;

        int myHeight = 183;
        int myMoney = 1000000;
        int myIq = 160;

        System.out.println((myHeight>height) && (myIq>iq) && (myMoney>money));

    }
}
