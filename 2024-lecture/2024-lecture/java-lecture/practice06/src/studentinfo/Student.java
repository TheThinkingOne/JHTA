package studentinfo;

public class Student {
    private String name;
    private String major;
    private int studentNum;
    private double scoreAvg;

    public Student(String name, String major, int studentNum, double scoreAvg) {
        this.name = name;
        this.major = major;
        this.studentNum = studentNum;
        this.scoreAvg = scoreAvg;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public int getStudentNum() {
        return studentNum;
    }

    public double getScoreAvg() {
        return scoreAvg;
    }

    @Override
    public String toString() { // toString 오버라이드
        return "Student{" +
                "name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", studentNum=" + studentNum +
                ", scoreAvg=" + scoreAvg +
                '}';
    }

    public String showInfo(String name, String major, int studentNum, double scoreAvg) {
        return "hello";
    }
}
