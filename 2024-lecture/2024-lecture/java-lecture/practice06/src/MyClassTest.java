import java.util.ArrayList;
import java.util.HashMap;

public class MyClassTest {
    public static void main(String[] args) {
        // 컴파일시에 구체화된 타입을 대입한다
        MyClass<String> myClass = new MyClass<>();
        myClass.setVal("나는 문자열");
        System.out.println(myClass.getVal());

        MyClass<Integer> myClass02 = new MyClass<>();
        myClass02.setVal(100);
        System.out.println(myClass02.getVal());

        MyClass<Double> myClass03 = new MyClass<>();
        myClass03.setVal(3.14);

        MyBox<String,Integer,Double> myBox = new MyBox<>("이기예",1,3.14);
        System.out.println(myBox.getVal01());
        System.out.println(myBox.getVal02());
        System.out.println(myBox.getVal03());

        ArrayList<HashMap<String,String>> list = new ArrayList<>();
        HashMap<String,String> hashMap01 = new HashMap<>();
        hashMap01.put("장성호","aa");
        list.add(hashMap01);

        System.out.println(list);
        System.out.println(list.get(0).get("장성호"));

        MyClassInteger myClassInteger02 = new MyClassInteger();
        //myClassInteger02.setVal(10.2);


//        MyClassInteger myClassInteger = new MyClassInteger();
//        myClassInteger.setVal(100);
//        System.out.println(myClassInteger.getVal());
    }
}
