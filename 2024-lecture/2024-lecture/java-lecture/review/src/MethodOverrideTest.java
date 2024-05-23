abstract class Shape { // 설계상에서만 존재
    // 추상 클래스는 계층구조 만들 때 쓴다.
    abstract public void draw(); // 추상 메서드
}

class Line extends Shape {
    // 재정의 Override
    public void draw() {
        System.out.println("Line");
    }
}

class Rect extends Shape {
    public void draw() {
        System.out.println("Rect");
    }
}

class Circle extends Shape {
    public void draw() {
        System.out.println("Circle");
    }
}

class Weapon {
    int fire() {
        return 1;
    }
}

class SuperWeapon extends Weapon {
    @Override
    int fire() {
        return 10;
    }
}

public class MethodOverrideTest {
    static void drawTest(Shape shape) {
        shape.draw();
    }

    public static void main(String[] args) {
        // 오버라이드는 동적 바인딩이 일어난다. runtime 시 결정됨
        Shape shape = new Shape() {
            @Override
            public void draw() {

            }
        };
        shape.draw();

        Shape shape1 = new Circle();
        shape1.draw();

        drawTest(new Line()); // 실행 시점에 결정된다 (동적 바인딩)
        drawTest(new Circle());

        Weapon weapon;
        weapon = new Weapon();
        System.out.println(weapon.fire());
        weapon = new SuperWeapon();
        System.out.println(weapon.fire());
    }
}
