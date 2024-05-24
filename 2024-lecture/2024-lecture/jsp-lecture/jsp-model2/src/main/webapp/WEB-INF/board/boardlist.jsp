<%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-24
  Time: 오후 2:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="../include/header.jsp"%>
<div class="container">
    <h2 class="mt-5 mb-5">글쓰기</h2>
    <table class="table table-striped">
        <colgroup>
            <col style="width:80px">
            <col>
            <col style="width:150px">
            <col style="width:80px">
            <col style="width:150px">
        </colgroup>

        <thead>
            <tr>
                <th>NO</th>
                <th>SUBJECT</th>
                <th>WRITER</th>
                <th>HIT</th>
                <th>DATE</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${boardList}" var="boardDto" varStatus="loop">
                <tr>
                    <td>${loop.count}</td>
                    <td><a href="../board/view?no=${boardDto.no}">${boardDto.subject}"</a></td>
                    <!-- 제목에 링크 달기 -->`
                    <td>${boardDto.userName}</td>
                    <td>${boardDto.hit}</td>
                    <td>
                            <%--${boardDto.regDate}--%>
                        <fmt:parseDate value="${boardDto.regDate}" var="changeRegDate" pattern="yyyy-MM-dd"/>
                        <fmt:formatDate value="${changeRegDate}" pattern="YYYY년MM월DD일"/>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="mt-5">
        <a href="../board/write" class="btn btn-primary">WRITE</a>
    </div>
</div>

<%@ include file="../include/footer.jsp"%>