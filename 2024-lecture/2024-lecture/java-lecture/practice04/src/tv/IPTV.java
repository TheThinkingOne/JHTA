package tv;
// class 설계는 코드를 많이 두드려 봐야 한다
//
public class IPTV extends ColorTV {
    private String ip;
    //private int color;

    public IPTV(String ip, int size, int color) {
        super(size,color);
        this.ip = ip;
    }

    public void printProperty() {
        System.out.println("나의 IPTV는 " + ip + " 주소의 " + getSize() + "인치" + getColor());
        System.out.println("나의 IPTV는 " + ip + "주소의 ");
        super.printProperty();
    }


}
