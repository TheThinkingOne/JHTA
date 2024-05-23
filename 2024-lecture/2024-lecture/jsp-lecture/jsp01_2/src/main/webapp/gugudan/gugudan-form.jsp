<%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-08
  Time: 오후 3:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>구구단 폼</title>
</head>
<body>
    <form action="gugudan-result.jsp" method="get">
        <h2>몇단 할지 선택</h2>
        <select name="num">
            <% for (int i=2; i<=19; i++) { %>
                <option value="<%=i%>"><%=i%>단</option>
            <% } %>
        </select>
        <button>운명의 수레바퀴</button>
    </form>
</body>
</html>
