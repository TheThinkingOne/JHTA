package com.leekiye.mybatis.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
 // 필요한 것만 찾아서 생성자를 만드는 함수

public enum Grade {
    // 열거형 제한
//    MEMBER, MANAGER, ADMIN;
//    // 값을 따로 입럭하지 않으면 순서대로 적용된다
    MEMBER("member"),
    MANAGER("manager"),
    ADMIN("admin");

    private final String label;

//    public String label() {
//        return label;
//    }
//    // Constructor
//
////    Grade(String label) {
////        this.label = label;
////    }
}
