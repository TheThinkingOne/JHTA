public class Point {
    private int x,y;
    public void set(int x, int y) {
        this.x = x; this.y = y;
    }
    public void show() {
        System.out.printf("x,y 좌표는 %d,%d",x,y);
    }
}
