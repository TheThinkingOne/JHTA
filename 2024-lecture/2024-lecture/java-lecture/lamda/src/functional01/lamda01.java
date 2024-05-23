package functional01;

@FunctionalInterface
interface MyFunctionInterface {
    // 매개변수가 없는 람다식
    void method();
}

public class lamda01 {
    public static void main(String[] args) {
        MyFunctionInterface myFunctionInterface01 = new MyFunctionInterface() {
            @Override
            public void method() {
                System.out.println("MyFunctionInterface에서 method를 호출");
            }
        };
        myFunctionInterface01.method();

        MyFunctionInterface myFunctionInterface02 = () -> {
            System.out.println("MyFunctionInterface에서 method를 호출");
        };
        myFunctionInterface02.method();

        MyFunctionInterface myFunctionInterface03 = () -> System.out.println("MyFunctionInterface에서 method를 호출");
        myFunctionInterface03.method();

    }
}
