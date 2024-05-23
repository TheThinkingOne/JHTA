public class DoWhileTest01 {
    public static void main(String[] args) {
//        int i=0;
//        do {
//            System.out.print(i + " ");
//            i++;
//        }
//        while (i<10);
        // a ~ z까지 출력하기(do~while문 이용)
        char alphabet = 'a';
        do {
            System.out.print(alphabet + " ");
            alphabet++;
        }
        while (alphabet<='z');

        char ch = '가';
        int count = 0;
        do {
            System.out.print(ch);
            ch++;
            count++;
        } while (ch <= '힣');
        System.out.println(count);
    }
}
