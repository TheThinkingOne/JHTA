import java.sql.Array;
import java.util.*;
import java.util.function.Predicate;

@FunctionalInterface
interface MyFunctionalInterface {
    void method(); // 매개변수도 없고 리턴타입도 없는 경우
}
@FunctionalInterface
interface MyFunctionalInterface02 {
    void method(int num); // 매개변수만 있는 경우
}
@FunctionalInterface
interface MyFunctionalInterface03 {
    int method(int num01, int num02);
}
@FunctionalInterface
interface MyFunctionalInterface04 {
    int method(int num01);
    // 제곱을 구하는
}

public class Lamda01 {
    public static void main(String[] args) {
        // 줄여쓰기... ----> 코드를 줄여쓰기
        // lamda expresssion 식 값이 있으면
        MyFunctionalInterface myFunctionalInterface = () -> System.out.println("람다식으로 바꿔보자");
        myFunctionalInterface.method();

        MyFunctionalInterface02 myFunctionalInterface02 = num -> System.out.println(num);
        myFunctionalInterface02.method(100);

        MyFunctionalInterface03 myFunctionalInterface03 = (num01, num02) -> num01 + num02;
        System.out.println(myFunctionalInterface03.method(100,200));

        MyFunctionalInterface04 myFunctionalInterface04 = num01 -> num01*num01;
        System.out.println(myFunctionalInterface04.method(100));

        List<String> list = Arrays.asList("apple","banana","berry","mango");
        // 이건 옛날에 만들어진거라 어쩔 수 없이 남겨둠
        Collections.sort(list, (o1, o2) -> o2.compareTo(o1));
        /*
        1. 매개변수 없고 리턴없고 Runnable
        2. 매개변수 있고 리턴만 있는 겨웅 Supplier<T> get()
        3. 매개변수 있고 리턴 없고 Consumer<t> accept(T t)
        4. 매개변수 하나 맅너 있고 Function<T, R> R apply(T t)
        5. 매개변수 있고 리턴 boolean Predicate<t> boolean accept(T t)
         */
        Predicate<String> isEmptyString = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length()==0;
            }
        };
        String msg = "";
        Predicate<String> isEmptyString02 = s -> s.length()==0;
        if(!isEmptyString02.test(msg)) {
            System.out.println("문자열이 공백이 아닙니다.");
        } else System.out.println("문자열이 공백입니다.");

    }
}
