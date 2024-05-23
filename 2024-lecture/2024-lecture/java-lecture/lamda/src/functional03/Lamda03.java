package functional03;

@FunctionalInterface
interface MyFunctionInterface {
    int method03(int num01, int num02);
}

public class Lamda03 {
    // 자바스크립트에 적용되는것도 거의 같음... fat arrow function
    public static void main(String[] args) {
        MyFunctionInterface mf01 = (int num01, int num02) -> {
            return num01 + num02;
        };

        MyFunctionInterface mf02 = (num01, num02) -> num01 + num02;

        System.out.println(mf01.method03(10,20));
        System.out.println(mf02.method03(20,40));
    }


}
