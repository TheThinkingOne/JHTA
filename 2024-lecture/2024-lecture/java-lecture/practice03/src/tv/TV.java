package tv;

public class TV {
    private String maker;
    private int size;
    private int year;

    TV(String maker, int year, int size) {
        this.maker = maker;
        this.year = year;
        this.size = size;
    }
    public void show() {
        System.out.println(maker + "에서 만든 " + year + " 년도 " + size + "인치 TV");
    }
}
