package circlemanager;

import java.util.Scanner;

public class CircleManager {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        Circle c[] = new Circle[3]; // 3개의 Circle 배열 선언
        // => c[] 같은 것을 객체 배열이라고 함

        for (int i=0; i < 3; i ++) {
            System.out.print("x, y, radius >>");
            double x = sc.nextInt(); // x값 읽기.
            double y = sc.nextInt(); // y값 읽기.
            int radius = sc.nextInt(); // radius값 읽기.
            c[i] = new Circle(x,y,radius); // Circle 객체 생성
        }

        for (int i=0; i<c.length; i++) {
            c[i].show(); // 모든 Circle 객체 출력
        }
        // 위아래 for문은 서로 기능이 동일
//        for (Circle circle : c) {
//            circle.show();
//        }
        int big = 0;
        // 알고리즘 코딩테스트
        for (int i=0; i<3; i++) {
            double area = c[i].getArea();
            if (c[big].getArea() > c[i].getArea()) {
                big = i;
            }
            c[i].show();
        }
        System.out.print("가장 큰 원은 ");
        c[big].show();

        sc.close();
    }

}
