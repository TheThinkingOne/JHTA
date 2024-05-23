package grade;

public class Grade {
    private int mathScore;
    private int scienceScore;
    private int englishScore;
    public Grade(int mathScore, int scienceScore, int englishScore) {
        this.mathScore = mathScore; // this
        this.scienceScore = scienceScore;
        this.englishScore = englishScore;
        // alt + insert 를 누르면 생성자 간단 생성 가능
    }

    public double average() {
        int result = (mathScore+scienceScore+englishScore)/3;
        return result;
    }
}
