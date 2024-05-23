<%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-09
  Time: 오전 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>쿠키 설정 페이지</title>
</head>
<body>
    <h1>쿠키 CookieRun</h1>
    <%
        Cookie cookie = new Cookie("myCookie","오감자");
        cookie.setMaxAge(1000*60*24); // 오늘 하루 이 창을 더이상 열지 않겠습니다. 설정
        response.addCookie(cookie);
    %>
</body>
</html>
