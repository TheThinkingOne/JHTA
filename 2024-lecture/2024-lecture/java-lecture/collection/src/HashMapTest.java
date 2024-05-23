import javax.swing.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapTest {
    public static void main(String[] args) {
        // Map Key value
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("apple","사과"); // apple이 키값, 사과가 value값
        dictionary.put("banana","바나나");
        dictionary.put("strawberry","딸기");
        System.out.println(dictionary.get("apple"));
        System.out.println(dictionary.size());
        System.out.println(dictionary.containsKey("apple"));
        System.out.println(dictionary.containsValue("사과"));
        System.out.println(dictionary.containsValue("사과과"));
        dictionary.put("apple","부사");
        System.out.println(dictionary.get("apple"));
        if (!dictionary.containsKey("apple")) {
            dictionary.put("apple","스티븐잡스");
        }
        dictionary.putIfAbsent("cat","괴렘");
        System.out.println(dictionary.get("cat"));
        // 키를 알아야지만 값을 꺼내올 수 있기 때문에 반복문이 불가능?
        // key 를 뽑아올 수 있음
        System.out.println();

        Set<String> keySet = dictionary.keySet(); // 1 key 값 뽑기
        Iterator<String> iterator = keySet.iterator(); // key 에서 순환자 만들기
        while (iterator.hasNext()) {
            System.out.println(iterator.next()+"==="+dictionary.get(iterator.next()));
        }
        //foreach
        for(Map.Entry<String,String> entry:dictionary.entrySet()) {
            System.out.println(entry.getKey()+"=="+entry.getValue());
        }
        System.out.println();


        //학생 5명의 이름과 점수를 map에 저장하고
        //각 학생의 이름과 점수를 뽑고 총점 및 평균을 구하시오
        Map<String, Integer> student = new HashMap<>();
        int sum = 0;
        int sum02 = 0;
        student.put("Emma hardy1",100);
        student.put("Emma hardy2",95);
        student.put("Emma hardy3",97);
        student.put("Emma hardy4",98);
        student.put("Emma hardy5",99);

        Set<String> stuKeySet = student.keySet();
        Iterator<String> stuIterator = stuKeySet.iterator();

        while (stuIterator.hasNext()) {
            String name = stuIterator.next();
            int score = student.get(name);
            System.out.println(name+":"+score+"점");
            sum02 += score;
        }
        System.out.println("평균은 " + sum02/student.size());
        System.out.println();

        for(Map.Entry<String,Integer> entry:student.entrySet()) {
            System.out.println(entry.getKey()+"=="+entry.getValue());
        }
        for(Map.Entry<String,Integer> entry:student.entrySet()) {
            sum += entry.getValue();
        }
        System.out.println(sum);
        System.out.println(sum/student.size());




    }
}
