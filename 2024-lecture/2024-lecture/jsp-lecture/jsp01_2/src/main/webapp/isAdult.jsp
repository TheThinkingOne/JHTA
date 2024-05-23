<%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-08
  Time: 오후 2:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int age = Integer.parseInt(request.getParameter("age"));
    if(age >= 18) {
        out.println("<script>alert(\"당신은 성인입니다\");</script>");
    } else out.println("<script>alert(\"당신은 미성년자 입니다\");</script>");
%>


</body>
</html>
