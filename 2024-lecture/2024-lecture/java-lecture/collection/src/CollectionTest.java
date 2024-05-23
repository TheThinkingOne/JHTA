import java.util.*;

class User {
    int id;
    int age;
    String name;


    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }
}

public class CollectionTest {
    public static void show(List<String> list) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next() + "\t");
        }
    }
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1,21,"Emma"));
        userList.add(new User(2,20,"Mai"));
        userList.add(new User(3,27,"Estelle"));
        userList.add(new User(4,29,"Estelle"));
        userList.add(new User(5,29,"Ayin"));
        userList.add(new User(6,26,"Carmen"));
        // 객체는 일반적인 방법으로는 정렬 안됨
        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                //return o1.name.compareTo(o2.name);
                if (o1.name.compareTo(o2.name) > 0) {
                    return 1;
                }
                else if (o1.name.compareTo(o2.name) < 0) {
                    return -1;
                }
                else {
                    return o1.age - o2.age;
                }
            }

        });
        for (User user: userList) {
            System.out.println(user.name+"==="+user.id+"==="+user.age);
        }



//        List<String> movieList = new ArrayList<>();
//        movieList.add("아이언맨");
//        movieList.add("파묘");
//        movieList.add("댓글부대");
//        movieList.add("범죄도시");
//        Collections.sort(movieList);
//        show(movieList);
//        System.out.println();
//        Collections.sort(movieList,Collections.reverseOrder());
//        show(movieList);
//        System.out.println();
    }
}
