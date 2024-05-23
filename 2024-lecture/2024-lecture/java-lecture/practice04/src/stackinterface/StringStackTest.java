package stackinterface;

import java.util.Scanner;

public class StringStackTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("총 스택 저장 공간의 크기 입력 >> ");
        int total = sc.nextInt();

        StringStack stringStack = new StringStack(total);

        while (true) {
            System.out.print("넣을 문자열 입력 >> ");
            String str = sc.next();
            if(str.equals("그만")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            boolean over = stringStack.push(str);
            if(over==false) {
                System.out.println("더 이상 입력 불가능합니다.");
            }

            int end = stringStack.length();
            for(int i=0; i<end; i++) {
                System.out.print(stringStack.pop() + " ");
                System.out.println("i===" + i);
                System.out.println("===stringStack.length()"+stringStack.length());
            }

        }
    }
}
