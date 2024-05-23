import java.util.Scanner;

public class BookTest {
    public static void main(String[] args) {
        Book chunhyang = new Book("춘향전");
        System.out.print(chunhyang.title + ", ");
        System.out.println(chunhyang.author);

        Book theStranger = new Book("이방인","알베르 카뮈");
        System.out.print(theStranger.title + ", ");
        System.out.print(theStranger.author);

        Book littlePrince = chunhyang;
        littlePrince.author = "생텍쥐베리";
        System.out.println(littlePrince.title);
        System.out.println(littlePrince.author);
        System.out.println(chunhyang.author);


        // bookList 5개를 만들어서 제목과 저자를 입력받아 배열에 넣고
        // 제목과 저자를 출력하는 코드 완성

        Book bookList[] = new Book[5];
        Scanner sc = new Scanner(System.in);

        for (int i=0; i<5; i++) {
            System.out.println("책 제목과 저자 5가지를 차래로 입력하세요");
            String title = sc.nextLine();
            String author = sc.nextLine();
            bookList[i] = new Book(title, author);
        }
        for (int i=0; i<5; i++) {
            System.out.printf("제목: %s, 저자: %s",bookList[i].title , bookList[i].author);
            System.out.println();
        }

    }
}
