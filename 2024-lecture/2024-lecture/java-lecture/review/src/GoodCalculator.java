abstract class Calculator {
    abstract public int add(int a, int b);
    abstract public int sub(int a, int b);
    abstract public int mul(int a, int b);
    abstract public int div(int a, int b);
}

class SamsungCalc extends Calculator {
    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public int sub(int a, int b) {
        return a-b;
    }

    @Override
    public int mul(int a, int b) {
        return a*b;
    }

    @Override
    public int div(int a, int b) {
        return a/b;
    }
}

class LG_Calc extends Calculator {
    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public int sub(int a, int b) {
        return a-b < 0 ? b-a : a-b;
    }

    @Override
    public int mul(int a, int b) {
        return a*b;
    }

    @Override
    public int div(int a, int b) {
        return a/b;
    }
}

public class GoodCalculator {
    public static void main(String[] args) {
        Calculator calculator = new SamsungCalc();
        System.out.println(calculator.sub(5,10));

        Calculator calculator1 = new LG_Calc();
        System.out.println(calculator1.sub(5,10));
    }
}