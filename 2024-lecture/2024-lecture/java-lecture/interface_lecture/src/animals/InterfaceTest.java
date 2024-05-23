package animals;

public class InterfaceTest {
    public static void main(String[] args) {
        PolarBear polarBear = new PolarBear();
        polarBear.swim();

        // 사냥능력을 가진 동물들 규격맞 맞으면 불러오기 가능
        Huntable hunter = new PolarBear();
        Swimmable swimmer = new Turtle();

        Huntable hunterList[] = {polarBear,hunter};


    }
}
