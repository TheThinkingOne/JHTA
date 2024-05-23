package phone;

public class SamsungPhone implements MobilePhoneInterface, Mp3Interface {
    @Override
    public void sendCall() {
        System.out.println("전화를 겁니다.");
    }

    @Override
    public void receiveCall() {
        System.out.println("전화 왔어용");
    }

    @Override
    public void sendSMS() {
        System.out.println("문자를 보내용");
    }

    @Override
    public void receiveSMS() {
        System.out.println("문자를 받았어용");
    }

    @Override
    public void play() {
        System.out.println("음악을 재생합니다.");
    }

    @Override
    public void stop() {
        System.out.println("음악을 멈춥니다.");
    }

    //    @Override
//    public void printLogo() {
//        phone.PhoneInterface.super.printLogo();
//    }
}
