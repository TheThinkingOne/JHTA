package com.leekiye.mybatis.dto;

import lombok.*;

@Data // 이거 쓰면 Getter Setter 가 자동으로 생김
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto {
    private int num;
    private int no;
    private String userID;
    private String saveID;
    private String userPW;
    private String userName;
    private String userEmail;
    private int postCode;
    private String address;
    private String addressDetail;
    private Grade grade;
    private String birth;
    private String originalProfile;
    private String renameProfile;
}

//enum Grade {
//    MEMBER, MANAGER, ADMIN
//}
