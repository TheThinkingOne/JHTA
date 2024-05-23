package animals;

public class Turtle extends Reptile implements Swimmable {
    @Override
    public void swim() {
        System.out.println("거북이는 바다를 여행합니다");
    }
}
