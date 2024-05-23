package com.leekiye.jspmodel2.controller.member;


import com.leekiye.jspmodel2.dao.MemberDao;
import com.leekiye.jspmodel2.dto.MemberDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/member/list")
public class ListMember extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // list를 실어서 보내주는
        MemberDao memberDao = new MemberDao();
        List<MemberDto> memberList = memberDao.listMember();
        // 여러개를 리턴할때 list를 리턴하는게 좋지
        req.setAttribute("memberList", memberList);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/member/list-member.jsp");
        dispatcher.forward(req, resp);
    }
}
