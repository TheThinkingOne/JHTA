package studentinfo;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StudentManager {

    private Scanner sc = new Scanner(System.in);
    private ArrayList<Student> students = new ArrayList<>();
    // 외부로부터 입력받아 학생 정보 여기서 입력
    private void read() {
        System.out.println("학생 정보를 입력하세요. 이름, 학과, 아이디, 학점평점 순");
        for (int i=0; i<4; i++) {
            System.out.println("입력시작===>");
            String str = sc.nextLine();
            StringTokenizer st = new StringTokenizer(str,","); // 구분자로 ","를 구분해서 읽음

            String name = st.nextToken();
            String major = st.nextToken();
            int studentNum = Integer.parseInt(st.nextToken());
            double scoreAvg = Double.parseDouble(st.nextToken());

            Student student = new Student(name,major,studentNum,scoreAvg);
            students.add(student);

        }

    }
    public void showAll() {
        for (int i=0; i<students.size(); i++) {
            String name = students.get(i).getName();
            String major = students.get(i).getName();
            int id = students.get(i).getStudentNum();
            double grade = students.get(i).getScoreAvg();

            System.out.printf("이름 : %s, 학과 : %s, 아이디 : %d, 학점 : %.2f\n",name,major,id,grade);

        }
    }
    public void query() {
        while (true) {
            System.out.println("검색할 학생 입력");
            String name = sc.nextLine();
            if (name.equals("그만")) {
                System.out.println("프로그램 종료");
                break;
            }
            for(int i=0; i<students.size(); i++) {
                Student student = students.get(i);
                if(student.getName().equals(name)) {
                    String name02 = student.getName();
                    String major = student.getName();
                    int id = student.getStudentNum();
                    double grade = student.getScoreAvg();

                    System.out.printf("이름 : %s, 학과 : %s, 아이디 : %d, 학점 : %.2f\n",name02,major,id,grade);
                    break;
                }
                else System.out.println("찾는 학생이 없습니다. 10년째 학교를 다닌다는 이야기가 있습니다..");
            }
        }
    }
    public void run() {
        read();
        showAll();
        query();
    }
}
