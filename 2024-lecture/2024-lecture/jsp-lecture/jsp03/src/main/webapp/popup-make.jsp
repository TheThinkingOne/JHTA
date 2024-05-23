<%@ page import="com.leekiye.jsp03.utility.CookieManager" %><%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-09
  Time: 오전 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String today = request.getParameter("today");
    System.out.println("today=== " + today);
    if(today!=null && today.equals("one")) {
//        Cookie cookie = new Cookie("oneDayCookie","off");
//        cookie.setMaxAge(5); // 오늘 하루 이 창을 더이상 열지 않겠습니다. 설정, 여긴 밀리초 단위 아님, 기본 초임
//        cookie.setPath("/"); // 쿠키는 보통 저장루트 이렇게 함
//        response.addCookie(cookie);
        CookieManager.createCookie(response,"oneDayCookie","off",60*60*24); // 외부 클래스로부터 쿠키 생성
    }
%>
<html>
  <head>
    <title>쿠키 만드는 곳</title>
  </head>
  <body>

  </body>
</html>
