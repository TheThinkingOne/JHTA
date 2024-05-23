package functional07;

@FunctionalInterface
interface MyFunctionInterface {
    void method(MyMath myMath, int num01, int num02);
}

class MyMath {
    public void print(int num01, int num02) {
        System.out.println(num01+num02);
    }
}

public class Lamda07 {
    public static void main(String[] args) {
        MyFunctionInterface myFunctionInterface = new MyFunctionInterface() {
            @Override
            public void method(MyMath myMath, int num01, int num02) {
                myMath.print(num01,num02);
            }
        };
        myFunctionInterface.method(new MyMath(),69,74);

        MyFunctionInterface myFunctionInterface02 = ((myMath, num01, num02) -> {
            myMath.print(num01,num02);
        });
        myFunctionInterface02.method(new MyMath(), 100,200);

        MyFunctionInterface myFunctionInterface03 = MyMath::print;
        myFunctionInterface03.method(new MyMath(), 1000,2000);

    }


}
