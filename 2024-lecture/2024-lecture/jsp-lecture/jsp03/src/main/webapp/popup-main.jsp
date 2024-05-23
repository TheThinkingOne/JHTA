<%@ page import="com.leekiye.jsp03.utility.CookieManager" %><%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-09
  Time: 오전 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

//    Cookie cookies[] = request.getCookies();
//    String cookieValue = "on";
//    for (int i=0; i<cookies.length; i++) {
//        Cookie cookie = cookies[i];
//        if(cookie.getName().equals("oneDayCookie")) {
//            cookieValue = cookie.getValue();
//        }
//    }
      //String cookieValue = "on";
      String cookieValue = CookieManager.readCookie(request, "oneDayCookie");
      // 쿠키값이 설정되면 off
      System.out.println(cookieValue);
%>
<html>
<head>
    <title>간단한 팝업 메인</title>
    <style>
        #popup {padding : 10px; background-color: #fff;
                border: 1px solid #ccc;
                box-shadow: 5px 5px 10px rgba(0,0,0,0.1);
                width: 300px;
                position : fixed;
                left : 100px;
                top : 100px;
        }
        #popup h2 {
            font-size: 18px;
            margin: 0 0 10px 0;
        }
        #popup .content {
            min-height: 150px;
            background-color: #ccc;
            margin-bottom: 10px;
        }
        /*#popup .btn-box {*/
        /*    */
        /*}*/
    </style>
    <script src = "js/jquery-3.7.1.min.js"></script>
</head>
<body>
    <h1>오늘 하루 하늘이 닫힐 것이다.</h1>
    <button class="popup-revive">하늘 다시 열기(팝업 살리기)</button>
    <% if(!cookieValue.equals("off")) { %>
    <%-- 팝업 다시 살리기를 하면 oneDayCookie, off 가 없어짐  --%>
<%--    --%>
        <aside id = "popup">
            <h2>POPUP</h2>
            <div class="content">
<%--                <img src="src/main/webapp/LeniPlz.jpg" width="150" height="150">--%>
                여기에 내용이 들어갑니다 약오르지?. <br>
            </div>
            <div class = "btn-box">
                <label>
                    <input type="checkbox" id="today-check" value="one">
                    <span> 이거 누르면 나 오늘 못보는데 정말 괜찮아? 후회할걸? </span>
                </label>
                <button class="btn-close"> 꺼져! </button>
            </div>
        </aside>
    <% } %>
    <script>
        $(".popup-revive").on("click",function() {
            // $.ajax({
            //     url:"popup-revive.jsp",
            //     method:"GET", // GET POST PUT DELETE 의 차이?
            //     data: {
            //         popupRevive :"on" // 이건 그냥 쿠키 이름 변수
            //     }
            // })
            location.href="popup-revive.jsp";
        })
        $("#popup .btn-close").on("click",function (){
            const isChecked = $("#today-check").is(":checked");
            console.log(isChecked);
            //console.log($("#today-check").val());
            $("#popup").fadeOut(); // 팝업창 안보이게 하는 기능 구현
            if(isChecked) { // 몰래 보내기 위해서 ajax 를 사용
                $.ajax({
                    url:"popup-make.jsp",
                    method:"GET", // GET POST PUT DELETE 의 차이?
                    data: {
                        today:"one" // 이건 그냥 쿠키 이름 변수
                    }
                })
            }
            //location.href="cookie-read.jsp";
        })
    </script>
</body>
</html>
