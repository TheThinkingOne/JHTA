package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

class Student {
    private int age;
    private String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

public class Stream01 {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple","berry","orange","kiwi");
        Stream<String> fruitsStream = fruits.stream();
        //fruitsStream.forEach(s -> System.out.println(s));
        fruitsStream.forEach(System.out::println);
    }
}
