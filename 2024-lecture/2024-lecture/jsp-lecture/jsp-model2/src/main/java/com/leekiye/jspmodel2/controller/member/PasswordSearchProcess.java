package com.leekiye.jspmodel2.controller.member;

import com.leekiye.jspmodel2.dao.MemberDao;
import com.leekiye.jspmodel2.mail.NaverMail;
import com.leekiye.jspmodel2.utils.ScriptWriter;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@WebServlet("/member/password-send")
public class PasswordSearchProcess extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext application = req.getServletContext();

        String userEmail = req.getParameter("userEmail");
        String uuid = UUID.randomUUID().toString();
        String changedPW = uuid.substring(0,8); // 일반 비밀번호를 고정
        // DB에 비밀번호를 바꿔줘야 함
        MemberDao memberDao = new MemberDao(); // DB 처리는 여기에서
        int result = memberDao.updateChangedPassword(userEmail, changedPW);
        if (result > 0) {
            // result가 1이라면 비밀번호 변경 확인 이메일 전송
            Map<String,String> sendMailInfo = new HashMap<>();
            sendMailInfo.put("from","kiyeleetest@naver.com");
            sendMailInfo.put("to",userEmail);
            sendMailInfo.put("subject","비밀번호 재설정");
            sendMailInfo.put("content","<h1>"+changedPW+"</h1>");
            sendMailInfo.put("format","text/html; charset=utf-8");
            try {
                NaverMail naverMail = new NaverMail(application);
                naverMail.sendMail(sendMailInfo);
                System.out.println("success");
                ScriptWriter.alertAndNext(resp,"메일이 발송되었습니다.","../member/login");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("fail");
                ScriptWriter.alertAndBack(resp,"메일이 전송에 실패하였습니다. 다시 시도해주세요.");
            }
        }
    }
}
