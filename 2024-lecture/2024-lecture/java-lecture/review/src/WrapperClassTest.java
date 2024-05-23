public class WrapperClassTest {
    public static void main(String[] args) {
        String num = "100";
        int num02 = Integer.parseInt(num);
        System.out.println(num+10);
        Integer num03 = Integer.valueOf(10);
        // Wrapper class 는 primitive를 wrapping
        // Wrapper class 는 new 연산자를 사용 안함..
        boolean isTrue = true;
        String isTrue02 = String.valueOf(isTrue);
        boolean isTrue03 = Boolean.parseBoolean("true");

        double d = Double.parseDouble("3.14");
        System.out.println(d);

        //parse~~, toString
        //숫자, 정수, 문자열, boolean
        String str01 = "aaa";
        char chars[] = {'a','b','c'};
        String str02 = new String(chars);
        String str03 = new String("abc");
        String str04 = "aaa";
        System.out.println(str01==str04);
//        System.out.println(System.identityHashCode(str01)+
//                "==="+System.identityHashCode());
        String str05 = "java";
        String str06 = "c++";
        System.out.println(str05.compareTo(str06));
    }
}
