package circle;
public class CircleTest {

    public static boolean equals(Object objA, Object objB) {
        Circle circleA = (Circle) objA;
        Circle circleB = (Circle) objB;
        if (circleA.getX() == circleB.getX() && circleA.getY() == circleB.getY()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Circle circleA = new Circle(2,3,5, "원a");
        Circle circleB = new Circle(2,3,30, "원b");
        circleA.seeCircleInfo();
        circleB.seeCircleInfo();

        if (equals(circleA, circleB)) System.out.println("같은 원");
        else System.out.println("다른 점");

    }
}
