<%@ page import="com.leekiye.jsp03.utility.CookieManager" %><%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-09
  Time: 오후 2:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
//    String popupRevive = request.getParameter("popupRevive");
//    if (popupRevive.equals("on")) {
//        CookieManager.deleteCookie(response,"oneDayCookie");
//    }
    CookieManager.deleteCookie(response, "oneDayCookie");
    response.sendRedirect("popup-main.jsp");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
