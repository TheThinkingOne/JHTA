package rectangle;

import javax.crypto.spec.RC2ParameterSpec;

public class Rectangle {
    private int x;
    private int y;
    private int width;
    private int height;

    public int getX() {
        return x;
    }

    Rectangle(int x, int y, int width, int height) {
        this.x = x; this.y = y; this.width = width; this.height = height;
    }

    public int square() {
        return width * height;
    }

    public void show() {
        System.out.println("(" + x + "," + y + ")" + " 에서 크기가" + "(" + width + "x" + height + ")" + "인 사각형");
    }

    public boolean contains(Rectangle rect) {
        // 예를들어 t.contains(r)을 할 경우 rect.x 는 r의 x 값, x는 t의 x값
        if (rect.x > x && rect.y > y
                && rect.x + rect.width < x + width
                && rect.y + rect.height < x + height) {
            return true;
        }
        return false;
    }
}
