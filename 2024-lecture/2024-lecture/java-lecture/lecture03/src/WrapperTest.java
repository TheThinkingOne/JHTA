public class WrapperTest {
    public static void main(String[] args) {
        //int num = "10";
        // int num = Integer.parseInt("10");
        // Boxing => 기본 타입을 wrapper class
        // Unboxing

        // Integer num = Integer.valueOf("10");
        // int num2 = num.intValue();
        int num = Integer.parseInt("10");
        boolean aa = Boolean.parseBoolean("true");
        int num01 = 10;
        Integer num02 = Integer.parseInt("10");
        System.out.println(num01==num02); // Wrapper 클래스는 값만 같으면 true 반환함
        System.out.println(aa);

        char ch01 = '4';
        char ch02 = 'F';

        if(Character.isDigit(ch02)) {
            System.out.println("ch01은 숫자형 char 입니다");
        } else System.out.println("숫자형 char 가 아닙니다");

        if (Character.isAlphabetic(ch02)) System.out.println("ch02는 캐릭터형 char 입니다");
        else System.out.println("캐릭터형이 아닌가봐요");

        String str = "진리는 나의 빛"; // reference 타입인데 기본 타입처럼 사용 가능함
        // String은 wrapper 가 없다

    }
}
