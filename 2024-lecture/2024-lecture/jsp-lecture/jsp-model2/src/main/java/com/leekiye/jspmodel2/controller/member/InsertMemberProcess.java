package com.leekiye.jspmodel2.controller.member;

import com.leekiye.jspmodel2.dao.MemberDao;
import com.leekiye.jspmodel2.dto.MemberDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/member/insert-member-process")
public class InsertMemberProcess extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userID = req.getParameter("userID");
        String userPW = req.getParameter("userPW");
        String userName = req.getParameter("userName");
        String userEmail = req.getParameter("userEMAIL");
        int postCode = Integer.parseInt(req.getParameter("userPOSTCODE"));
        String address = req.getParameter("userADDRESS");
        String detailAddress = req.getParameter("userDETAILADDRESS");
        String birth = req.getParameter("userBirth");

        MemberDto insertMemberDto = new MemberDto();
        insertMemberDto.setUserID(userID);
        insertMemberDto.setUserPW(userPW) ;
        insertMemberDto.setUserName(userName);
        insertMemberDto.setEmail(userEmail);
        insertMemberDto.setPostcode(postCode);
        insertMemberDto.setAddress(address);
        insertMemberDto.setAddress_detail(detailAddress);
        insertMemberDto.setBirth(birth);

        MemberDao memberDao = new MemberDao();
        try {
            int result = memberDao.insertMember(insertMemberDto);
            if (result>0) {
                resp.sendRedirect("../index");
            } else {
                resp.sendRedirect("../member/insert");
            }
        } catch (SQLException e) {
            System.out.println("InsertMemberProcess - SQL ERROR!");
            throw new RuntimeException(e);
        } finally {
            memberDao.close();
        }
    }
}
