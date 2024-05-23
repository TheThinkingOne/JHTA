public class FruitBox {
    private Object[] fruit;

    public FruitBox(Object[] fruit) {
        this.fruit = fruit;
    }

    public Object getFruit(int idx) {
        return fruit[idx];
    }
}
