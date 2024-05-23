package rectangle;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(2, 2, 8, 7);
        Rectangle s = new Rectangle(5, 5, 6, 6);
        Rectangle t = new Rectangle(1, 1, 10, 10);

        System.out.println(r.getX()); // rectangle 클래스에서 getX로 선언 후 r의 x값 반환

        r.show();
        s.show();
        t.show();

        System.out.println("r의 면적은 "+r.square());
        System.out.println("s의 면적은 "+s.square());
        System.out.println("t의 면적은 "+t.square());

        if(t.contains(r)) System.out.println("t는 r을 포함합니다.");
        if(t.contains(s)) System.out.println("t는 s를 포함합니다.");
    }
}
