package com.leekiye.mybatis.dao;

import com.leekiye.mybatis.dto.BoardDto;
import com.leekiye.mybatis.dto.PageDto;
import com.leekiye.mybatis.dto.SearchDto;
import com.leekiye.mybatis.mybatis.MybatisConnectionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class BoardDao {
    public BoardDto getBoard(int no) {
        BoardDto boardDto = null;
        SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
        boardDto = sqlSession.selectOne("getBoard",no);
        sqlSession.commit();
        sqlSession.close();
        return boardDto;
    }

    public List<BoardDto> getBoardList(Map<String,Integer> pageMap) {
        List<BoardDto> boardList = null;
        SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
        boardList = sqlSession.selectList("getBoardList", pageMap);
        sqlSession.commit();
        sqlSession.close();
        return boardList;
    }

    public List<BoardDto> getBoardList(PageDto pageDto) {
        List<BoardDto> boardList = null;
        SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
        boardList = sqlSession.selectList("getBoardList", pageDto);
        sqlSession.commit();
        sqlSession.close();
        return boardList;
    }

    public int getBoardTotal() {
        int total = 0;
        SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
        total = sqlSession.selectOne("getBoardTotal");
        sqlSession.commit();
        sqlSession.close();

        return total;

    }

    public int deleteBoard(BoardDto boardDto) {
        int result = 0;
        SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
        result = sqlSession.delete("deleteBoard", boardDto);

        sqlSession.commit();
        sqlSession.close();
        return result;
    }

    public List<BoardDto> searchBoard(SearchDto searchDto) {
        List<BoardDto> boardList = null;
        SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
        boardList = sqlSession.selectList("searchBoard", searchDto); // board.xml 에서 select id = "~~" 안에 있는 걸 파라미터로 받아옴
        sqlSession.commit();
        sqlSession.close();
        return boardList;
    }

    public int getMaxRegroup() {
        int result = 0;
        SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
        result = sqlSession.selectOne("getMaxRegroup");
        sqlSession.commit();
        sqlSession.close();
        return result;
    }

    public int writeBoard(BoardDto boardDto) {
        int result = 0;
        SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
        result = sqlSession.insert("writeBoard",boardDto);

        sqlSession.commit();
        sqlSession.close();
        return result;
    }

    public int updateRelevel(BoardDto boardDto) {
        int result = 0;
        SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
        result = sqlSession.update("updateRelevel",boardDto);
        sqlSession.commit();

        sqlSession.close();
        return result;
    }

    public int replyBoard(BoardDto boardDto) {
        int result = 0;
        SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
        result = sqlSession.insert("replyBoard", boardDto);

        sqlSession.commit();
        sqlSession.close();
        return result;
    }

    public int deleteAllBoard(int[] noArray) {
        int result = 0;
        SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
        result = sqlSession.delete("deleteAllBoard", noArray);
        if(noArray.length==result) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return result;
    }

    public int getSearchBoardTotal(SearchDto searchDto) {
        int result = 0;
        SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
        result = sqlSession.selectOne("getSearchBoardTotal", searchDto);

        sqlSession.commit();
        sqlSession.close();
        return result;
    }

}
