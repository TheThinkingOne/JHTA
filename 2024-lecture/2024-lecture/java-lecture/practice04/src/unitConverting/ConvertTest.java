package unitConverting;

public class ConvertTest{
    public static void main(String[] args) {
        //ratio 1350원 환율 설정
        Won2Dollar toDollar = new Won2Dollar(1350);
        toDollar.run();
    }
}
