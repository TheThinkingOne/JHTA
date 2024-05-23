import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest01 {
    public static void main(String[] args) {
        // Stream : 데이터 소스를 다루는 표준 기법4
        // Collection List, Set, Map
        List<String> fruits = Arrays.asList("apple","berry","orange","banana");
        Iterator<String> iterator = fruits.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("===============================================");

                List<String> fruits02 = Arrays.asList("apple","berry","orange","banana");
        Stream<String> fruits02Stream = fruits02.stream();
        fruits02Stream.forEach(str -> {
            System.out.println(str+"/");
        });

        int intArray[] = {1,2,3,4,5};
        IntStream intStream = Arrays.stream(intArray);
        intStream.forEach(i-> {
            System.out.println(i+"/");
        });

        IntStream intStream01 = IntStream.range(1,10);
        intStream01.forEach(System.out::print); // 끝 Stream은 한번 쓰면 끝
        // 9까지 출력
        // 다시 쓰려면 다시 생성해야 한다. 1회용
        System.out.println();

        IntStream intStream02 = IntStream.rangeClosed(1,10);
        intStream02.forEach(i-> System.out.print(i)); // 1부터 10까지 출력
        System.out.println();

        IntStream randomIntStream01 = new Random().ints(10);
        randomIntStream01.forEach(i-> System.out.print(i+","));
        System.out.println();

        IntStream randomIntStream02 = new Random().ints(1,100).limit(10);
        // 1부터 100까지의 숫자 중 10개 랜덤하게 생성
        // Stream의 장점 : 중간연산 기능이 있는데 거의 대부분 Stream을 리턴한다
        randomIntStream02.forEach(i-> System.out.print(i+","));
        System.out.println();

        Stream<String> stringStream01 = Stream.of("이기예","엠마 하디","마이");
        Stream<String> stringStream02 = Stream.of(new String[]{"이기예","엠마 하디","마이"});

    }
}