package com.leekiye.mybatis.controller.board;

import com.leekiye.mybatis.dao.BoardDao;
import com.leekiye.mybatis.dto.BoardDto;
import com.leekiye.mybatis.dto.MessageDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/board/view")
public class ViewBoard extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int no = 0;
        if (req.getParameter("no")!= null) {
            no = Integer.parseInt(req.getParameter("no"));
        }

        BoardDao boardDao = new BoardDao();
        BoardDto boardDto = boardDao.getBoard(no);
        //System.out.println(boardDto.getSubject());
        req.setAttribute("boardDto",boardDto);

        MessageDto messageDto = new MessageDto("제목","내용");
        req.setAttribute("messageDto",messageDto);

        req.getRequestDispatcher("/WEB-INF/board/view.jsp")
                .forward(req,resp);
    }
}
