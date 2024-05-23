package wordquiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordQuiz {
    Scanner sc = new Scanner(System.in);
    List<Word> wordList = new ArrayList<>();
    // 배열 선언
    int question[] = new int[4];

    public WordQuiz() {
        // ctrl + alt + shift + j 하면 드래그한 같은 단어 한번에 바꿀 수 있음
        wordList.add(new Word("constructor", "생성자"));
        wordList.add(new Word("overriding", "재정의"));
        wordList.add(new Word("extends", "상속"));
        wordList.add(new Word("array", "배열"));
        wordList.add(new Word("string", "문자열"));
        wordList.add(new Word("character", "문자"));
        wordList.add(new Word("integer", "정수"));
        wordList.add(new Word("double", "실수"));
        wordList.add(new Word("abstract", "추상"));
        wordList.add(new Word("implements", "구현하다"));
        System.out.println("Java 단어 테스트를 시작합니다. -1을 입력하면 종료합니다.");
    }

    public void run() {
        while (true) {
            // 문제 랜덤으로 출력
            makeExample();
            // 4개가 전부 정답 => 4개의 정답 중에서 랜덤하게 하나만 뽑아서 4개 문항중 한개만 정답으로 만들기
            int answer = (int)(Math.random()*4);
            int answerIdx = question[answer];
            System.out.println(wordList.get(answerIdx).getEng()+"?");
            for(int i=0; i<4; i++) {
                System.out.print("(" + (i+1)+")");
                System.out.print(wordList.get(question[i]).getKor() + " / "); //
            }
            int choice = sc.nextInt();
            if (choice == -1) {
                System.out.println("프로그램 종료.");
                break;
            } else if (choice - 1 == answer) {
                System.out.println("정답입니다!");
                System.out.println();
            } else {
                System.out.println("틀렸습니다");
                System.out.println();
            }



        }
    }

    private void makeExample() { // ctrl + alt + m 하면 매서드로 빼버릴 수 있음
        for (int i=0; i<4; i++) {
            question[i] = (int)(Math.random()*wordList.size());
            for (int j=0; j<i; j++) {
                //j를 i크기 만큼 반복 돌려서 중복 검사
                if (question[i] == question[j]) {
                    i--;
                    continue;
                }
            }
        }
    }
}
