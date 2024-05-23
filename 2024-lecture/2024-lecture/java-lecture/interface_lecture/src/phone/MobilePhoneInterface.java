package phone;

public interface MobilePhoneInterface extends PhoneInterface {
    // 인터페이스는 인터페이스 상속이 가능함
    public void sendSMS();
    public void receiveSMS();

}
