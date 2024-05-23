class MyMath {
    int max(int a, int b) {
        return a > b? a : b;
    }
}
@FunctionalInterface // 왼쪽 어노테이션 달면 기능 하나만 되도록 제한함
interface MyFunction { // 인터페이스로 람다식 사용예(함수형 인터페이스)
    // 자바에선 메서드(객체 안에 있는 함수)만 존재 가능
    int max(int a, int b);
    // 함수형 람다식은 기능 하나만 선언하는게 국룰임
}

public class Main {
    // 메서드만 존재
    // 자바에서는 함수로 존재 불가능

    public static void main(String[] args) {
        //MyMath myMath = new MyMath();
        //int val = myMath.max(10,20);
        MyFunction myFunction01 = new MyFunction() {
            @Override
            public int max(int a, int b) {
                return a > b ? a:b;
                //return a < b ? a:b;
            }
        };
        int value = myFunction01.max(10,20);
        System.out.println(value);

        MyFunction myFunction02 = (int a, int b) -> {
            return a > b ? a:b;
        }; // 위와 동일한 기능, 코드가 더 간졀해짐

        MyFunction myFunction03 = (a, b) -> a > b ? a:b;
        // 동일한 기능
        int value02 = myFunction02.max(10,20);
        System.out.println(value02);

        // 람다는 간편하게 쓸려고 만든 형식이다, 많이 쓰다보면 익숙해짐
        // 스프링 시큐리티 3이상 버전부터 람다식 안쓰면 동작 안됨?

        // 람다는 간편하게 쓸려고 만든 형식이다, 많이 쓰다보면 익숙해짐
        // 스프링 시큐리티 3이상 버전부터 람다식 안쓰면 동작 안됨?

    }
}
