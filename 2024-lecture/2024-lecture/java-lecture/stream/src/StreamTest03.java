import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

public class StreamTest03 {
    public static void main(String[] args) {
        //Optional => null 방지용
        List<Student> studentList = new ArrayList<>();
//        OptionalDouble optionalDouble = studentList.stream()
//                .filter(student -> student.getGrade() == 3)
//                .mapToInt(Student::getScore)
//                .average();
//        System.out.println(optionalDouble); // Optional JPA DB
//        // 현재 입력된 학생의 정보가 없는 상태
//        if (optionalDouble.isPresent()) { // Null 이 있을경우 예외처리
//            System.out.println(optionalDouble.getAsDouble());
//        } else {
//            System.out.println("입력된 점수가 없습니다.");
//        }
        // Optional 은 Null 방지용임
        double optionalDouble = studentList.stream()
                .filter(student -> student.getGrade() == 3)
                .mapToInt(Student::getScore)
                .average()
                .orElse(0.0); // if else 문과 비슷함

        int scoreArray[] = {50,60,70,80,99};
        boolean all100Less = Arrays.stream(scoreArray)
                .allMatch(value -> value < 100);
        System.out.println(all100Less); // allMatch 는 싹다 만족해야함
        
        boolean any100Less = Arrays.stream(scoreArray)
                .anyMatch(value -> value < 55);
        System.out.println(any100Less); // anyMatch 는 한개라도 맞는게 있으면 참 반환

        boolean noneMatch = Arrays.stream(scoreArray)
                .noneMatch(value -> value < 50);
        System.out.println(noneMatch); // anyMatch 는 한개라도 맞는게 있으면 참 반환

        long length = Arrays.stream(scoreArray).count(); // scoreArray 배열의 길이 를 반환
        System.out.println(length);
        long sum = Arrays.stream(scoreArray).sum(); // scoreArray 배열의 길이 를 반환
        System.out.println(sum);
        int max = Arrays.stream(scoreArray).max().getAsInt(); // scoreArray 배열의 최대값 원소 반환
        System.out.println(max);

        int totalSum02 = Arrays.stream(scoreArray)
                .reduce((left, right) -> left + right)
                .getAsInt();
        System.out.println(sum+"==="+totalSum02);

        List<String> fruits = Arrays.asList("orange","banana","apple","berry","berry","apple");
        Set<String> setFruits = fruits.stream().collect(Collectors.toSet());
        setFruits.forEach(s -> {
            System.out.println(s);
        });

        Map<String,String> mapFruits =
                fruits.stream().distinct().collect(
                Collectors.toMap(str->str.toUpperCase(),str->"map"+str)
                );

        mapFruits.forEach((s, s2) -> {
            System.out.println(s+"==="+s2);
        });

    }
}
