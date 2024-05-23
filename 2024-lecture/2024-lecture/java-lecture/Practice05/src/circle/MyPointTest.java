package circle;

public class MyPointTest extends MyPoint{
    public MyPointTest(int x, int y) {
        super(x, y);
    }

    public static void main(String[] args) {
        MyPoint myPoint = new MyPoint(3,50);
        myPoint.seePoint();
    }
}
