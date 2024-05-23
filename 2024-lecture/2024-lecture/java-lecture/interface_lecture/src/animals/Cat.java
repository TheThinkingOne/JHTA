package animals;

public class Cat extends Mamal implements Swimmable, Huntable {
    @Override
    public void swim() {
        System.out.println("수영을 할수는 있습니다만....");
    }

    @Override
    public void hunt() {
        System.out.println("쥐를 잘 잡습니다");
    }
}
