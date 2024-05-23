package point;

public class PositivePoint extends Point {
    public PositivePoint(int x, int y) {
        super(x, y);
        if (x<0 || y<0) {
            super.move(0,0);
        }
    }
    @Override
    public void move(int x, int y) { // 재정의
        if(x>=0 && y>=0) super.move(x,y);
        else return;
    }

    public String toString() {
        return "(" + getX() + "," + getY() + ")의 점";
    }

    public static void main(String[] args) {
        PositivePoint pp = new PositivePoint(-10,-10);
        pp.move(-10,10);
        System.out.println(pp.toString());
    }
}
