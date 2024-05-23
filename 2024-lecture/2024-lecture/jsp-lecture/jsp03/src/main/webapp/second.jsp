<%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-09
  Time: 오전 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3> 나는 second.jsp 이지만 주소는 pageContext.jsp 입니다. </h3>
    <h1> <%=pageContext.getAttribute("pageContextString") %> </h1>
    <h1> <%=request.getAttribute("requestString") %> </h1>
    <h1> <%=session.getAttribute("sessionString") %> </h1>
    <h1> <%=session.getAttribute("sessionPerson") %> </h1>
<%-- Person 클래스에 toString 생성자 정의해서 sessionPerson이 해시값이 아닌 toString 에서 정의한 대로 보여진다 --%>
<%-- forward 방식일때만 request 로 넘아간다   --%>
</body>
</html>
