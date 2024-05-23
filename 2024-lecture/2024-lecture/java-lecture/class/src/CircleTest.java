public class CircleTest extends Circle {
    public static void main(String[] args) {

        Circle BasketBall = new Circle(20, "농구공");
        System.out.println(BasketBall.getArea());

        Circle baseBall = new Circle();
        baseBall.name = "야구공";
        baseBall.radius = 5;
        System.out.println(baseBall.getArea());

        Circle normalBall = new Circle();
        baseBall.name = "반지름 1인 공";
        System.out.println(normalBall.getArea());

        // Rectangle class 정의해보기
        // int width, int height
        // getArea()

        Circle arr[] = new Circle[3];
        String nameList[] = {"농구공","배구공","야구공"};
        for (int i=0; i<3; i++) {
            arr[i] = new Circle((int)(Math.random()*20+5),nameList[i]);
        }

        System.out.println(arr[0].name + "==" + arr[0].radius);
        System.out.println(arr[1].name + "==" + arr[1].radius);
        System.out.println(arr[2].name + "==" + arr[2].radius);
//        System.out.println(arr[1].radius);
//        System.out.println(arr[2].radius);

    }
}
