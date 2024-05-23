<%@ page import="com.leekiye.jsp05.connect.JDBCConnectionPool" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="com.leekiye.jsp05.utility.ScriptWriter" %><%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-16
  Time: 오전 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // DAO(Database Access Object) / DTO(Database Transfer Object)
    // history.back()을 하면 refresh 가 같이 발생을 함... 크롬도 막힌거 같다
    String listID = request.getParameter("listID");
    JDBCConnectionPool jdbcConnectionPool = new JDBCConnectionPool();
    String sql = "delete from member where USERID = ?";
    PreparedStatement pstmt = jdbcConnectionPool.conn.prepareStatement(sql);
    pstmt.setString(1,listID);
    int result = pstmt.executeUpdate();
    if (result > 0) {
//        ScriptWriter.alertAndBack(response,listID+"님이 형장의 이슬이 되었습니다." , "../member/list-member.jsp");
        ScriptWriter.alertAndBack(response,listID+"님 삭제되었습니다.");
    }
%>
