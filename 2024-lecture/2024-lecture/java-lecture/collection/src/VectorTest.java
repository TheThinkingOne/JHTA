import java.util.Vector;

public class VectorTest {
    public static void test(Vector<Integer> vector) { // 매개변수로 collection 을 받을 수 있다
        for (int i=0; i<vector.size(); i++) {
            System.out.println(vector.get(i)+"\t");
        }
    }


    public static void main(String[] args) {
        // 타입 추론
        Vector<Integer> vector = new Vector<>();
        int arr[] = new int[3];
        // 길이가 없음, 가변적이다
        vector.add(1);
        vector.add(10);
        vector.add(-1);
        vector.set(0,1000);
        vector.add(1,100);
        System.out.println(vector.get(0));
        System.out.println(vector.get(1));
        System.out.println(vector.get(2));
        System.out.println(vector.get(3));
        test(vector);

        Vector <Point> vector02 = new Vector<>();
        vector02.add(new Point(10,20));
        vector02.add(new Point(10,20));
        vector02.add(new Point(10,30));
        vector02.remove(1);
        for (int i=0; i<vector02.size(); i++) {
            System.out.println(vector02.get(i).toString());
        }
    }
}
