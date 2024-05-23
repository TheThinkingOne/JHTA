package unitConverting;

import java.util.Scanner;

// 추상 메서드를 하나라도 가지고 있으면 추상 클래스가 된다.
// abstract 를 붙여야 한다
abstract class Converter {
    abstract protected double convert(double srs); // abstract 는 리턴값이 필요 없음
    abstract protected String getSrcString(); // abstract 는 몸통이 없다고 볼 수 있다
    abstract protected String getDestString(); // 추상 클래스로 생성자를 만들 수 없음
    protected double ratio;

    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println(getSrcString()+"을 "+getDestString()+"로 바꿉니다.");
        System.out.println("바꾸고싶은 "+getSrcString()+"(화)를 입력하세요 >> ");
        double val = sc.nextDouble();
        double res = convert(val);
        System.out.println("변환 결과 : "+res+getDestString()+"입니다.");
        sc.close();
    }
}
