public class MyBox<T01,T02,T03> {
    private T01 val01;
    private T02 val02;
    private T03 val03;

    public MyBox(T01 val01, T02 val02, T03 val03) {
        this.val01 = val01;
        this.val02 = val02;
        this.val03 = val03;
    }

    public T01 getVal01() {
        return val01;
    }

    public T02 getVal02() {
        return val02;
    }

    public T03 getVal03() {
        return val03;
    }
}
