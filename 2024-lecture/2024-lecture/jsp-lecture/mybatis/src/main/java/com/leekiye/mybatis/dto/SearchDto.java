package com.leekiye.mybatis.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchDto {
    private String search;
    private String searchWord;
}
