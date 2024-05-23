<%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-09
  Time: 오전 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>쿠키 확인용 페이지</title>
</head>
<body>
    <h2> 서버에 저장 => request, session 거의 둘 중 하나 사용 </h2>
    <h2> 클라이언트에 저장할거면 주로 cookie 를 이용 </h2>
<%-- 클라이언트에 저장하면 서버 용량을 차지 안함, 서버 해킹되도 클라이언트에 있는 정보는 안털림 --%>
<%-- 근데 사용자가 삭제해버릴 수 있음 --%>
<%-- 요즘엔 로그인할때 토큰 발급을 하는데 이 토큰을 클라이언트 쿠키에 저장해서 이용함 --%>
    <%
        Cookie confirmCookies[] = request.getCookies();
        for (int i=0; i<confirmCookies.length; i++) {
            out.println(confirmCookies[i].getName() + ":" + confirmCookies[i].getValue());
        }
    %>
</body>
</html>
