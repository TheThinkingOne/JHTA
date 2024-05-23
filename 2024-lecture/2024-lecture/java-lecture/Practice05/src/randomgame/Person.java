package randomgame;

import java.util.Scanner;

public class Person {
    //1. scanner
    //2. 이름 출력
    //3. 난수 발생하는 method
    private String name;
    private Scanner scanner = new Scanner(System.in);

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean turn() {
        // 난수 3개 만들고 3개가 같으면 이기는 걸로...
        System.out.print("["+name+"] : Enter");
        scanner.nextLine();
        int nums[] = new int[3];
        for(int i=0;i<3;i++) {
            nums[i] = (int)(Math.random()*3+1);
            System.out.print(nums[i]+"\t");
        }
        boolean result=true;
        for(int i=1;i<3;i++) {
            if(nums[0] != nums[i]) {
                result=false;
                break;
            }
        }
//        if(result){
//            System.out.println("이겼습니다.");
//        } else {
//            System.out.println("안타깝네요.");
//        }
        return result;
    }
}
