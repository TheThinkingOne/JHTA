public class Book {
    String title;
    String author;

    Book() { // 빈 생성자
        this("",""); // this 는 함수 호출로도 사용 가능하다
        // 이럴 경우 무조건 this()를 첫줄에 써야 함
        System.out.println("나는 this로 호출되었습니다");
    }
    Book(String title) { // 제목만 표기된 책
        //this.title = title;
        //this.author = "작자 미상";
        //this(title); // 자신이 자신 호출은 불가
        this(title, "작자 미상");
    }
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}
