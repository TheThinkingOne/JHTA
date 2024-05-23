package bbb;

import aaa.AAA;

public class CCC extends AAA {
    public void set() {
        // default는 같은 패키지 내애서만
        // private는 상속 불가
        this.pro = 20;
        this.pub = 40;
    }
}
