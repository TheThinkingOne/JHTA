<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.Connection" %><%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-10
  Time: 오전 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 클래스 동적 로딩
    Class.forName("oracle.jdbc.OracleDriver");
    // 오라클 드라이버 로딩해서 연결
    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","leekiye99","1234");
    // conn.setAutoCommit(false); 이렇게 하면 DB 커밋 수동으로 해줘야함
    System.out.println("db connect");
    String sql = "insert into MEMBER values('TranQuinnMai','5678','트란퀸마이')";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    int result = pstmt.executeUpdate();
    System.out.println(result);
    // 위는 오라클 연결
%>

<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
