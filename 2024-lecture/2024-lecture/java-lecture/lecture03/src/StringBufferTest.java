import java.util.StringTokenizer;

public class StringBufferTest {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("a");
        System.out.println(stringBuffer);
        System.out.println(stringBuffer.hashCode());
        stringBuffer.append(" pencil")
                    .append(" very noce")
                    .append(" monami")
                    .insert(2,"ballpen")
                    .delete(8,15)
                    .reverse();

        System.out.println(stringBuffer);
        System.out.println(stringBuffer.hashCode());

        StringBuffer stringBuffer2 = new StringBuffer("This");
        stringBuffer2.append(" is pencil");
        System.out.println(stringBuffer2);
        stringBuffer2.insert(7, " my");
        System.out.println(stringBuffer2);
        stringBuffer2.replace(8,10,"your");
        System.out.println(stringBuffer2);
        stringBuffer2.repeat("a",2);

        String query = "name=이기예&addr=서울&age=30";
        StringTokenizer stringTokenizer = new StringTokenizer(query, "&");
        // StringTokenizer 는 특정 문자를 기준으로 문자열을 나눠줌
        for(int i=0; i<stringTokenizer.countTokens(); i++) {
            System.out.println(stringTokenizer.nextToken());
        }
        while (stringTokenizer.hasMoreTokens()) {
            System.out.println(stringTokenizer.nextToken());
        }

        String splitStr[] = query.split("&");
        System.out.println(splitStr[0]);
        System.out.println(splitStr[1]);
        System.out.println(splitStr[2]);
    }
}
