<%@ page import="com.leekiye.jsp04.utility.CookieManager" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>'
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<h2> ID : <a href ="info.jsp"><%= session.getAttribute("sessionID") %></a> </h2>
<h2> Name : <%= session.getAttribute("sessionName") %> </h2>
<%-- 로그인 맴버 프로세스 에서 설정한 세션 키값 불러와서 화면에 아이디 이름 노출 --%>
<h2> 어서와요! 기다리고 있었어요! </h2>
<button><a href="logout.jsp">로그아웃</a></button>
<button><a href="login.jsp">로그인</a></button>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>