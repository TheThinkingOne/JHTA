package com.leekiye.jspmodel2.controller.member;


import com.leekiye.jspmodel2.controller.HelloServlet;
import com.leekiye.jspmodel2.dao.MemberDao;
import com.leekiye.jspmodel2.dto.MemberDto;
import com.leekiye.jspmodel2.utils.CookieManager;
import com.leekiye.jspmodel2.utils.ScriptWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/member/login-member-process")
public class LoginMemberProcess extends HelloServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userID = req.getParameter("userID");
        String userPw = req.getParameter("userPW");
        String saveID = req.getParameter("saveID");

        MemberDao loginMemberDao = new MemberDao();
        MemberDto loginMemberDto = loginMemberDao.loginMember(userID, userPw);
        if (loginMemberDto != null) {
            HttpSession session = req.getSession();
            session.setAttribute("sessionMemberDto", loginMemberDto);
            // 이렇게하면 유저 아이디와 유저비밀번호 두개 보내야 하는걸 한번에 보낼 수 있다
            if (saveID != null && saveID.equals("yes")) {
                CookieManager.createCookie(resp,"loggedID",userID,60*60*24*365);
            }
            resp.sendRedirect("../index/index");
        } else {
            ScriptWriter.alertAndBack(resp,"아이디 비밀번호를 확인해주세요.");
        }
    }
}
