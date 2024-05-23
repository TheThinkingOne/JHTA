package studentTellBook;

import java.util.HashMap;
import java.util.Scanner;

public class StudentMapTest {
    // studentTellBook.Student class 를 만들어서 id와 tel을 속성으로 가진다.
    // map에 <String, studentTellBook.Student> 로 5명을 Map에 넣고 scanner 를 통해 이름을 입력받아 id와 전번 출력
    // 이때 찾는 사람 없으면 없는 사람이라고 출력
    public static void main(String[] args) {
        HashMap<String, Student> telBook = new HashMap<>();
        telBook.put("이기영",new Student(1,"010-6375-4551")); // 해시맵에 클래스 넣는것도 가능
        telBook.put("이기일",new Student(2,"010-6375-4552"));
        telBook.put("이기이",new Student(3,"010-6375-4553"));
        telBook.put("이기삼",new Student(4,"010-6375-4554"));
        telBook.put("이기사",new Student(5,"010-6375-4555"));

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("찾는 학생이름 입력 >> ");
            String name = sc.nextLine();
            if (name.equals("그만")) {
                System.out.println("프로그램 종료");
                break;
            }
            Student student = telBook.get(name);
            if (student==null) System.out.println("없는 학생입니다.");
            else {
                System.out.println("번호는 " + student.getId() + " 전화번호: " + student.getTel());
            }

        }


//        studentTellBook.Student student1 = new studentTellBook.Student(1,"010-6375-4551");
//        studentTellBook.Student student2 = new studentTellBook.Student(2,"010-6375-4552");
//        studentTellBook.Student student3 = new studentTellBook.Student(3,"010-6375-4553");
//        studentTellBook.Student student4 = new studentTellBook.Student(4,"010-6375-4554");
//        studentTellBook.Student student5 = new studentTellBook.Student(5,"010-6375-4555");




    }
}
