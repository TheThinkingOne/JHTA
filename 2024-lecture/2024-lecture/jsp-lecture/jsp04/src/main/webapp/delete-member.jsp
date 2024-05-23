<%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-10
  Time: 오후 2:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action = "delete-member-process.jsp">
        <input type="hidden" placeholder="아이디 확인" name="userID"
               value="<%=session.getAttribute("sessionID")%>"> <br>
        <input type="password" placeholder="비밀번호 확인" name="userPW"> <br>
        <button>회원탈퇴</button>
    </form>

</body>
</html>
