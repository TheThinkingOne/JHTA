package aaa;

public class BBB extends AAA {
    public void set() {
        pub = 10;
        def = 20;
        pro = 30;
        // pri = 40; 안됨
    }


    public BBB() { // 이걸 선언 안하고 main 실행하면? => 자동으로 빈 생성자 만들어지고 부모 클래스 호출
        System.out.println("나는 BBB");
    }
}
