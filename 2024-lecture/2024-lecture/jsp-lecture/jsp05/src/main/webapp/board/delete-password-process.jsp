<%@ page import="com.leekiye.jsp05.connect.JDBCConnectionPool" %>
<%@ page import="com.leekiye.jsp05.utility.ScriptWriter" %><%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-17
  Time: 오후 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 여기서 게시글 번호랑 비밀번호가 맞는지 둘 다 체크할거임
    int no = Integer.parseInt(request.getParameter("deleteNO"));
    String userPW = request.getParameter("userPW");

    String sql = "DELETE FROM BOARD WHERE NO = ? AND PASSWORD = ?";
    JDBCConnectionPool jdbcConnectionPool = new JDBCConnectionPool();
    jdbcConnectionPool.pstmt = jdbcConnectionPool.conn.prepareStatement(sql);

    jdbcConnectionPool.pstmt.setInt(1, no);
    jdbcConnectionPool.pstmt.setString(2, userPW);

    int result = jdbcConnectionPool.pstmt.executeUpdate();
    if (result > 0) {
        ScriptWriter.alertAndNext(
                response,no+"번 글이 삭제되었습니다.","../board/list.jsp"
        );
    } else {
        ScriptWriter.alertAndBack(response,"비밀번호 입력이 잘못되었습니다.");
    }


%>