<%@ page import="com.leekiye.jsp05.connect.JDBCConnectionPool" %><%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-17
  Time: 오전 9:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="../include/header.jsp"%>
<%
    // front에서 변수 전달하고 서버에서 받아서 db처리
    int no = Integer.parseInt(request.getParameter("listNO"));
    String strNo = request.getParameter("listNO");
    JDBCConnectionPool jdbcConnectionPool = new JDBCConnectionPool();

    boolean isUpdate = true;
    String visitedCookieValue = CookieManager.readCookie(request, "visitedCookie");
    if (visitedCookieValue.isBlank()) {
        CookieManager.createCookie(response, "visitedCookie", strNo, 60 * 60 * 24);
    } else {
        // 13/12/3/1/2 한번 방문했음
        if(visitedCookieValue.contains(strNo)) {
            isUpdate=false;
        } else {
            isUpdate=true;
            CookieManager.deleteCookie(response,"visitedCookie");
            CookieManager.createCookie(response,"visitedCookie",
                    visitedCookieValue+"/"+strNo,60*60*24);
        }
    }

    if (isUpdate) {
        String updateHitSql = "update board set hit = hit + 1 where no = ?";
        jdbcConnectionPool.pstmt = jdbcConnectionPool.conn.prepareStatement(updateHitSql);
        jdbcConnectionPool.pstmt.setInt(1, no);
        jdbcConnectionPool.pstmt.executeUpdate();
    }

    String sql =  "select * from board where NO = ?";
    jdbcConnectionPool.pstmt = jdbcConnectionPool.conn.prepareStatement(sql);
    jdbcConnectionPool.pstmt.setInt(1,no);

    jdbcConnectionPool.rs = jdbcConnectionPool.pstmt.executeQuery();

%>

<div class="container">
    <h2 class="mt-5 mb-5">VIEW</h2>
    <table class="table table-striped">
        <tbody>
        <% if(jdbcConnectionPool.rs.next()){ %>
        <tr>
            <td>제목</td>
            <td colspan="3"><%=jdbcConnectionPool.rs.getString("subject")%></td>
        </tr>
        <tr>
            <td>글쓴이</td>
            <td colspan="3"><%=jdbcConnectionPool.rs.getString("username")%></td>
        </tr>
        <tr>
            <td>날짜</td>
            <td><%=jdbcConnectionPool.rs.getString("regdate")%></td>
            <td>조회수</td>
            <td><%=jdbcConnectionPool.rs.getInt("hit")%></td>
        </tr>
        <tr>
            <td>내용</td>
            <td colspan="3" class="content">
                <%=jdbcConnectionPool.rs.getString("content")%>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <div class="mt-5 mb-5">
        <a href="../board/write.jsp" class="btn btn-primary">WRITE</a>
        <a href="../board/list.jsp" class="btn btn-primary mx-2">LIST</a>

<%--        로그인한 사람이 자기것만 삭제할 수 있게 처리--%>
        <% if(loggedID!=null &&
                loggedID.equals(jdbcConnectionPool.rs.getString("userid"))) { %>
        <a href="../board/delete.jsp?deleteNO=<%=jdbcConnectionPool.rs.getInt("no")%>" class="btn btn-danger">DEL</a>
               <!-- a href 에서는 ?뒤에 벨류값을 선언, 위의  ?deleteNO 처럼 -->
                <!-- 일반 삭제 -->
            <button class="btn btn-danger" id="btn-form-del">DEL-FORM</button>
            <button class="btn btn-danger" id="btn-form-del-ajax" data-no="<%=jdbcConnectionPool.rs.getInt("no")%>">DEL-AJAX</button>
            <a href="../board/delete-form.jsp?deleteNO=<%=jdbcConnectionPool.rs.getInt("no")%>" class="btn btn-danger" id="">PASSWORD-SEND</a>
<%--        <a href="../board/delete-form.jsp?no=<%=jdbcConnectionPool.rs.getInt("no")%>"
               class="btn btn-danger" id="">PASSWORD-SEND</a>--%>
            <button class="btn btn-danger" id="btn-password-popup">PASSWORD-POPUP</button>
            <a href="../board/list.jsp" class="btn btn-danger">MODIFY</a>
        <% } %>

    </div>

    <div class="modal fade" id="password-modal" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">PASSWORD</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">

                        <label for="userPW">PASSWORD</label>
                        <input type="password" id="userPW" class="form-control mt-2" name="userPW">
                        <input type="hidden" name="no" id="board-no" value="${param.listNO}">

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" id="btn-delete">DELETE</button>
                </div>
            </div>
        </div>
    </div>

    <form action="../board/delete.jsp" method="post" id="del-form">
        <input type = "hidden" name="deleteNO" value="<%=jdbcConnectionPool.rs.getInt("no")%>">
        <!-- input type 안에는 name 이 파라미터가 되는거임 name="deleteNO" 처럼 -->
    </form>

    <script>
        // 폼 삭제 방식
        $("#btn-form-del").on("click", function () {
            $("#del-form").submit();
            // 이렇게 하면 form 을 벗어나 있는 button 에도 데이터 처리 기능을 부여할 수 있음
            // 이게 바로 submit 이다
        });

        // AJAX 삭제
        $("#btn-form-del-ajax").on("click", function () {
            const sendNo = $(this).data("no");
            $.ajax({
                url:"../board/delete-ajax.jsp",
                data: {
                    no: sendNo,
                },
                success:function (data) {
                    if(data.isDelete === "yes") {
                        alert(sendNo + "글이 삭제되었습니다.");
                        location.href="../board/list.jsp";
                    } else {
                        alert(sendNo + "알 수 없는 오류입니다.");
                    }
                }
            })
        });

    </script>

    <% jdbcConnectionPool.close(); %>
</div>

<script>
    let passwordModal = new bootstrap.Modal("#password-modal")
    const passwordModalEL01 = $("#password-modal").get(0);
    const passwordModalEL02 = document.querySelector("#password-modal");
    // jQuery 는 on으로, vanilla 는 addEventListener 를 사용해서 연동해야 한다

    $("#btn-password-popup").on("click",function () {
        passwordModal.show();
    });
    $("#btn-delete").on("click",function () {
        const sendPW = $("#userPW").val();
        const sendNo = $("#board-no").val();
        console.log(sendNo,"===",sendPW);
        $.ajax({
            url:"../board/delete-ajax-popup.jsp",
            data: {
                no: sendNo,
                userPW : sendPW
            },
            success: function (data) {
                console.log(data);
                if (data.isDelete === "yes") {
                    // passwordModal.hide();
                    passwordModalEL02.addEventListener('hidden.bs.modal', function () {
                    });
                    // alert(sendNO + " 삭제완");
                    location.href = "../board/list.jsp";
                } else {
                        passwordModalEL02.addEventListener('hidden.bs.modal', function () {
                        passwordModal.hide();
                    })
                    // alert("에러")
                }
            },
            error: function (err) {
                console.log(err);
            }
        })
    });

</script>


<%@ include file="../include/footer.jsp" %>