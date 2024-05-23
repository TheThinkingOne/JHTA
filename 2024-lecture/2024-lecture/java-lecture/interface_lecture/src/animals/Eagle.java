package animals;

public class Eagle extends Bird implements Flyable, Huntable{
    @Override
    public void fly() {
        System.out.println("하늘을 달리다");
    }

    @Override
    public void hunt() {
        System.out.println("사냥도 잘함");
    }
}
