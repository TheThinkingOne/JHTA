class Point {
    private int x,y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override // 재정의
    public String toString() {
        return "point("+x+","+y+")";
    }

    @Override
    public boolean equals(Object obj) {
        Point point = (Point) obj; // point 가 사람, obj 가 동물 이라고 보면 쉬움
        // (Point) obj 같은 걸 다운캐스팅 이라고 함
        if (point.x == x && point.y == y) {
            return true;
        }
        return false;
    }
}


public class ObjectTest {
    public static void showObj(Object object) {
        System.out.println(object.getClass().getName()); // 메서드 chaining
        System.out.println(object.getClass().hashCode());
        System.out.println(object.toString());
    }

    public static void main(String[] args) { // static 이면 따로 생성을 하지 않고도 사용 가능
        // static 이면 다른 영역에서 언제든지 참조 가능
        Point point = new Point(10,20);
        showObj(point);

        // heap 생성하지 않고도 미리 올려져 있는 것
        // static 을 클래스 변수, 함수
        // static 은 미리 메모리에 올라가 있는 상태, static 에서 함수 호출하려면 static 이어야 한다
        // 아니면 생성해서 호출

        Point point02 = new Point(10,20);
        System.out.println(point==point02); // false 출력됨, 이건 재정의가 안됨
        // 위는 주소값을 비교하는 것이기 때문에 false 가 출력된다
        Point point03 = point;
        System.out.println(point==point03);
        // 위는 같은 레퍼런스를 공유하고 있기에 true 가 출력된다
        // 기본 타입에서 == 은 값 비교, 래퍼런스 타입에서 == 은 주소 비교
        System.out.println(point.equals(point02)); // 위에 equals 의 조건문에 따라 true false 다른 결과가 출력됨

        // 자바 메모리 구조 static, heap, stack 영역으로 구분됨
        // static 에 몰라가는 것들에는 자바에서 제공하는 class 들이 있음(static 으로 선언된 것들)
        // static 으로 마구잡이 선언하면 안 좋은 이유는?
        // heap 메모리에 올라가는 것들은 new 로 인스턴스 만들면 여기에 적재된다 ( new Point 인스턴스 만들면 여기에 올라간다)
        // heap 영역이 바로 가비지 컬렉션이 존재하는 곳
        // stack (Point p 인스턴스의 참조값이 여기에 저장된다)

    }
}
