public class Circle {
    int radius;
    String name;

    Circle() { // 기본 생성자
        radius = 1;
        name = "";
    }

    Circle(int radius, String name) { // 생성자를 2개 이상 만들때는 기본생성자를 따로 정의 해줘야 함
        this.radius = radius;
        this.name = name;
        // 클래스 내에서 자기 자신을 가리키는 것 : this
    }

    double getArea() { //
        return radius*radius*3.14;
        // 함수에 리턴이 없을 경우 void를 붙여주면 됨
    }

}
