package nation;

public class NationInfo {
    String nation;
    int personNum;

    public NationInfo(String nation, int personNum) {
        this.nation = nation;
        this.personNum = personNum;
    }

    public String getNation() {
        return nation;
    }

    public int getPersonNum() {
        return personNum;
    }
}
