public class FruitBoxGeneric <T> {
    private T[] fruit;
    public FruitBoxGeneric(T[] fruit) {
        this.fruit = fruit;
    }

    public T getFruit(int idx) {
        return fruit[idx];
    }

    public void method01() {
        //생성안됨
        // T t = new T(); => 이런 식으로 생성이 불가능함
    }

     //public static T method02() 이런것도 안됨
}
