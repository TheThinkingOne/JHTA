<%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-13
  Time: 오후 2:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.leekiye.jsp05.utility.CookieManager" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="f" %>
<%-- 보통 core 를 많이 쓴다 --%>
<%
    // null 혹은 ID
    String loggedID = (String)session.getAttribute("sessionID");
    String loggedName = (String)session.getAttribute("sessionName");

    List<String> loggedIdName = new ArrayList<>();
    loggedIdName.add(loggedID);
    loggedIdName.add(loggedName);

%>

<!DOCTYPE html>
<html>
<head>
    <title>Header</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet" >
    <link href="../css/common.css" rel="stylesheet" >
    <link href="../css/sign-in.css" rel="stylesheet">
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<%-- 위가 바로 다음 지도 api --%>
    <script src="../js/bootstrap.bundle.min.js" ></script>
    <script src="../js/jquery-3.7.1.min.js"></script>
</head>
<body>
<div class="container">
    <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
        <div class="col-md-3 mb-2 mb-md-0">
            <a href="/" class="d-inline-flex link-body-emphasis text-decoration-none">
                <svg class="bi" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"></use></svg>
            </a>
        </div>

        <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
            <li><a href="../index/index.jsp" class="nav-link px-2 link-secondary">Home</a></li>
            <li><a href="../member/list-member.jsp" class="nav-link px-2">List</a></li>
            <% if (loggedID != null) { %>
            <li><a href="../board/list.jsp" class="nav-link px-2">Board</a></li>
            <%}%>
            <li><a href="../board/faq.jsp" class="nav-link px-2">FAQs</a></li>
        </ul>

        <% if(loggedID == null) { %>
        <div class="col-md-3 text-end">
            <a href="../member/login.jsp" class="btn btn-outline-primary me-2">Login</a>
            <a href="../member/insert-member.jsp" class="btn btn-primary">Sign-up</a>
        </div>
        <% } else { %>
        <div class="col-md-3 text-end">
            <a href="../member/info.jsp" class="btn btn-outline-primary me-2"><%=loggedName%></a>
            <%--<a href="../member/insert-member.jsp" class="btn btn-primary">Sign-up</a>--%>
        <a href="../member/logout.jsp" class="btn btn-primary">LOGOUT</a>
        </div>
        <% } %>

    </header>
</div>