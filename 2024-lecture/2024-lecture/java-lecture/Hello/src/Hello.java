public class Hello {
    public static void main(String[] args) {
        // 자바는 타입을 가진다. 정해진 타입 외에는 사용 불가
        // 타입 추론이라는게 있는데 나중에 배움 ㅋ
        // 자바의 기본타입은 primitive type
        // reference type (array, object)

        int num = 0x12; // 숫자 앞에 0 붙으면 8진수, 0x를 붙이면 16진수, 0b를 붙이면 2진수
        boolean isTrue = false;
        char ch = 'W'; // char는 글자 한개만 작성 가능
        byte by = -128; // 1 바이트 정수 -128~127
        short sh = -32768; // 2 바이트 정수
        int num2 = 123112312;  // 4 바이트 정수(4^8)
        long longNum = 5745483954567890876L; // 8바이트 정수;
        float fl = 3.14F;
        double dl = 20.1;
        // 정수의 default = int
        // 실수의 default = double

        String str = "java";
        // String은 Object 이지만 기본 타입처럼 사용 가능하다
        // 없다면 의미 null 은 기본 타입에는 사용 불가

        long cardNum = 2134_1234_5776_3032L;
        // long 에는 언더바 사용가능
        double bankMoney = 100_000_000_000_000_000.0;
        int num01 = 10, num02 = 20;
        int num03;
        var num04 = 39; // var는 변수 선언만 하는것이 불가능하다

        final double PI = 3.14; // final을 붙이면 상속도 안되고 값 변경 불가

        double d01 = 1.9;
        int num05 = (int)d01; // type casting (형변환)
        // 소수점 버리고 형변환됨
        // 작은거는 큰거에 넣을 수 있음
        // 큰걸 작은것에 넣을 때는 형변환 필요함
        // 들어갈 수 있는 거까지 집어넣고 나머진 자른다

        System.out.println("num05" + " = " + num05);
        System.out.println(10/4);
        System.out.println(1.9+3.2);

    }
}
