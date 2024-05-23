import java.util.Random;

public class MathTest {
    public static void main(String[] args) {
        System.out.println(Math.abs(-9));
        System.out.println(Math.round(1.4));
        System.out.println(Math.round(1.5));
        System.out.println(Math.ceil(123/10));
        // 123 개의 게시물을 10개씩 보여주기
        // 총 13개의 페이지가 필요할 것
        System.out.println(Math.floor(1.9));
        System.out.println(Math.sqrt(9));
        System.out.println(Math.pow(2,10));

        Random random = new Random();
        int ranNum = random.nextInt(45);
        System.out.println(ranNum);
        for (int i=0; i<6; i++) {
            System.out.print(random.nextInt(45)+1+",");
        }
    }
}
