interface PhoneInterface {
    // String name;   이런거 안됨, 인터페이스는 멤버필드 즉 속성 못씀, 상수는 가능함
    // 다중상속이 인터페이스의 의의 아닌가 싶다
    final int TIMEOUT = 10000;
    public abstract void send();
    void receive();
    default void showLogo() {
        System.out.println("로고출력");
    }
}

interface MP3Interface {
    void play();
    void stop();
}

interface MusicPhoneInterface extends  MobileInterface, MP3Interface {
    void playMusic();
}
// 인터페이스는 다중 구현 가능

class SamsungPhone implements PhoneInterface, MusicPhoneInterface {

    @Override
    public void send() {
        System.out.println("전화 걸기");
    }

    @Override
    public void receive() {
        System.out.println("전화 받음");
    }

    public void Bixby() {
        System.out.println("빅스비 사용 가능");
    }

    @Override
    public void play() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void playMusic() {
        System.out.println("자동재생");
    }

    @Override
    public void sendSMS() {

    }

    @Override
    public void receiveSMS() {

    }
}

class IPhone implements PhoneInterface {
    @Override
    public void send() {
        System.out.println("전화걸기");
    }

    @Override
    public void receive() {
        System.out.println("전화받음");
    }

    public void slideToUnlock() {
        System.out.println("밀어서 잠금해제");
    }
}

interface MobileInterface extends PhoneInterface {
    // 인터페이스 끼리는 상속도 가능하다
//    default void sendSMS() { // 인터페이스는 구현 못하지만 하고싶으면 default 붙이고 할 것
//
//    }
    void sendSMS();
    void receiveSMS();
}

class SamsungPhone02 implements MobileInterface , MP3Interface {
    // 인터페이스는 다중 상속이 가능하다!!

    @Override
    public void send() {
        System.out.println("섹");
    }

    @Override
    public void receive() {
        System.out.println("스");
    }

    @Override
    public void sendSMS() {

    }

    @Override
    public void receiveSMS() {

    }

    @Override
    public void play() {

    }

    @Override
    public void stop() {

    }
}

public class InterfaceTest {
    public static void main(String[] args) {
        SamsungPhone phone = new SamsungPhone(); // 강한 결합
        // 인터페이스 사용 => 느슨한 결합

        PhoneInterface phoneInterface = new SamsungPhone();
        phoneInterface.send();
        phoneInterface.receive();

        PhoneInterface phoneInterface1 = new IPhone();
        phoneInterface1.send();
        phoneInterface1.receive();

        MobileInterface mobileInterface = new SamsungPhone02(); // 느슨한 결합
        mobileInterface.send();
        mobileInterface.receive();

    }
}
