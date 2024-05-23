<%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-08
  Time: 오후 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String userID = request.getParameter("userID02");
    String userPW = request.getParameter("userPW02");
    if(userID.equals("jjang051") && userPW.equals("1234")) {
        // 페이지 바꾸는 방법엔 send redirect 두가지 방법이 있다
        response.sendRedirect("login_success.jsp");
    } else {
        out.println("<script>alert(\"아이디, 비밀번호를 확인해주세요.\");" + "history.back();</script>");
        // history.back() 하면 뒤로 돌아간다
    }
%>

