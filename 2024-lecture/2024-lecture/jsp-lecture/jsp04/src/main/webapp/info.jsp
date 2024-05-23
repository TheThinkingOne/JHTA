<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-10
  Time: 오후 2:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String infoID = (String) session.getAttribute("sessionID");

    // db 연결 조회해서 resultSet에 값 담아서 아래쪽에 뿌리기
    Class.forName("oracle.jdbc.OracleDriver");
    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","leekiye99","1234");
    String sql = "select * from member where userid = ?";
    PreparedStatement pstmt = conn.prepareStatement(sql);

    pstmt.setString(1,infoID); // 세션 값을 가져와
    pstmt.executeQuery();

    String infoName = "";
    String infoBirth = "";
    int no = 0;
    ResultSet rs = pstmt.executeQuery();
    if(rs.next()) {
        no = rs.getInt("no");
        infoName = rs.getString("username");  // getString()안에 있는 건 db 컬럼명(DBeaver)
        infoBirth = rs.getString("birth");
    }

%>
<html>
<head>
    <title>개인정보</title>
</head>
<body>
<%-- 여기에 개인정보(아이디 같은 개인정보 나오게 하기--%>
    <div>no : <%=no%> </div>
    <div>id : <%=infoID%> </div>
    <div>이름 : <%=infoName%></div>
    <div>생년월일 : <%=infoBirth%></div>
    <div><a href="delete-member.jsp">회원탈퇴</a></div>
</body>
</html>
