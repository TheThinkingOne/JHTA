import java.net.Socket;
import java.util.*;
import java.util.function.Consumer;

public class CollectionTest {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(10);
        intList.add(20);
        intList.add(30);
        intList.add(40);
        intList.add(50);
        System.out.println(intList.get(0));
        System.out.println(intList.size());
        System.out.println(intList.contains(10));
        intList.remove(0);
        System.out.println(intList.get(0));

        List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("berry");
        fruits.add("orange");
        fruits.add("peach");
        for (int i=0; i<fruits.size(); i++) {
            System.out.println(fruits.get(i));
        }
        Iterator<String> iterator = fruits.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        fruits.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        fruits.forEach(s -> {
            System.out.println(s);
        });

        String animals[] = {"panda","tiget","cat","dog","lion"};
        List<String> animalList = Arrays.asList(animals);
        System.out.println(animalList.get(0));
        animals[0] = "wolf";
        System.out.println(animalList.get(0));

        // asList 로 배열을 List 로 바꿔도 배열을 계속 참조하고 있다
        List<String> animalList02 = new ArrayList<>(Arrays.asList(animals));
        animals[0] = "bear";
        System.out.println(animalList02.get(0));
        // 새로 만들고 싶으면 new ArrayList<>(여기에 넣어주면 된다.) 그럼 분리된다

        Set<String> hashSet = new HashSet<>();
        hashSet.add("홍길동");
        hashSet.add("고길동");
        hashSet.add("이길동");
        hashSet.add("엄길동");
        hashSet.add("박길동");

        String stringArray[] = {"홍길동","고길동","이순신","김유신","홍길동"};
        Set hashSet02 = new HashSet<>(Arrays.asList(stringArray));
        System.out.println(hashSet02.size());

        Iterator<String> iterator02 = hashSet02.iterator();
        while (iterator02.hasNext()) {
            System.out.println(iterator02.next());
        }


        Map<String, String> hashMap = new HashMap();
        hashMap.put("apple","사과");
        hashMap.put("banana","바나나");
        hashMap.put("orange","오랜지");
        hashMap.put("berry","딸기");
        hashMap.put("peach","복숭아");

        System.out.println(hashMap.get("apple"));
        System.out.println(hashMap.containsKey("apple"));
        System.out.println(hashMap.containsValue("apple"));
        Set<String> keySet = hashMap.keySet();
        keySet.forEach(s -> {
            System.out.println(s);
        });
        hashMap.remove("apple");
        keySet.forEach(s -> {
            System.out.println(s);
        });

        String stringArray02[] = {"홍길동","고길동","이순신","김유신","홍길동","고길동","이순신","김유신"};
        // 이걸 Map으로 만들어보세요, 키는 정수로 해야함
        Map<Integer, String> hashMap02 = new HashMap<>();
        for (int i=0; i<stringArray02.length; i++) {
            hashMap02.put(i+1,stringArray02[i]);
        }
        System.out.println(hashMap02.get(1));

        System.out.println("중복제거 버전");

        Set<String> set = new HashSet<>(Arrays.asList(stringArray02));
        set.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        // collection stream 할때
        Map<Integer, String> hashMap03 = new HashMap<>();
        int count = 1;
        for (String str : set) {
            hashMap03.put(count,str);
            count++;
        }
        System.out.println(hashMap03.get(1));
        // 중복제거하고 map 으로

        // Steam 입출력 InputStream, OutputStream
        // Writer / Reader


    }
}
