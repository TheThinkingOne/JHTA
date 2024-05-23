package phonebook;

import java.util.Scanner;

public class PhoneBook {
    private Scanner sc = null;
    private Phone phoneList[] = null;

    public PhoneBook() {
        sc = new Scanner(System.in);
    }

    private void read() {
        System.out.println("몇명 입력하시겠습니까?");
        int peopleNum = sc.nextInt();
        phoneList = new Phone[peopleNum];

        for (int i=0; i<peopleNum; i++) {

            System.out.println("이름과 전화번호 입력>>");
            System.out.println("이름을 입력하세요");
            String name = sc.next();
            System.out.println("전화번화를 입력하세요");
            String tel = sc.next();
            phoneList[i] = new Phone(name,tel);
        }

        System.out.println("전화번호 " + peopleNum + "개가 저장되었습니다.");
    }

    private void search(String searchName) {
        boolean isExist = false; // 목록에 해당 사람이 있는지 체크하는 조건
        for (int i=0; i<phoneList.length; i++) {
            if (phoneList[i].getName().equals(searchName)) {
                System.out.println(searchName + "의 번호는" + phoneList[i].getTel() + "입니다.");
                isExist = true;
            }
        }
        if (!isExist) { // 목록에 잇는 사람이 없어서 true가 되지 못했다면
            System.out.println("찾는 사람이 없습니다.");
        }
    }

    public void run() {
        read();
        while (true) {
            System.out.print("검색할 이름을 입력하세요 >>");
            String searchName = sc.next();
            if (searchName.equals("그만")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            search(searchName);

        }
    }
}
