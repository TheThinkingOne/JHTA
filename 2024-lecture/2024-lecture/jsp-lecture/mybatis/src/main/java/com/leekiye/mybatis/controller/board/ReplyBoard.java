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

@WebServlet("/board/reply")
public class ReplyBoard extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/board/reply.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BoardDto updateBoardDto = BoardDto.builder()
                .regroup(Integer.parseInt(req.getParameter("regroup")))
                .relevel(Integer.parseInt(req.getParameter("relevel")))
                .build();
        BoardDao updateRelevelDao = new BoardDao();
        updateRelevelDao.updateRelevel(updateBoardDto);

        BoardDto boardDto =
                BoardDto.builder()
                        .subject(req.getParameter("subject"))
                        .content(req.getParameter("content"))
                        .password(req.getParameter("password"))
                        .userID(req.getParameter("userID"))
                        .userName(req.getParameter("userName"))
                        .regroup(Integer.parseInt(req.getParameter("regroup"))+1)
                        .relevel(Integer.parseInt(req.getParameter("relevel"))+1)
                        .restep(Integer.parseInt(req.getParameter("restep"))+1)
                        .build();
        BoardDao boardDao = new BoardDao();
        int result = boardDao.replyBoard(boardDto);
        if (result > 0) {
            resp.sendRedirect("../board/list");
        } else {
            ScriptWriter.alertAndBack(resp,"서버 오류입니다. 다시 시도해주세요.");
        }
    }
}
