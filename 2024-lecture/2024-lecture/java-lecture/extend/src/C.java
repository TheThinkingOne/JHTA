public class C extends B {
    public C() {
        System.out.println("나는 카르멘");
    }
    public C(int i) {
        //super(3);
        super(i);
        System.out.println("나는 매개변수" + i +"를 가지는 카르멘");

        //super 키워드 안쓰면 매개변수가 있든 없든 무조건 기본 생성자 호출됨
    }
}
