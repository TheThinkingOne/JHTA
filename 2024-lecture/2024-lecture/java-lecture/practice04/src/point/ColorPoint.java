package point;

public class ColorPoint extends Point {

    private int x; private int y;
    private String color;
    public ColorPoint(int x, int y, String color) {
        super(x, y); // super는 항상 맨 위에 있어야 함
        this.color = color;
    }
    public void setXY(int x, int y) {
        move(x,y);
    }

    //toString 메서드는 Object가 가지고 있는 method 이다.
    //즉, 모든 객체는 toString 을 쓸 수 있다.

    public void setColor(String color) {
        this.color = color;
        // System.out.print(color + "색의 " + "(" + x + "," + y + ")의 점입니다.");
    }

    public static void main(String[] args) {
        ColorPoint colorPoint = new ColorPoint(5,5,"red");
        System.out.println(colorPoint.toString());
        colorPoint.setXY(10,10);
        colorPoint.setColor("yellow");
        System.out.println(colorPoint.toString());
    }

//    public String toString() {
//        return color + "색의 " + "(" +this.getX()+","+this.getY()+") 의 점입니다.";
//    }





}
