<%@ page import="com.leekiye.jsp05.connect.JDBCConnectionPool" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ include file="../include/header.jsp" %> <%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-16
  Time: 오후 3:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    JDBCConnectionPool jdbcConnectionPool = new JDBCConnectionPool();
    //String sql = "SELECT * FROM MEMBER WHERE userID = 'EmmaHardy21' and userPW = '1234'";
    int NO = Integer.parseInt(request.getParameter("listNO"));
    String sql = "SELECT * FROM BOARD WHERE NO =?";
    PreparedStatement pstmt = jdbcConnectionPool.conn.prepareStatement(sql);
    pstmt.setInt(1,NO);
    ResultSet rs = pstmt.executeQuery();

    // 제목 유저명 작성일 내용
    String subject = "";
    String userName = "";
    String regDate = "";
    String content = "";
//    String content = request.getParameter("writeContent");

    if(rs.next()) {
        subject = rs.getString("SUBJECT");
        userName = rs.getString("USERNAME");
        regDate = rs.getString("REGDATE");
        content = rs.getString("CONTENT");
    }
%>
<%--<%--%>
<%--    JDBCConnectionPool jdbcConnectionPool = new JDBCConnectionPool();--%>
<%--    String sql = "SELECT NO, SUBJECT, USERNAME, REGDATE, CONTENT FROM BOARD";--%>
<%--    PreparedStatement pstmt = jdbcConnectionPool.conn.prepareStatement(sql);--%>
<%--    ResultSet rs = pstmt.executeQuery();--%>
<%--%>--%>

<script>
    // 구글링 해서 가져온 코드
    // history.back() reload 이수 해결 코드 -> 크롬은 history.back() 막아놧음 병신
    if (document.addEventListener) {
        window.addEventListener("pageshow", function (event) {
            if (event.persisted || window.performance && window.performance.navigation.type == 2) {
                location.reload();
            }
        }, false);
    }
</script>

<div class="container">
<%--    제목 유저명 작성일 내용 순으로--%>
    <div class="mb-3">
        <label class="form-label">제목</label>
        <label class="form-label"><%=subject%></label>
<%--        <input type="text" class="form-control" id="userName" name="writeUserName">--%>
    </div>
    <div class="mb-3">
        <label class="form-label">글쓴이</label>
        <label class="form-label"><%=userName%></label>
    </div>
    <div class="mb-3">
        <label class="form-label">작성일자</label>
        <label class="form-label"><%=regDate%></label>
    </div>
    <div class="mb-3">
        <label class="form-label">내용</label>
        <textarea name="writeContent" id="content" rows="8" class="form-control" readonly><%=content%></textarea>
    </div>
</div>




<%--    <table class="table table-borderless">--%>
<%--        <thead>--%>
<%--            <tr>--%>
<%--                <th>subject</th>--%>
<%--                <th>username</th>--%>
<%--                <th>regdate</th>--%>
<%--                <th>content</th>--%>
<%--            </tr>--%>
<%--        </thead>--%>
<%--        <tbody>--%>
<%--            <%  while(rs.next()) { %>--%>
<%--            <tr>--%>
<%--                <td><%=rs.getString("SUBJECT")%></td>--%>
<%--                <td><%=rs.getString("USERNAME")%></td>--%>
<%--                <td><%=rs.getString("REGDATE")%></td>--%>
<%--                <td><%=rs.getString("CONTENT")%></td>--%>
<%--            </tr>--%>
<%--            <%}%>--%>
<%--        </tbody>--%>
<%--    </table>--%>