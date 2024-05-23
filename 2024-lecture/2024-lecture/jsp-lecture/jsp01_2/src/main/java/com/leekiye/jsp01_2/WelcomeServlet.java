package com.leekiye.jsp01_2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "welcomeServlet", value = "/welcome-servlet") // 주소는 중복되면 안된다
// 이걸 해줘야 호출하는거임, 뒤에 있는 value 값을 주소창에 치면 이 클래스 파일 내용이 뜰것임

public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html"); // text/plain을 하면 평문으로 보냄
        //response.setContentType("application/json");
        // content type 서버에서 내려보내줄때 파일 형식을 지정해서 보내줄 수 있다
        PrintWriter out = response.getWriter();
        out.println("<html><body><h1>Let the world come alive, hehe!!</h1></body></html>");
        // 내려보내주는 오버라이드 기능
    }
}
