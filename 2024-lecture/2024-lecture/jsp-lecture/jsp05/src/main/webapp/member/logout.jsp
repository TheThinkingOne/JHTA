<%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-10
  Time: 오후 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    session.invalidate(); // 세션 무효화
    out.println("<script>alert(\"로그아웃 되었습니다, 꺼져!\");location.href=\"../member/login.jsp\";</script>");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
