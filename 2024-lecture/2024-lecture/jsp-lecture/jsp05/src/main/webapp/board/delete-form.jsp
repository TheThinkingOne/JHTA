<%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-17
  Time: 오후 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    String deleteNO = request.getParameter("deleteNO");
%>
<%@ include file="../include/header.jsp"%>
    <div class = "container">
        <form action="delete-password-process.jsp" method="post">
            <label for="userPW">글 작성시에 쓴 비밀번호를 입력해주세요</label>
            <input type="password" id="userPW" class="form-control" name="userPW" required>
            <input type="hidden" name="deleteNO" value="${param.deleteNO}">
            <button class="btn btn-primary mt-2">DELETE</button>
        </form>
    </div>


<%@include file="../include/footer.jsp"%>