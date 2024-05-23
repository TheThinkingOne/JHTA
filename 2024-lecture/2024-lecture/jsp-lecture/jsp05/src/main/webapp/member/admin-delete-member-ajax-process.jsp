<%@ page import="com.leekiye.jsp05.connect.JDBCConnectionPool" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="com.leekiye.jsp05.utility.ScriptWriter" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.google.gson.Gson" %><%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-16
  Time: 오전 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // history.back()을 하면 refresh 가 같이 발생을 함... 크롬도 막힌거 같다
    String listID = request.getParameter("listID");
    JDBCConnectionPool jdbcConnectionPool = new JDBCConnectionPool();
    String sql = "delete from member where USERID = ?";
    PreparedStatement pstmt = jdbcConnectionPool.conn.prepareStatement(sql);
    pstmt.setString(1,listID);
    int result = pstmt.executeUpdate();
    response.setContentType("application/json; charset=utf-8");
    // id-Check-process.jsp 참고바람
    Map <String,String> resultMap = new HashMap<>();
    if (result > 0) {
////        ScriptWriter.alertAndBack(response,listID+"님이 형장의 이슬이 되었습니다." , "../member/list-member.jsp");
//        ScriptWriter.alertAndBack(response,listID+"님 삭제되었습니다.");
        resultMap.put("isDelete","yes");
    } else {
        resultMap.put("isDelete","no");
    }
    Gson gson = new Gson();
    String returnJson = gson.toJson(resultMap); // json 으로 Gson이 변환해줌
    out.println(returnJson);
%>
