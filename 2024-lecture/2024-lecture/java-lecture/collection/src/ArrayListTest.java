import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        //List<Integer> arrayList = new ArrayList<>();
        //List<Integer> arrayList = new Vector<>(); 실무에선 이렇게 쓰기도 한다
        String animals [] = {"dog","cat","panda","tiger"};
        List<String> animalList = new ArrayList<>(Arrays.asList(animals));
        System.out.println(animalList);
        System.out.println(animalList.get(0));

        for (int i=0; i<animalList.size(); i++) {
            System.out.print(animalList.get(i) + " ");
        }
        System.out.println();

        for (String animal : animalList) {
            System.out.print(animal + " ");
        }
        System.out.println();

        Iterator<String> iterator = animalList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        animalList.stream().forEach(animal -> {
            System.out.print(animal + " ");
        });
        System.out.println();

        animalList.clear();
        System.out.println(animalList);

        // 사람이름 네개 arrayList 안에 넣고 제일 긴 사람 출력하기

        String names [] = {"Emma Hardy","Lee Ki Ye","Tran Quinn Mai", "Eternal Return"};
        ArrayList<String> nameList = new ArrayList<>(Arrays.asList(names));
        int longest = 0;
        // System.out.println(nameList.get(Math.max(nameList.get(i).length())));
        for (int i=0; i<nameList.size(); i++) {
            int len = nameList.get(i).length();
            if (len > nameList.get(longest).length()) longest = i;
        }
        System.out.println(nameList.get(longest));

        Iterator<String> iterator02 = nameList.iterator();
        while (iterator02.hasNext()) {
            System.out.println(iterator02.next()+ "\t");
        }
    }
}
