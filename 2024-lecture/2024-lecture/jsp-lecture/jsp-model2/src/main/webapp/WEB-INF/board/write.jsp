<%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-24
  Time: 오전 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>'
<%@ include file="../include/header.jsp"%>
<div class="container">
    <h2 class="mt-5 mb-5">글쓰기</h2>
    <form action="../board/write" method="post">
        <%--<div class="mb-3 bli">
            <label for="userID" class="form-label">USER ID</label>
            <input type="text" class="form-control" id="userID" placeholder="user id" name="userID" value="${loggedID}" readonly>
        </div>--%>
        <input type="hidden" name="userID" value="${sessionScope.sessionMemberDto.userID}">
        <div class="mb-3">
            <label for="userName" class="form-label">USER NAME</label>
            <input type="text" class="form-control" id="userName" placeholder="user name" name="userName">
        </div>
        <div class="mb-3">
            <label for="subject" class="form-label">SUBJECT</label>
            <input type="text" class="form-control" id="subject" placeholder="제목을 쓰세요" name="subject">
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">PASSWORD</label>
            <input type="password" class="form-control" id="password" placeholder="password" name="password">
        </div>

        <div class="mb-3">
            <label for="content" class="form-label">CONTENT</label>
            <textarea name="content" id="content" placeholder="내용을 입력하세요." rows="8" class="form-control"></textarea>
        </div>
        <div>
            <button class="btn btn-primary" id="btn-sign">CONFIRM</button>
            <button class="btn btn-secondary" type="reset">RESET</button>
        </div>
    </form>
</div>

<script src="https://cdn.ckeditor.com/ckeditor5/41.4.2/classic/ckeditor.js"></script>
<script>
    ClassicEditor
        .create( document.querySelector( '#content' ), {
            ckfinder: {
                uploadUrl:"../board/upload", // 파일 처리 하려면 서블릿 하나 더 만들어야 함
            }
        })
        .catch( error => {
            console.error( error );
        });
    $.ajax({
        url:"../board/upload",
        success:function (data) {
            // 파일 업로드 시에 success
            console.log(data);
            // 이미지가 어디에 저장되었는지 경로를 알려주어야 한다.
        }
    })
</script>


</script>


<%@ include file="../include/footer.jsp" %>

