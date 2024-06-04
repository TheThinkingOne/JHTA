package com.leekiye.mybatis.controller.member;

import com.leekiye.mybatis.dao.MemberDao;
import com.leekiye.mybatis.dto.Grade;
import com.leekiye.mybatis.dto.MemberDto;
import com.leekiye.mybatis.dto.ModalDto;
import com.leekiye.mybatis.utils.CookieManager;
import com.leekiye.mybatis.utils.ScriptWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;

@WebServlet("/member/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ModalDto modalDto = new ModalDto("로그인 확인","로그인 해주세요","show");
//        req.setAttribute("modal", modalDto);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/member/login.jsp");
        dispatcher.forward(req, resp);

        System.out.println("Grade.MANAGER == " + Grade.MANAGER);
        System.out.println("Grade.MANAGER == " + Grade.MANAGER.getLabel());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MemberDto memberDto = MemberDto.builder()
                .userID(req.getParameter("userID"))
                .userPW(req.getParameter("userPW"))
                .saveID(req.getParameter("saveID"))
                .build();

        MemberDao memberDao = new MemberDao();
        MemberDto loginMemberDto = memberDao.loginMember(memberDto);

        String saveID = req.getParameter("saveID");
        String userID = req.getParameter("userID");

        // userID 가지고 password 받아서 이걸 BCrypt checkPW 해아함
        if (loginMemberDto != null) {

            if (saveID != null && saveID.equals("yes")) {
                CookieManager.createCookie(resp,"loggedID",userID,60*60*24*365);
            }

            String encodedPassword = loginMemberDto.getUserPW();
            if(BCrypt.checkpw(req.getParameter("userPW"),encodedPassword)) {
                System.out.println("USER PW SUCCESS! XD QWQ ^D^");
                HttpSession session = req.getSession();
                // 암호화된 비밀번호를 비교하여 로그인
                session.setAttribute("sessionID",loginMemberDto.getUserID());
                session.setAttribute("sessionName",loginMemberDto.getUserName());
                session.setAttribute("profile",loginMemberDto.getRenameProfile());
                session.setAttribute("sessionGrade",loginMemberDto.getGrade());
                session.setAttribute("sessionCookieID",loginMemberDto.getSaveID());
                //ScriptWriter.alertAndNext(resp,"로그인 되었습니다.","../index/index");

                ModalDto modalDto = new ModalDto("로그인","로그인 되었습니다.","show");
                // 포워드 시켜야 값이 전달되는건데 이렇게 하면 기능 동작 안함
                HttpSession session02 = req.getSession();
                // req.setAttribute("modal",modalDto); // sendRedirect 를 해도 데이터가 넘어가지 않음
                session02.setAttribute("modal", modalDto);

                resp.sendRedirect("../index/index");
            }

        } else {
            ScriptWriter.alertAndBack(resp,"서버 오류입니다. 다시 시도해주세요.");
            System.out.println("login fail");
        }
    }
}
