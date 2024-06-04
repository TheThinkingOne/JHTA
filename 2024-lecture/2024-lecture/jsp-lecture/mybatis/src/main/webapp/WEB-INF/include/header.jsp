<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>

    <title>JSP - Hello World</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/common.css" rel="stylesheet">
    <link href="../css/sign-in.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="../js/bootstrap.bundle.min.js"></script>
    <script src="../js/jquery-3.7.1.min.js"></script>


</head>
<body>
<div class="container">
    <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
        <div class="col-md-3 mb-2 mb-md-0">
            <a href="" class="d-inline-flex link-body-emphasis text-decoration-none">
                <svg class="bi" width="40" height="32" role="img" aria-label="Bootstrap">
                    <use xlink:href="#bootstrap"></use>
                </svg>
            </a>
        </div>
        <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
            <li><a href="../index/index" class="nav-link px-2 link-secondary">Home</a></li>
            <li><a href="" class="nav-link px-2">List</a></li>
            <li><a href="../board/list?page=1" class="nav-link px-2">Board</a></li>
            <li><a href="" class="nav-link px-2">FAQs</a></li>
        </ul>

        <c:choose>
            <c:when test="${sessionID eq null}">
                <div class="col-md-3 text-end">
                    <a href="../member/login" class="btn btn-outline-primary me-2">Login</a>
                    <a href="../member/insert" class="btn btn-primary">Sign-up</a>
                </div>
            </c:when>
            <c:otherwise>
                <div class="col-md-3 text-end d-flex align-items-center">
                    <div class="d-inline-block">
                        <c:choose>
                            <c:when test="${not empty profile}">
                                <a href="../member/info?userID=${sessionID}" class="d-block">
                                    <img src="${request.contextPath}/upload/${profile}" class="profile">
                                </a>
                            </c:when>
                            <c:otherwise>
                                <a href="../member/info?userID=${sessionID}" class="d-block">
                                    <img src="../images/defaultusericon.png" class="profile">
                                </a>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <a href="../member/logout" class="btn btn-primary mx-2">LOGOUT</a>
                </div>
            </c:otherwise>
        </c:choose>

    </header>
</div>