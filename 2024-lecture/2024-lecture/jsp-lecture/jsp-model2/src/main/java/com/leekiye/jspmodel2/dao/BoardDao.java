package com.leekiye.jspmodel2.dao;

import com.leekiye.jspmodel2.connect.JDBCConnectionPool;
import com.leekiye.jspmodel2.dto.BoardDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDao extends JDBCConnectionPool {
    public int writeBoard(BoardDto writeBoardDto) {
        String sql = "INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, 1, sysdate)";
        int result = 0;

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,writeBoardDto.getSubject());
            pstmt.setString(2,writeBoardDto.getContent());
            pstmt.setString(3,writeBoardDto.getUserID());
            pstmt.setString(4,writeBoardDto.getUserName());
            pstmt.setString(5,writeBoardDto.getPassword());
            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            this.close();
        }
        return result;
    }

    public BoardDto viewBoard(int no) {
        BoardDto boardDto = null;
        String sql = "SELECT * FROM BOARD WHERE NO = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,no);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                boardDto = BoardDto.builder()
                        .no(rs.getInt("no"))
                        .subject(rs.getString("subject"))
                        .content(rs.getString("content"))
                        .hit(rs.getInt("hit"))
                        .regDate(rs.getString("regdate"))
                        .userID(rs.getString("userid"))
                        .userName(rs.getString("username"))
                        .password(rs.getString("password"))
                        .build();
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            this.close();
        }
        return boardDto;
    }

    public List<BoardDto> getBoardList() {
        List<BoardDto> boardList = null;
        // 이런 위와 같은 똑같은 패턴이 반복되니까 프레임워크로 만들 수 있는거임
        String sql = "SELECT * FROM BOARD";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            boardList = new ArrayList<>();
            while (rs.next()) {
                BoardDto boardDto = BoardDto.builder()
                        .no(rs.getInt("NO"))
                        .subject(rs.getString("SUBJECT"))
                        .content(rs.getString("CONTENT"))
                        .hit(rs.getInt("HIT"))
                        .regDate(rs.getString("REGDATE"))
                        .userID(rs.getString("USERID"))
                        .userName(rs.getString("USERNAME"))
                        .password(rs.getString("PASSWORD"))
                        .build();

                boardList.add(boardDto);
                // sql로 받아온 값들을 boardDto 로 받아 처리한 후 boardList에 삽입
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            this.close();
        }

        return boardList;
    }
}
