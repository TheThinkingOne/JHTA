package circle;

class MyPoint {
    private int x, y;
    public MyPoint (int x, int y) {this.x = x; this.y = y;}
    public int getX() { return x; }
    public int getY() { return y; }

    public void seePoint() {
        System.out.println("Point" + "(" + getX() + "," + getY() + ")");
    }
}
