public class ColorPoint extends Point{
    private String color;
    public void setColor(String color) { // 생성자 정의
        this.color = color;
    }

    public void show() {
        System.out.printf("컬러는 %s", color);
        // System.out.printf("x,y 좌표는 %d,%d",x,y);
        // show(); // 이렇게 되면 재귀함수
        super.show(); // super를 통해 부모것을 호출
    }

    // 자바는 클래스의 다중 상속을 지원하지 않음
    // 파이썬, c++은 다중 상속을 지원함
}
