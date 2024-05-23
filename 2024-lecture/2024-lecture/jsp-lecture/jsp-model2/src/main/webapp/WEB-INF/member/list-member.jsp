<%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-21
  Time: 오후 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="../include/header.jsp"%>
    <div class="container">
        <h2 class="mt-5 mb-5">Member List</h2>
        <table class="table table-striped">
            <thead>
<%--                    ListMember 클래스에서 선언한 memberList 라는 이름의 리스트를 불러옴--%>
                    <tr>
                        <th>NO</th>
                        <th>USER NUM</th>
                        <th>ID</th>
                        <th>NAME</th>
                        <th>EMAIL</th>
                        <th>ADDRESS</th>
                    </tr>

            </thead>
            <tbody>
                <c:forEach var="member" items="${memberList}" varStatus="loop">
                    <%-- MemberDao의 listMember 메소드 확인 --%>
                    <%-- varStatus는 반복문 돌 때 그 환경 가르킴 --%>
                    <tr>
                        <td>${loop.count}</td>
                        <td>${member.no}</td>
                        <td><a href="../member/info?userID=${member.userID}">${member.userID}</a></td>
                        <td>${member.userName}</td>
                        <td>${member.email}</td>
                        <td>${member.address}</td>
                        <td><button class= "btn btn-danger btn-delete" data-userid="${member.userID}">DEL</button></td>
                        <!--  -->
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <script>
        $(".btn-delete").on("click",function () {
            const sendUserID = $(this).data("userid");
            $.ajax({
                url:"../member/delete-ajax",
                data: {
                    userID: sendUserID
                },
                method:"get",
                success:function (data) {
                    if(data.isDelete==="yes") {
                        // 삭제 구현
                        parent.remove();
                    }
                }
            })
        })

    </script>
<%@ include file="../include/footer.jsp"%>