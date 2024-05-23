<%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-08
  Time: 오후 3:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int num = Integer.parseInt(request.getParameter("num"));
%>
<html>
<head>
    <title>선택한 구구단 출력</title>
</head>
<body>
    <h2><%=num%>단</h2>
    <ul>
        <% for(int i=1; i<10; i++) {%>
            <li><%=num%>x<%=i%>=<%=num*i%></li>
        <% } %>
    </ul>
</body>
</html>
