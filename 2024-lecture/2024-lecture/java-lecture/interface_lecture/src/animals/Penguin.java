package animals;

public class Penguin extends Bird implements Swimmable {
    @Override
    public void swim() {
        System.out.println("바다를 헤엄칩니다.");
    }
}
