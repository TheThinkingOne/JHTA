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
}
