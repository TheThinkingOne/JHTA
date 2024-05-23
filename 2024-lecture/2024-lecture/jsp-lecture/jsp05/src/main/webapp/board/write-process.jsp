<%@ page import="com.leekiye.jsp05.connect.JDBCConnectionPool" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="com.leekiye.jsp05.utility.ScriptWriter" %><%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-16
  Time: 오후 3:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String userID = request.getParameter("writeUserID");
    String userName = request.getParameter("writeUserName");
    String subject = request.getParameter("writeSubject");
    String content = request.getParameter("writeContent");
    String userPW = request.getParameter("writePassword");

    JDBCConnectionPool jdbcConnectionPool = new JDBCConnectionPool();
    String sql = "INSERT INTO BOARD VALUES(board_seq.nextval,?,?,?,?,?,1,SYSDATE)";
    PreparedStatement pstmt = jdbcConnectionPool.conn.prepareStatement(sql);

    jdbcConnectionPool.pstmt.setString(1,subject);
    jdbcConnectionPool.pstmt.setString(2,content);
    jdbcConnectionPool.pstmt.setString(3,userID);
    jdbcConnectionPool.pstmt.setString(4,userName);
    jdbcConnectionPool.pstmt.setString(5,userPW);

    int result = pstmt.executeUpdate();
    if (result>0) {
        ScriptWriter.alertAndNext(response,"게시물이 작성 되었습니다","../board/list.jsp");
    } else {
        ScriptWriter.alertAndBack(response,"오류입니다. 다시 시도해주세요.");
    }
%>

