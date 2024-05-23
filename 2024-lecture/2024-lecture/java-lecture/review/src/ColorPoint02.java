public class ColorPoint02 extends Point {
    private String color;

    void setColor(String color) {
        this.color = color;
    }

    public ColorPoint02(int x, int y, String color) {
        super(x,y);
        this.color = color;
        System.out.println("나는 color point");
    }

    void showColorPoint() {
        System.out.print(color);
        this.showPoint();
    }

}
