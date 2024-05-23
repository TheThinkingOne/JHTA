package functional05;

@FunctionalInterface
interface MyFunctionInterface {
    void methodCall(int num);
}

class MyMath {
    public void print(int num) {
        System.out.println(num);
    }
}
public class Lamda05 {
    public static void main(String[] args) {
        MyFunctionInterface mf01 = new MyFunctionInterface() {
            @Override
            public void methodCall(int num) {
                MyMath myMath = new MyMath();
                myMath.print(num);
            }
        };

        MyFunctionInterface mf02 = (int num) -> {
            MyMath myMath = new MyMath();
            myMath.print(num);
        };

        MyMath myMath = new MyMath();
        MyFunctionInterface mf03 = System.out::println;
        // ClassName::클래스이름
        // instanceName::메서드이름

        mf01.methodCall(10);
        mf02.methodCall(100);
        mf03.methodCall(1000);

    }
}
