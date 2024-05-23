package com.leekiye.jsp05.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor
@ToString

// 위에 4개 저렇게 써주면 편하게 게터세터, 생성자들 만들 수 있음

public class BoardDto {
    private int no;
    private String userID;
    private String userName;
    private String password;
    private String content;
    private String subject;
    private int hit;
    private String regdate;
    // 보통 이럴때는 DB에 작성된 컬럼명을 그대로 적는다

    // Annotation을 이용해서 한번에 하고
    // lombok을 이용
}
