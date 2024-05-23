package wordquiz;

public class Word {
    private String Kor;
    private String Eng;

    public Word(String eng, String kor) {
        this.Eng = eng;
        this.Kor = kor;
    }

    public String getKor() {
        return Kor;
    }

    public String getEng() {
        return Eng;
    }
}
