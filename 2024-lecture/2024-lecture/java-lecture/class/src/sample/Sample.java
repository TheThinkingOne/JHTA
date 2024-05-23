package sample;

public class Sample {
    public int a;
    private int b;
    public int c;

    // field 맴버는 private으로 막고
    // 메서드를 통해서 외부로 노출시킨다.

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
