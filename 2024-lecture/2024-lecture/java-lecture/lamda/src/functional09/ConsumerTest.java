package functional09;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.Predicate;

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class ConsumerTest {
    public static void main(String[] args) {
        Consumer<String> consumer = (String name) -> System.out.println("이름: " + name);
        consumer.accept("엠마 하디");
        IntConsumer intConsumer = (int value) -> System.out.println("학년: " + value);
        intConsumer.accept(3);

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("이기예",26));
        studentList.add(new Student("엠머 하디",21));
        studentList.add(new Student("이기3",24));
        studentList.add(new Student("이기4",24));
        studentList.add(new Student("이기5",24));
        // Collection 에 있는 Stream
        // Stream 이랑 람다랑 섞어쓰면 편리하게 데이터 추출 같은게 가능함
        studentList.forEach(new Consumer<Student>() {
            @Override
            public void accept(Student student) {
                System.out.println("이름 : " + student.getName());
            }
        });

        System.out.println();

        studentList.forEach(student -> {
            System.out.println("이름 : " + student.getName());
        });

        // Consumer 는 소비자이고 매개변수는 있고 리턴값이 없음
        // Predicate 매개변수 하나 리턴이 boolean 이다
        Predicate<String> predicate = (str) -> {
            return str.length() > 10? true:false ;
        };
        System.out.println(predicate.test("LeeKiYe1999"));

        BiPredicate<String, String> biPredicate = (str1, str2) -> str1.equals(str2);
        System.out.println(biPredicate.test("엠마 하디","Emma Hardy"));

        // 람다는 스트림에 많이 쓰임
    }
}
