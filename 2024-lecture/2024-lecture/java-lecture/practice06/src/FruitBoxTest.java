class Apple {

}
class Banana {

}

class Money {

}


public class FruitBoxTest {
    public static void main(String[] args) {
        Apple[] appleArr = {
                new Apple(),
                new Apple(),
                new Apple(),
        };
        Money[] moneyArr = {
                new Money(),
                new Money(),
                new Money(),
        };

        FruitBox appleBox = new FruitBox(appleArr); // 사과 들어가 있는거
        FruitBox moneyBox = new FruitBox(moneyArr); // 돈 들어가 있는거

        // Money money01 = (Money)appleBox.getFruit(0); // => 사과박스 안에 돈 있는줄 알고 눈 감고 꺼내는 꼴

        FruitBoxGeneric<Money> fruitBoxGeneric01 = new FruitBoxGeneric<>(moneyArr); // 돈 박스 안에 돈만 들어가게 보장
        Money money01 = (Money) fruitBoxGeneric01.getFruit(0);
        // Apple money02 = (Money) fruitBoxGeneric01.getFruit(0); 이렇게 해서 형 오류 잡아줌


        // 예전엔 Object 로 받아서 썼었음
        // 근데 값을 끄집어 낼대마다 형변환 해야하는 불편함이 있더라...
        // 그리고 내 마ㅏ음대로 형변환해도 오류 검증이 안됨
        // 그래서 나온게 Generic 이다.
        // 선언단계에서는 일반적인 변수타입 <T,K,V,E> 를 쓰고
        // 컴파일 단계에서 구체화 시킨다. <String> <Integer> <Apple> 등등


//        Apple apple = (Apple) box.getFruit(0); // (Apple)로 씌워서 형변환 해줘야 함
//        Banana banana = (Banana) box.getFruit(0);

//        FruitBoxGeneric<Apple> boxGeneric = new FruitBoxGeneric<>(arr);
//        Apple apple02 = (Apple)boxGeneric.getFruit(0);
        //Banana banana02 = boxGeneric.getFruit(1);
    }
}
