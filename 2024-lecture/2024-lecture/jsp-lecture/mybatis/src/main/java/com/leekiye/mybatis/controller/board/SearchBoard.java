package com.leekiye.mybatis.controller.board;

import com.leekiye.mybatis.dao.BoardDao;
import com.leekiye.mybatis.dto.BoardDto;
import com.leekiye.mybatis.dto.SearchDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/board/search")
public class SearchBoard extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("search");
        String searchWord = req.getParameter("searchWord");

        SearchDto searchDto = SearchDto.builder()
                .search(search)
                .searchWord(searchWord)
                .build();

        BoardDao boardDao = new BoardDao();
        List<BoardDto> boardList = boardDao.searchBoard(searchDto);
        System.out.println("boardList 사이즈 = " + boardList.size());

        int total = boardDao.getSearchBoardTotal(searchDto);
        req.setAttribute("boardList", boardList);
        req.setAttribute("total", total);

        RequestDispatcher dispatcher = req.getRequestDispatcher("WEB/INF/board/search-list.jsp");
        dispatcher.forward(req, resp);

    }
}
