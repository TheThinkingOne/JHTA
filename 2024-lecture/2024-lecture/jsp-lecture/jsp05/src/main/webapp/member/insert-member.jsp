<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="../include/header.jsp" %>
<div class="container">
    <h2>회원가입</h2>
    <script src="../js/jquery-3.7.1.min.js"></script>
    <form action="insert-member-process.jsp" method="post">
        <div class="mb-3">
            <label for="userID" class="form-label">USER ID</label>
            <input type="text" class="form-control" id="userID" placeholder="user id" name="userID">
            <button type="button" id="btn-duplicate" class="btn btn-dark mt-2">아이디 중복 체크</button>
            <button type="button" id="btn-cancelID" class="btn btn-dark mt-2">취소</button>
        </div>

        <div class="mb-3">
            <label for="userPW" class="form-label">PASSWORD</label>
            <input type="password" class="form-control" id="userPW" placeholder="password" name="userPW">
            <div class="invalid-feedback"></div>
        </div>
        <div class="mb-3">
            <label for="confirmPW" class="form-label">PASSWORD CONFIRM</label>
            <input type="password" class="form-control" id="confirmPW" placeholder="password" name="userConfirmPW">
        </div>

        <div class="mb-3">
            <label for="userName" class="form-label">USER NAME</label>
            <input type="text" class="form-control" id="userName" placeholder="user name" name="userName">
        </div>

        <div class="mb-3">
            <label for="userEmail" class="form-label">USER EMAIL</label>
            <input type="email" class="form-control" id="userEmail" placeholder="user Email" name="userEMAIL">
        </div>

        <div class="mb-3">
            <label for="birth" class="form-label">BIRTH</label>
            <input type="date" class="form-control" id="birth" placeholder="select birth day" name="userBirth">
        </div>

        <div class="mb-3">
            <label for="postCode" class="form-label">POST CODE</label>
            <div class="row">
                <div class="col auto"><input type="text" class="form-control" id="postCode" placeholder="Enter your Postcode" name="userPOSTCODE" readonly></div>
                <div class="col auto"><button type="button" id="btn-postcode" class="btn btn-dark">우편번호 찾기</button></div>
            </div>
        </div>

        <div class="mb-3">
            <label for="address" class="form-label">ADDRESS</label>
            <input type="text" class="form-control" id="address" placeholder="Enter your Address." name="userADDRESS" readonly>
        </div>

        <div class="mb-3">
            <label for="detailAddress" class="form-label">DETAIL ADDRESS</label>
            <input type="text" class="form-control" id="detailAddress" placeholder="Detail Address" name="userDETAILADDRESS">
        </div>

        <div>
            <button class="btn btn-primary" id="btn-signIN">SIGN IN</button>
            <button class="btn btn-outline-primary" id="btn-reset" type="reset">RESET</button>
        </div>
    </form>
</div>
<script>

    let isIdChecked = false;
    //ajax - jquery axios fetch
    $("#btn-duplicate").on("click",function(){
        $.ajax({
            url:"id-Check-process.jsp",
            data: {
                userID:$("#userID").val()
            },
            method:"post",
            success:function(data) {
                console.log(data);
                if(data.count>0) {
                    alert("이미 등록되어 있는 아이디 입니다. 다른 아이디를 입력해주세요.");
                    $("#userID").val("");
                    $("#userID").focus();
                } else {
                    const used = confirm("사용 가능한 아이디입니다. 사용하시겠습니까?");
                    if(used) {
                        $("#userID").attr("readonly",true);
                        isIdChecked = true;
                    } else {
                        $("#userID").val("");
                        $("#userID").focus();
                    }
                }
            },
            fail:function(error) {
                console.log(error);
            }

        });
    });

    // $("#btn-signIN").on("click",function () {
    //     let userID = $("#userID").val().trim();
    //     let userPW = $("#userPW").val().trim();
    //     let userName = $("#userName").val().trim();
    //     let birth = $("#birth").val().trim();
    //
    //     if (userID === '' || userPW === '' || userName === '' || birth === '') {
    //         alert("모든 필수 입력란을 채워주세요.");
    //         return false; // 전송을 중지합니다.
    //     }
    // });

    $("#btn-cancelID").on("click",function () {
        // 취소 버튼 누르면 아이디에 설정된 readonly 초기화 및 비우기
        const resetID = confirm("취소하시겠습니까?");
        if(resetID) {
            $("#userID").val(""); // 적혀있는 값 비우기
            $("#userID").attr("readonly",false) // readonly 속성 해제
            isIdChecked = false;
        }
    });

    $("#btn-reset").on("click",function () {
        // 리셋버튼 누르면 아이디에 설정된 readonly 도 초기화
        const resetConfirm = confirm("작성 중인 정보를 초기화 하시겠습니까?");
        if(resetConfirm) {
            $("#userID").attr("readonly",false);
        }
    });

    $("#confirmPW").on("keyup",function (e) {
       console.log("키를 눌렀다가 땠습니다.");
       if ($("#userPW").val() != $("#confirmPW").val()) {
           $(".invalid-feedback").text("password가 맞지 않습니다.")
           $(".invalid-feedback").show();
       } else {
           $(".invalid-feedback").text("");
           $(".invalid-feedback").hide();
       }
    });

    // 필수 입력값들 입력 검증 ajax
    // $("btn-signIN").on("click",function () {
    //     if($("#userID").val().trim()==="") {
    //         alert("id는 필수 입력 사항입니다.")
    //         $("#userID").focus();
    //         return false;
    //     }
    //     if(!isIdChecked) {
    //         alert("아이디 중복 확인 해주세요.")
    //         $("#userID").focus();
    //         return false;
    //     }
    //     if($("#userPW").val().trim()==="") {
    //         alert("비밀번호는 필수 입력 사항입니다.")
    //         $("#userPW").focus();
    //         return false;
    //     }
    //     if($("#userName").val().trim()==="") {
    //         alert("이름은 필수 입력 사항입니다.")
    //         $("#userName").focus();
    //         return false;
    //     }
    //     if($("#userEmail").val().trim()==="") {
    //         alert("이메일은 필수 입력 사항입니다.")
    //         $("#userEmail").focus();
    //         return false;
    //     }
    //     if($("#birth").val().trim()==="") {
    //         alert("생년월일은 필수 입력 사항입니다.")
    //         $("#birth").focus();
    //         return false;
    //     }
    //     if($("#postCode").val().trim()==="") {
    //         alert("우편번호는 필수 입력 사항입니다.")
    //         $("#postCode").focus();
    //         return false;
    //     }
    //     if($("#address").val().trim()==="") {
    //         alert("주소는 필수 입력 사항입니다.")
    //         $("#address").focus();
    //         return false;
    //     }
    //     if($("#detailAddress").val().trim()==="") {
    //         alert("상세주소는 필수 입력 사항입니다.")
    //         $("#detailAddress").focus();
    //         return false;
    //     }
    //     if($("#userPW"),val() != $("#confirmPW")) {
    //         alert("비밀번호를 다시 확인해주세요.")
    //         $("#confirmPW").focus();
    //         return false;
    //     }
    // });
    $("#btn-signIN").on("click", function () {
        let userID = $("#userID").val().trim();
        let userPW = $("#userPW").val().trim();
        let userName = $("#userName").val().trim();
        let userEmail = $("#userEmail").val().trim();
        let birth = $("#birth").val().trim();
        let postCode = $("#postCode").val().trim();
        let userAddress = $("#address").val().trim();
        let userDetailAddress = $("#detailAddress").val().trim();

        // 아이디 중복 체크 여부 확인
        if (!isIdChecked) {
            alert("아이디 중복 확인을 해주세요.");
            return false; // 회원가입을 중단합니다.
        }

        // 필수 입력란 중 빈 필드가 있는지 확인
        if (userID === '' || userPW === '' || userName === '' || userEmail === '' || birth === '' || postCode === '' || userAddress === '' || userDetailAddress === '') {
            alert("모든 필수 입력란을 채워주세요.");
            return false; // 회원가입을 중단합니다.
        }

        // 비밀번호 확인
        let confirmPW = $("#confirmPW").val().trim();
        if (userPW !== confirmPW) {
            alert("비밀번호를 다시 확인해주세요.");
            return false; // 회원가입을 중단합니다.
        }

        // 모든 검증이 완료되면 폼을 제출합니다.
        $("form").submit();
    });

    $("#btn-postcode").on("click", function () {
        makePost();
    });


    function makePost() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                let addr = ''; // 주소 변수
                let extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    // document.getElementById("sample6_extraAddress").value = extraAddr;
                    //$("#detailAddress").val(extraAddr);

                } else {
                    //document.getElementById("sample6_extraAddress").value = '';
                    //$("#detailAddress").val("");
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                // document.getElementById('sample6_postcode').value = data.zonecode;
                $("#postCode").val(data.zonecode);
                $("#address").val(addr);
                // document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                $("#detailAddress").focus();
                //document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }

    // 아이디 중복체크가 되지 않으면 데이터가 넘어가지 않게 하기
    // Password와 Password Confirm 이 같지 않으면 데이터 못 넘어가게 하기

</script>
<%@ include file="../include/footer.jsp"%>