class Rect {
    private int width, height;
    public Rect(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean equals(Object obj) {
        Rect rect = (Rect) obj;
        if (rect.height * rect.width == height*width) {
            return true;
        }
        return false;
    }
}

public class RectTest {
    public static void main(String[] args) {
        Rect rect01 = new Rect(10,20);
        Rect rect02 = new Rect(4,50);
        Rect rect03 = rect01;
        System.out.println(rect01==rect02);
        System.out.println(rect01==rect03);
        System.out.println(rect01.equals(rect02));
    }
}
