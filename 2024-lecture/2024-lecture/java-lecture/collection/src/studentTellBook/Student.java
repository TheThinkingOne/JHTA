package studentTellBook;

import java.util.HashMap;
import java.util.Map;

class Student {
    private int id;
    private String tel;

    public int getId() {
        return id;
    }

    public String getTel() {
        return tel;
    }

    public Student(int id, String tel) {
        this.id = id;
        this.tel = tel;
        //Map<Integer, String> student = new HashMap<>();
        //student.put(id,tel);
    }




}
