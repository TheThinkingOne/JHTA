package functional08;

import java.util.function.Function;
import java.util.function.Supplier;

@FunctionalInterface
interface MyFunctionInterface {
    MyMath method();
}

class MyMath {
    public MyMath() {
        System.out.println("MyMath 기본생성자");
    }

    public MyMath(int num) {
        System.out.println("MyMath 매개변수 하나 생성자");
    }

    public void print(int num01, int num02) {
        System.out.println(num01+num02);
    }

}
public class Lamda08 {
    public static void main(String[] args) {
        MyFunctionInterface myFunctionInterface01 = new MyFunctionInterface() {
            @Override
            public MyMath method() {
                return new MyMath();
            }
        };

        MyFunctionInterface myFunctionInterface02 = () -> {
            return new MyMath();
        };

        // 생성자 참조
        MyFunctionInterface myFunctionInterface03 = MyMath::new;
        Function<Integer, MyMath> myMathFunction = MyMath::new; // 생성자 안 두번째 메서드 호출

        MyMath myMath03 = myMathFunction.apply(100);
        myMath03.print(100,100);
        // 자바에 미리 정의되어 있는 함수형 인터페이스가 있음
        // java.util.function.Function
        // Runnable (매개변수 없고 리턴도 없음) java.lang
        // Supplier<T> 매개변수 없고 리턴만 있음 / 공급자
        // Consumer<T> 매개변수 있고 리턴은 없음 / 소비자
        // Function<T,R> R apply(T t) 매개변수 있고 리턴 있음 / 함수
        // Predicate<T> boolean test(T t) 매개변수있고 boolean 리턴 함수 / 예측

        MyMath myMath01 = myFunctionInterface01.method();
        myMath01.print(100,200);

        //MyMath myMath02 = myFunctionInterface01.method();
        //myMath02.print(100,200);

        //MyMath myMath03 = myFunctionInterface01.method();
        //myMath03.print(100,200);

    }
}
