package com.leekiye.jspmodel2.controller.member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/member/insert") // Mapping
public class InsertMember extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        // DB 접속도 하고 데이터 조작도 하고...
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/member/insert-member.jsp");
        // 이렇게 해서 웹서블릿이 서버요청으로 insert-member.jsp 파일 내용을 불러오는 것!
        dispatcher.forward(req,resp); // jsp 를 호출해서 포워딩 한다
        // RequestDispatcher dispatcher 이게 ㅈㄴ 중요!!
        // 이렇게 해서 view 를 보여준다

    }

    // 원래는 주소창에 ~~/member/insert-member.jsp 를 쳐야 했는데
    // 이렇게 하면 주소창에 ~~/member/insert 만 쳐도 insert-member.jsp가 불려온다
}
