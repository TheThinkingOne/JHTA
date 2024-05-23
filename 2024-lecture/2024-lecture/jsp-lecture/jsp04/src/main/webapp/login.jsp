<%@ page import="com.leekiye.jsp04.utility.CookieManager" %><%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-10
  Time: 오전 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String loggedID = CookieManager.readCookie(request,"loggedID");
    String isChecked = "";
    if (!loggedID.equals("")) {
        isChecked = "checked";
    }

%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>로그인창</h2>
<form action = "login-member-process.jsp" method="post">
    <div>
        <label>
            <span>아이디</span>
            <input type="text" value="<%=loggedID%>" placeholder="아이디 입력" name = "userID">
        </label>
    </div>

    <div>
        <label>
            <span>비밀번호</span>
            <input type="password" placeholder="비밀번호 입력" name = "userPW">
        </label>
    </div>
    <div>
        <label>
            <span>로그인 정보 기억하기</span>
            <input type = "checkbox" name="saveID" value= "yes" checked>
        </label>
    </div>
    <%--    항상 중요한건 name = "" 이 부분 => 이거로 백엔드 연동하기 때문 --%>
    <button>입장</button>
    <button type="reset">싫어(취소)</button>
</form>

</body>
</html>
