package phone;

public interface PhoneInterface {
    final int TIME_OUT = 10000;
    public void sendCall();
    public void receiveCall();
    default void printLogo() {
        System.out.println("==로고==");
    }
}
