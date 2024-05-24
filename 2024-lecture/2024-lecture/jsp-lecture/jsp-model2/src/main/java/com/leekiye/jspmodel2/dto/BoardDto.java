package com.leekiye.jspmodel2.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDto {
    private int no;
    private String subject;
    private String content;
    private String userID;
    private String userName;
    private String password;
    private int hit;
    private String regDate;
}
