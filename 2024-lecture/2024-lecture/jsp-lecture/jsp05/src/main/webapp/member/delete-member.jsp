<%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-10
  Time: 오후 2:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="../include/header.jsp" %>
<div class="container">
    <form action="delete-member-process.jsp" method="post">
        <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">비밀번호를 입력하면 탈퇴처리 됩니다.</label>
            <input type="password" class="form-control" id="exampleFormControlInput1" placeholder="password" name="deletePW">
        </div>
        <input type="hidden" name="deleteID" value="<%=session.getAttribute("sessionID")%>">
        <img class="mb-4" src="../images/AREYOUSURE.jpg" alt="" width="100" height="100">
        <label for="exampleFormControlInput1" class="form-label">정말 도망칠거야..?</label>
        <p></p>
        <button class="btn btn-danger">회원탈퇴</button>
    </form>
</div>
<script>
    

</script>
<%@ include file="../include/footer.jsp" %>

