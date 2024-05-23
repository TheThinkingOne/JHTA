package functional04;

@FunctionalInterface
interface MyFunctionInterface {
    void method04();
}

class MyMath {
    public void print() {
        System.out.println("print()메서드를 호출합니다.");
    }
}

public class Lamda04 {
    public static void main(String[] args) {

        MyFunctionInterface mf01 = () -> {
            MyMath myMath = new MyMath();
            myMath.print();
        };
        mf01.method04();

        // 메서드 호출... 하나의 메서드만 호출할때 줄여 쓰는 방법
        MyMath myMath = new MyMath();
        MyFunctionInterface mf02 = myMath::print; // 이건 마이너한 문법인듯
        mf02.method04();

    }
}
