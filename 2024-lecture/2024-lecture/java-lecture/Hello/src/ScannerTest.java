import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.next(); // String을 리턴한다. 외부에서 입력한 값을 String 으로 바꿔준다
        int age = sc.nextInt();
        double weight = sc.nextDouble();

        System.out.println("내 이름은 " + name + ". 그것으로 충분하오.");
        System.out.println("우주와 내가 함께한 세월이... " + age + "년 이나 지났구료.");
        System.out.println("이 세상이 짊어지는 나는..." + weight + " 만큼이나 된다하여... 세상이 고생이 많구료.");

        sc.close();

        // 자바는 가비지 컬렉션을 통해 자동으로 쓰지 않는 자원을 수거해 간다
        // 생성자 함수는 여러개 만들 수 있다
        // 이런걸 생성자 오버로드라고 부른다
    }
}
