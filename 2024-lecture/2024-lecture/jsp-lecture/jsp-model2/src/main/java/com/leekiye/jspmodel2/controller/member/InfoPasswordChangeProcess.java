package com.leekiye.jspmodel2.controller.member;

import com.leekiye.jspmodel2.controller.HelloServlet;
import com.leekiye.jspmodel2.dao.MemberDao;
import com.leekiye.jspmodel2.dto.MemberDto;
import com.leekiye.jspmodel2.utils.ScriptWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/member/password-change-info")
public class InfoPasswordChangeProcess extends HelloServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentPW = req.getParameter("currentPW");
        String newPW = req.getParameter("newPW");
        //String newPWConfirm = req.getParameter("newPWConfirm");
        String userID = req.getParameter("userID");

        MemberDao memberDao = new MemberDao();
        MemberDto memberDto = memberDao.loginMember(userID,currentPW);
        if(memberDto!=null) {
            MemberDao updateMemberDao = new MemberDao();
            int result = updateMemberDao.updatePasswordAtInfo(userID,newPW);
            if (result > 0) {
                HttpSession session = req.getSession();
                session.invalidate();
                ScriptWriter.alertAndNext(resp,"비밀번호가 변경되었습니다.","../member/login");
            } else {
                ScriptWriter.alertAndBack(resp,"서버 오류가 발생했습니다. 다시 시도해주세요.");
            }
        } else {
            ScriptWriter.alertAndBack(resp,"아이디 패스워드를 확인해주세요.");
        }
        // 1. 기존 비밀번호가 맞는지 확인 SELECT
        // 2. 새로운 비밀번호로 바꿔주기  UPDATE

//        if (result > 0) {
//            ScriptWriter.alertAndNext(resp,"비밀번호가 변경되었습니다. 다시 로그인해주세요","../member/login");
//        } else {
//            ScriptWriter.alertAndBack(resp,"비밀번호, 또는 비밀번호 확인을 다시 해주세요");
//        }
        memberDao.close();
    }
}
