<%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-10
  Time: 오전 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>회원가입</h2>
    <form action = "insert-member-process.jsp" method="post">
        <div>
            <label>
                <span>아이디</span>
                <input type="text" placeholder="아이디 입력" name = "userID">
            </label>
        </div>

        <div>
            <label>
                <span>비밀번호</span>
                <input type="password" placeholder="비밀번호 입력" name = "userPW">
            </label>
        </div>
<%--    항상 중요한건 name = "" 이 부분 => 이거로 백엔드 연동하기 때문 --%>
        <div>
            <label>
                <span>이름</span>
                <input type="text" placeholder="성함을 입력해주세요" name = "userName">
            </label>
        </div>

        <div>
            <label>
                <span>생년월일<span>
                <input type="date" placeholder="생년월일을 입력해주세요" name = "birthday">
            </label>
        </div>

        <button>너 내 동료가 되라</button>
        <button type="reset">싫어(취소)</button>
    </form>
</body>
</html>
