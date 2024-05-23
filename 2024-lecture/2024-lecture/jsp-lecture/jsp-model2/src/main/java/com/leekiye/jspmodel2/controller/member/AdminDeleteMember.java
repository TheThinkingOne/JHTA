package com.leekiye.jspmodel2.controller.member;

import com.google.gson.Gson;
import com.leekiye.jspmodel2.dao.MemberDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/member/delete")
public class AdminDeleteMember extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userID = req.getParameter("userID");
        MemberDao memberDao = new MemberDao();
        int result = memberDao.deleteMenber(userID);
        Map<String,String> resultMap = new HashMap<>();
        if (result>0) {
            resultMap.put("isDelete","yes");
        } else {
            resultMap.put("isDelete","no");
        }
        Gson gson = new Gson();
        String resultJSon = gson.toJson(resultMap);
        // 삭제 결과를 resultMap에 담고 이것을 gson에 전달
        PrintWriter out = resp.getWriter();
        out.print(resultJSon);
    }
}
