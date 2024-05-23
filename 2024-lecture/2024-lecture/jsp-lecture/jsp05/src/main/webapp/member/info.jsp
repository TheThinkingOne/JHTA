<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.leekiye.jsp05.connect.JDBCConnect" %>
<%@ page import="com.leekiye.jsp05.connect.JDBCConnectionPool" %>
<%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-10
  Time: 오후 2:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@include file="../include/header.jsp"%>
<%
    String infoID = (String) session.getAttribute("sessionID");

    // db 연결 조회해서 resultSet에 값 담아서 아래쪽에 뿌리기
//    Class.forName("oracle.jdbc.OracleDriver");
//    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","leekiye99","1234");
    JDBCConnectionPool jdbcConnectionPool = new JDBCConnectionPool();
    String sql = "select * from member where userid = ?";
    PreparedStatement pstmt = jdbcConnectionPool.conn.prepareStatement(sql);

    pstmt.setString(1,infoID); // 세션 값을 가져와
    pstmt.executeQuery();

    String infoName = "";
    String infoBirth = "";
    String infoAddress = "";
    String infoEmail = "";

    int no = 0;
    ResultSet rs = pstmt.executeQuery();
    if(rs.next()) {
        no = rs.getInt("no");
        infoName = rs.getString("username");  // getString()안에 있는 건 db 컬럼명(DBeaver)
        infoBirth = rs.getString("birth");
        infoAddress = rs.getString("address");
        infoEmail = rs.getString("email");
    }

%>
<%-- 여기에 개인정보(아이디 같은 개인정보 나오게 하기--%>
<%--    <div>no : <%=no%> </div>--%>
<%--    <div>id : <%=infoID%> </div>--%>
<%--    <div>이름 : <%=infoName%></div>--%>
<%--    <div>생년월일 : <%=infoBirth%></div>--%>
<%--    <div><a href="../member/delete-member.jsp">회원탈퇴</a></div>--%>

<div class="container">
    <table class="table table-striped">
        <tbody>
        <tr>
            <th scope="row">no</th>
            <td><%=no%></td>
        </tr>
        <tr>
            <th scope="row">id</th>
            <td><%=infoID%></td>
        </tr>
        <tr>
            <th scope="row">name</th>
            <td><%=infoName%></td>
        </tr>
        <tr>
            <th scope="row">birth</th>
            <td><%=infoBirth%></td>
        </tr>
        <tr>
            <th scope="row">address</th>
            <td><%=infoAddress%></td>
        </tr>
        <tr>
            <th scope="row">email</th>
            <td><%=infoEmail%></td>
        </tr>
        </tbody>
    </table>
        <a href="delete-member.jsp" class="btn btn-danger">회원탈퇴</a>
</div>



<%@include file="../include/footer.jsp"%>
