<%@ page import="java.time.LocalDate" %><%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-08
  Time: 오후 2:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    LocalDate now = LocalDate.now();
    int year = now.getYear();
    int age = Integer.parseInt(request.getParameter("age"));
    if (year-age>=18) {
        response.sendRedirect("adult_ok_lecture.jsp");
    } else {
        out.println("<script>alert(\"성인만 입장 가능..\");history.back();</script>");
    }
%>
