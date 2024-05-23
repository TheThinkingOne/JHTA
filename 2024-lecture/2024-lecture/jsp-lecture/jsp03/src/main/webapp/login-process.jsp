<%@ page import="com.leekiye.jsp03.utility.CookieManager" %><%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-09
  Time: 오후 3:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String userID = request.getParameter("userID");
    String userPW = request.getParameter("userPW");
    String saveID = request.getParameter("saveID");
    // 사용자 아이디, 비번, 아이디 저장 선언
    System.out.println(saveID);
    // 쿠키설정해서 saveID 에 userID  설정(쿠키설정)
    if(userID.equals("emmahardy21") && userPW.equals("1234")) {
        session.setAttribute("sessionUserID",userID);
        // 로그인 성공
        if(saveID!=null && saveID.equals("yes")) {
            // 쿠키 설정
            CookieManager.createCookie(response,"memoID",userID,60*60*24*365);
            // 아이디 저장 후 로그인 성공하면 1년동안 쿠키 기억
            response.sendRedirect("index.jsp");
            // 로그인 성공 후 쿠키 저장하고 index.jsp 사이트로 리다이렉트
        } else {
            CookieManager.deleteCookie(response,"memoID");
            // 아이디 저장 체크박스 해제 하면 저장되어 있던 쿠키 삭제
        }
    } else {
        response.sendRedirect("login.jsp"); // 로그인 실패시 로그인 화면으로 다시 이동
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
