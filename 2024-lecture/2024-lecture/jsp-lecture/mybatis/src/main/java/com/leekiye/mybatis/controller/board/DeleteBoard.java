package com.leekiye.mybatis.controller.board;

import com.leekiye.mybatis.dao.BoardDao;
import com.leekiye.mybatis.dto.BoardDto;
import com.leekiye.mybatis.utils.ScriptWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/board/delete")
public class DeleteBoard extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/board/delete.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BoardDto boardDto =
                BoardDto.builder()
                        .no(Integer.parseInt(req.getParameter("no")))
                        .password(req.getParameter("password"))
                        .build();
        
        BoardDao boardDao = new BoardDao();
        int result = boardDao.deleteBoard(boardDto);
        if (result > 0) {
            resp.sendRedirect("../board/list");
        } else {
            ScriptWriter.alertAndBack(resp, "서버 오류입니다. 다시 시도해주세요.");
        }

//        String no = req.getParameter("no");
//        String password = req.getParameter("password");
    }
}
