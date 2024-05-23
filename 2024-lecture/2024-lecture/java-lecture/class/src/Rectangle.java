public class Rectangle {
    int width;
    int height;


    //생성자 오버로드
    Rectangle() { // no type definition => 생성자 함수
        System.out.println("나는 네모 꿈을 꾸는 네모");
    }
    // jvm 에서 생성자 함수를 사용자가 선언하지 않으면
    // 자동으로 생성함

    Rectangle(int w, int h) { // 타입이 있음 => 매개함수
        System.out.println("나는 넓이 " + w + "높이 " + h + " 네모입니다.");
    }

    double getArea() {
        return width*height;
    }
}
