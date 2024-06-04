package com.leekiye.mybatis.dto;

import jakarta.servlet.annotation.WebServlet;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class ModalDto {
    private String title;
    private String msg;
    private String isState;
}
