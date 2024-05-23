class Person {
    //클래스 내에 클래스는 쓸 수 있지만 접근제어자 (public, private 등)을 못 붙인다.
    String name;
    String id;
    public Person(String name) {
        this.name = name;
    }

    public void eat(Snack saewooggang) {
        saewooggang.open();
    }
    public Person() {

    }
}

class Student extends Person{
    String grade;
    String department;
    public Student(String name) {
        super(name);
    }
}

class Animal {
    String hairColor;
    String leg;
}

class Snack {
    public void open() {
        System.out.println("과자 봉지를 뜯습니다");
    }
}

class Oreo extends Snack {

}

class Saewooggang extends Snack {

}

class PotatoChip extends Snack {

}

public class UpCastingTest {
    public static void main(String[] args) {
        Student student = new Student("이기예");
        student.id = "111";
        student.department = "컴공";
        Person person = student; // 업캐스팅(형변환됨) => person. 했을 때 가짓수가 줄어드는 것 확인
        // Animal animal = student; 상속 안 받았기 때문에 안됨
        Saewooggang saewooggang = new Saewooggang();
        Oreo oreo = new Oreo();
        PotatoChip potatoChip = new PotatoChip();
        Person person02 = new Person();
        Student student02 = (Student) person02; // 다운캐스팅
        student02.grade = "3";
        student02.department = "기계공학";

        person.eat(saewooggang);
        person.eat(oreo);
    }
}
