public class ColorPoint extends Point {
    private String color;

    void setColor(String color) {
        this.color = color;
    }

    public ColorPoint(int x, int y, String color) {
        super(x,y);
        this.color = color;
        System.out.println("나는 color point");
    }

    void showColorPoint() {
        System.out.print(color);
        this.showPoint();
    }

    public static void main(String[] args) {
        // Upcasting은 부모타입을 상속바등ㄴ 모든 것들을 받을 수 있다.
        // 대신 부모타입의 메서드, 변수만 쓸 수 있음
        // 만약 필요하다면 다시 다운캐스팅 해서 쓸 수 있다.
        // 이때는 반드시 타입을 지정해야 한다.

//        Mamal mamal = new Whale();
//        mamal.breed();
//        Whale whale = (Whale)mamal;  다운캐스팅의 예시
//        whale.swim();

        Point colorPoint = new ColorPoint02(100,100,"RED");
        ColorPoint cp = (ColorPoint)colorPoint;
        cp.showColorPoint();

    }

}
