package com.leekiye.jspmodel2.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
// setting lombok

public class MemberDto {
    private int no;
    private String userID;
    private String userPW;
    private String userName;
    private String email;
    private int postcode;
    private String address;
    private String address_detail;
    private String birth;
    private String grade;
    private String originalProfile;
    private String renameProfile;
    // 예를들어 다른 사람이 같은 이지미 파일 업로드시에 오류 방지 위함(renameProfile)
}
