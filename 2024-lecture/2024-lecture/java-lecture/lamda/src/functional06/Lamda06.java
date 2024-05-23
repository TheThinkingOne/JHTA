package functional06;

interface MyFunctionInterface {
    double methodCall();
}

class MyMath {
    public double print() {
        return Math.random();
    }
}

public class Lamda06 {
    public static void main(String[] args) {
        MyFunctionInterface mf01 = Math::random;
        System.out.println(mf01.methodCall());
    }
}
