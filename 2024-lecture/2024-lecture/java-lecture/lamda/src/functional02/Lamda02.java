package functional02;

@FunctionalInterface
interface MyFunctionInterface {
    void method02(int num);
}

public class Lamda02 {
    public static void main(String[] args) {
        MyFunctionInterface mf = (int num) -> System.out.println("매개변수 num : " + num);
        mf.method02(100);
        // 람다식은 조금 있다 배울 stream과 같이 많이 쓴다.
        // 계속 쓰면서 익숙해져야 함.. 기존의 자바 문법과 조금 상이하기 때문
    }
}
