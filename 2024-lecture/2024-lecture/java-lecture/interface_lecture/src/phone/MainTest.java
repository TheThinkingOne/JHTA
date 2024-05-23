package phone;

public class MainTest {
    public static void main(String[] args) {
        MobilePhoneInterface smartPhone = new SamsungPhone();
        smartPhone.sendCall();
        smartPhone.receiveCall();
        smartPhone.sendSMS();
        smartPhone.receiveSMS();
    }
}
