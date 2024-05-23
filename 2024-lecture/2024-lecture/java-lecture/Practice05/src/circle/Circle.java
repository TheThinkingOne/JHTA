package circle;

class Circle {
    private int x, y, radius;
    private String circleName;
    public Circle(int x, int y, int radius, String circleName) {
        this.x = x; this.y = y; this.radius = radius; this.circleName = circleName;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public String getCircleName() {
        return circleName;
    }

    public void seeCircleInfo() {
        System.out.println(circleName + " : " + "Circle" + "(" + x + "," + y + ")" + "반지름" + radius);
    }

}
