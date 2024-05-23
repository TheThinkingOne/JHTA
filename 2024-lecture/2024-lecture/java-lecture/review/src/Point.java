public class Point {
    private int x,y;

    public Point(int x, int y) {

    }

//    public Point() {
//        System.out.println("나는 기본 생성자");
//    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("나는 x, y를 매개변수로 가지는 생성자");
    }

    public void showPoint() {
        System.out.println(x+","+y);
    }

}
