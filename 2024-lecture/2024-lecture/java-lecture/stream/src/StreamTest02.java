import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest02 {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("장성호",3,80));
        studentList.add(new Student("장동건",2,90));
        studentList.add(new Student("홍길동",1,70));
        studentList.add(new Student("손흥민",4,65));
        studentList.add(new Student("정준하",2,93));
        studentList.add(new Student("노홍철",3,88));
        studentList.add(new Student("유재석",3,76));
        //3학년 평균
        //1. Stream 생성-> 중간연산->최종결과
        /*
        Stream<Student> studentStream = studentList.stream();
        Stream<Student> gradeStream =
                studentStream.filter(student -> student.getGrade()==3);
        IntStream scoreStream = gradeStream.mapToInt(Student::getScore);
        OptionalDouble optionalDouble = scoreStream.average();
        double grade03Avg = optionalDouble.getAsDouble();
        System.out.println("3학년 평균값==="+grade03Avg);
        */
        double grade03Avg = studentList.stream()
                .filter(student -> student.getGrade()==3)
                .mapToInt(Student::getScore)
                .average()
                .getAsDouble();

        List<String> fruits =
                Arrays.asList("orange","banana","apple","berry","berry","apple");
        fruits.stream()  // 생성
                .distinct() // 중간연산
                .forEach(System.out::println);  // 최종연산

        studentList.stream()
                .sorted()
                .forEach(student -> {
                    System.out.print(student.getName()+":"+student.getScore()+",");
                });
        System.out.println();

        studentList.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(student -> {
                    System.out.print(student.getName()+":"+student.getScore()+",");
                });

    }
}
