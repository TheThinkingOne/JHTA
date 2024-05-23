<%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-08
  Time: 오후 4:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Form</title>
</head>
<body>
<h2>Login Form</h2>
    <form method="post" action="/jsp01_2_war_exploded/login-process">
<%--        <input type ="text" name="userName" id="userName"> <br>--%>
        <div><input type ="text" name="userID"> </div>
        <div><input type ="password" name="userPW"> </div>
        <button type="submit">로그인</button>
    </form>
</body>
</html>
