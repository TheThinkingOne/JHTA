package point;

public class Point3D extends Point{
    private int z; // field

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
    // get만 하면 읽기 전용, set까지 하면 읽기,쓰기 다 됨
    public int getZ() {
        return z;
    }

    public void moveUp() {
        z++;
    }

    public void moveDown() {
        z--;
    }

    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + "," +getZ() + ")의 점";
    }

//    public static void main(String[] args) {
//        Point3D point3D = new Point3D(10,10,10);
//        point3D.moveUp();
//        point3D.moveUp();
//        point3D.moveUp();
//        point3D.moveUp();
//        System.out.println(point3D.toString()); // 이거 실행하면 주소값이 나옴(원하는 좌표가 아닌)
//
//        // point3D.z = 30;
//        // System.out.println(point3D);
//    }
}
