package com.leekiye.jspmodel2.controller.member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/member/login")
public class LoginMember extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/member/login.jsp");
        // login.jsp 파일을 뷰로 하겠다고 선언
        dispatcher.forward(req,resp);
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doGet(req,resp);
//        // 이렇게 하면 get, post 처리 둘 다 가능
//        // 근데 선호하진 않는다고 함
//    }
}
