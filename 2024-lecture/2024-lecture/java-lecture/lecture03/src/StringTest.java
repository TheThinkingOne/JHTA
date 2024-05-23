public class StringTest {
    public static void main(String[] args) {
        // String 생성
        char charArray[] = {'a','b','c','d'};
        String str01 = "abcd"; // 리터럴 테이블에 생성됨
        String str02 = new String("abcd"); // new 로 하면 힙 메모리 영역에 생성됨
        String str03 = new String(charArray); // new 로 생성하면 겉보기만 같지 다른 값이라고 보면 됨
        String str04 = str02;
        String str05 = "abcd";
        String str06 = new String("abcd"); // 내용은 같지만 생성되는 곳이 다른

        System.out.println(str03); // abcd 가 출력됨

        System.out.println(str01==str02); // false
        System.out.println(str01.equals(str02)); // true
        System.out.println(str04==str02); // true
        System.out.println(str01==str05); // true => 리터럴 테이블에 생성된 것은 같은 것으로 취급함
        System.out.println(str06==str02); // false => 생성되는 위치가 다르므로
        System.out.println(str02.equals(str06));

        // 스트링 객체는 불변객체... immutable
        System.out.println(str02.concat(str04)); // concat : 이어붙이기, 출력결과 abcdabcd
        System.out.println(str02); // 출력결과 abcd, 위에서 건드렸다고 해도 변하지 않은것을 확인 가능

        String test = "abcd";
        System.out.println(test.charAt(2));
        System.out.println(test.concat("efgh"));
        System.out.println(test.toUpperCase());
        System.out.println(test.compareTo("abc")); // 비교
        System.out.println(test.contains("bc")); // 포함
        System.out.println(test.length());
        System.out.println(test.substring(1)); // 글자를 끌어오고 싶을 때 사용
        System.out.println("동해물과 백두산이 마르고 닳도록 하느님이".substring(0,10)+"...");
        System.out.println("               동해물과 백두산이 마르고 닳도록 하느님이".trim().substring(0,10)+"..."); //trim은 중간 공백 제거는 안해줌
        System.out.println("동해물과 백두산이 마르고 닳도록 하느님이".replace("동해","서해"));
        System.out.println("동해물".indexOf("동"));
        System.out.println("동해물".indexOf("서"));

        // 남자인지 여자인지..
        String jumin = "880112-1765432";
        System.out.println(jumin.substring(0,6));
        System.out.println(jumin.substring(7,14));
        String genderNum = jumin.substring(7);
        boolean isMan = genderNum.charAt(0) == '1' || genderNum.charAt(0) == '3';
        if (isMan) System.out.println("남자입니다");
        else System.out.println("여자입니다");

        // isEmpty 비교
        System.out.println("abcd".isEmpty()); // false
        System.out.println("   ".isEmpty()); // false
        System.out.println("   ".trim().isEmpty()); // true
        System.out.println("   ".isBlank()); // true

        // 자바 17 버전부터 사용 가능한 표기법
        String aaa = """
                     <html>
                        <head></head>
                        <body></body>
                     </html>
                     """;
        System.out.println(aaa);

        // String 가변 객체 String 불변(immutable) 객체
        String dd = "ddd";
        System.out.println(dd.hashCode());
        dd = "fff"; // 덧씌워지는 것이 아니고 새로 만들어지는 것임
        System.out.println(dd.hashCode());

        StringBuffer stringBuffer = new StringBuffer("abcd");
        System.out.println("stringBuffer.hashCode()===" + stringBuffer.hashCode());
        stringBuffer.append("efgh");
        System.out.println("stringBuffer.hashCode()append==="+stringBuffer.hashCode());
        System.out.println(stringBuffer);
        String bbb = "abcd";
        System.out.println("bbb===" + bbb.hashCode());
        bbb = bbb.concat("efgh");
        System.out.println("bbb concat===" + bbb.hashCode());





    }
}
