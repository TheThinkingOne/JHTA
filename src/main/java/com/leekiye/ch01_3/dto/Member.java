package com.leekiye.ch01_3.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member {
    private int idx;
    private String userName;
    private String userPw;
    private String userId;

    @Builder
    public Member(String userId,String userPw, String userName) {
        this.userId= userId;
        this.userName= userName;
        this.userPw = userPw;
    }
}
