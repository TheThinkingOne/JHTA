<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String sessionUserID = (String) session.getAttribute("sessionUserID");
%>
<!DOCTYPE html>
<html>
<head>
    <title> JSP - Hello World </title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<%= sessionUserID %>
<%--//    String userID = request.getParameter("userID");--%>
<%--//    String userPW = request.getParameter("userPW");--%>
<%--//    out.println(userID);--%>
<%--//    out.println(userPW);--%>
</body>
</html>