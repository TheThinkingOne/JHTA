<%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-22
  Time: 오후 4:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="../include/header.jsp"%>
<div class="container">
    <h2 class="mt-5 mb-5">비밀번호 변경하기</h2>
    <form action="../member/password-change-info" method="post" id="password-change-form">
        <div class="mb-3">
            <label for="currentPW" class="form-label">Current Password</label>
            <input type="password" class="form-control" id="currentPW" placeholder="현재 비밀번호" name="currentPW">
        </div>
        <div class="mb-3">
            <label for="newPW" class="form-label">Change Password</label>
            <input type="password" class="form-control" id="newPW" placeholder="새 비밀번호" name="newPW">
            <div class="invalid-feedback" id="feedbackPW"></div>
        </div>
        <div class="mb-3">
            <label for="newPWConfirm" class="form-label">Change Password Confirm</label>
            <input type="password" class="form-control" id="newPWConfirm" placeholder="새 비밀번호 확인" name="newPWConfirm">
            <div class="invalid-feedback" id="feedbackConfirmPW"></div>
        </div>
        <input type="hidden" name="userID" value="${sessionMemberDto.userID}">
        <button class="btn btn-primary w-100 py-2 mt-2" id="btn-send">비밀번호 변경하기</button>
    </form>
</div>


<script>
    // $("#feedbackPWd").on("keyup",function (e) {
    //     if($("#currentPW").val() != $("#newPW").val()) {
    //         $(".feedbackPW").text("새 비밀번호가 기존의 비밀번호와 일치합니다.")
    //         $(".feedbackPW").show();
    //     } else {
    //         $(".feedbackPW").text("");
    //         $(".feedbackPW").hide();
    //     }
    // });
    //
    // $("#newPWConfirm").on("keyup",function (e) {
    //     if($("#newPW").val() != $("#newPWConfirm").val()) {
    //         $(".feedbackConfirmPW").text("새 비밀번호를 다시 확인해주세요.")
    //         $(".feedbackConfirmPW").show();
    //     } else {
    //         $(".feedbackConfirmPW").text("");
    //         $(".feedbackConfirmPW").hide();
    //     }
    // });

</script>
<%--<script>--%>
<%--    $(document).ready(function() {--%>
<%--        $("#newPW").on("keyup", function (e) {--%>
<%--            if ($("#currentPW").val() === $("#newPW").val()) {--%>
<%--                $("#feedbackPW").text("새 비밀번호가 기존의 비밀번호와 일치합니다.");--%>
<%--                $("#feedbackPW").show();--%>
<%--            } else {--%>
<%--                $("#feedbackPW").text("");--%>
<%--                $("#feedbackPW").hide();--%>
<%--            }--%>
<%--        });--%>

<%--        $("#newPWConfirm").on("keyup", function(e) {--%>
<%--            if ($("#newPW").val() !== $("#newPWConfirm").val()) {--%>
<%--                $("#feedbackConfirmPW").text("새 비밀번호를 다시 확인해주세요.");--%>
<%--                $("#feedbackConfirmPW").show();--%>
<%--            } else {--%>
<%--                $("#feedbackConfirmPW").text("");--%>
<%--                $("#feedbackConfirmPW").hide();--%>
<%--            }--%>
<%--        });--%>
<%--    });--%>
<script>
    let isPasswordValid = false;
    $("#newPWConfirm").on("keyup",function () {
        if($("#newPW").val() != $(this).val()) {
            console.log("다릅니다")
            $(".invalid-feedback").show();
            $(".invalid-feedback").text("password가 같지 않습니다");
            isPasswordValid = false;
        } else {
            console.log("같습니다")
            $(".invalid-feedback").hide();
            $(".invalid-feedback").text("");
            isPasswordValid=true;
        }
    });

    $("btn-send").on("click",function () {
        if(isPasswordValid) {
            $("#password-change-form").submit();
        } else {
            alert("새 비밀번호를 다시 확인해주세요.")
            return false;
        }
    });


</script>

<%@include file="../include/footer.jsp" %>