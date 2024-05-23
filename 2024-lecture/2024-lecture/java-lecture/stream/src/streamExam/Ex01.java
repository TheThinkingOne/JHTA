package streamExam;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Ex01 {
    // 리스트에서 a로 시작하는 것 중복없이 출력
    public static void main(String[] args) {
        List<String> fruitList = Arrays.asList("apple","banana","apple","mango","strawberry","banana", "mango");
        fruitList.stream()
                .filter(s -> s.startsWith("a")) // 필터링
                .distinct()
                .forEach(s -> {
                    System.out.println(s);
                });
    }
}
