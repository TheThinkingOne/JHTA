// 우리가 만든 클래스
// 자바에는 미리 만들어져 있는 내부 클래스들이 엄청 많다
class Student {
    String name ;
    int age ;
    String address;

    public Student() {

    }
    public Student(String name) {
        this.name = name;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    void print() {
        System.out.println("이몸이 갑니다!");
    }

}



public class Main {
    public static void main(String[] args) {
        // 자바는 클래스로 움직인다.
        Student student01 = new Student(); // reference type
        Student student02 = new Student(); // reference type
        int num = 10; // primitive

        student01.address = "지구";
        student01.name = "Emma Hardy";
        student01.age = 21;

        student02.address = "지구 어딘가";
        student02.name = "이기예";
        student02.age = 24;




    }
}

// 오버로드는 매개변수의 갯수와 타입을 따진다. return은 해당사항 없음