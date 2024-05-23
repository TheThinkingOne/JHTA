package com.leekiye.jsp01_2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginProcess", value = "/login-process")
public class LoginProcessServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.doPost(req, resp);
        String userID = request.getParameter("userID");
        String userPW = request.getParameter("userPW");
        System.out.println(userID+"==="+userPW);
        if (userID.equals("EmmaHardy21") && userPW.equals("1234")) {
            // 로그인 성공
            response.sendRedirect("/jsp01_2_war_exploded/login/login-ok.jsp");
        } else {
            // 로그인 실패
            PrintWriter out = response.getWriter();
            out.println("<script>alert(\"아이디 패스워드를 다시 확인해주세요\");history.back();</script>");
        }
    }
}
