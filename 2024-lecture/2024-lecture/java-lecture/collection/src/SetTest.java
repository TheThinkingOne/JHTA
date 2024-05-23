import java.util.*;

public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("apple");
        set.add("banana");
        set.add("berry");
        set.add("apple");
        System.out.println(set);

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        String array[] = {"H","A","P","P","Y"};
        Set<String> set02 = new HashSet<>(Arrays.asList(array));
        Set<String> set03 = new LinkedHashSet<>(Arrays.asList(array));
        // LinkedHashSet은 순서도 기억해줌

        Iterator<String> iterator02 = set02.iterator();
        Iterator<String> iterator03 = set03.iterator();
        while (iterator02.hasNext()) System.out.print(iterator02.next() + " ");
        System.out.println();
        while (iterator03.hasNext()) System.out.print(iterator03.next() + " ");
        System.out.println();

        String distinctArray[] = set02.toArray(new String[0]);
        System.out.println(Arrays.toString(distinctArray));

    }
}
