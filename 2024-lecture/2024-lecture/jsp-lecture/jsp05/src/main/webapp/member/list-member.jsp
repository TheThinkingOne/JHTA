<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="com.leekiye.jsp05.connect.JDBCConnectionPool" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../include/header.jsp" %>
<%
    JDBCConnectionPool jdbcConnectionPool = new JDBCConnectionPool();
    String sql = "SELECT * FROM MEMBER";
    PreparedStatement pstmt = jdbcConnectionPool.conn.prepareStatement(sql);
    ResultSet rs = pstmt.executeQuery();
%>

<script>
    // 구글링 해서 가져온 코드
    // history.back() reload 이수 해결 코드 -> 크롬은 history.back() 막아놧음 병신
    if (document.addEventListener) {
        window.addEventListener("pageshow", function (event) {
            if (event.persisted || window.performance && window.performance.navigation.type == 2) {
                location.reload();
            }
        }, false);
    }
</script>

<div class="container">
    <h2 class="mt-5 mb-5">MEMBER LIST</h2>
    <form action = "delete-member-process-all.jsp" method="get" id="member-list-form">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>no</th>
            <th>id</th>
            <th>name</th>
            <th>email</th>
            <th>delete</th>
            <th><input type ="checkbox" id ="check-all"></th>
        </tr>
        </thead>
        <tbody>

        <%  while(jdbcConnectionPool.rs.next()) { %>
        <tr>
            <td><%=rs.getInt("no")%></td>
            <td><%=rs.getString("userid")%></td>
            <td><%=rs.getString("username")%></td>
            <td><%=rs.getString("email")%></td>
            <td>
                <a href="../member/admin-delete-member-process.jsp?
                   listID=<%=rs.getString("userid") %>"
                   class="btn btn-danger">DEL</a>
                <button class="btn btn-danger btn-delete mx-1" type="button"
                        data-userid="<%=rs.getString("userid")%>">AJAX-DEL
                </button>
            </td>
            <td>
                <input type ="checkbox" id="" name="check" class="check" value="<%=rs.getInt("no")%>">
            </td>
        </tr>
        <%}%>
        </tbody>
    </table>
    <div clsss="mt-2"><button class="btn btn-danger btn-delete-all">DEL</button></div>
    </form>

    <button class="btn btn-danger btn-delete-all02">삭제</button>
</div>

<script>
    // a href ="데이터 처리할 서버 페이지? 변수=값&변수=값....."
    // form action = "데이터 처리할 서버 페이지" name = "변수" value = "값" method = "post/get"
    // ajax (jquery ajax(), vanilla script fetch, axios 라이브러리 유명함(axios 는 ajax 처리용...)
    $(".btn-delete-all").on("click",function (e) {
        // e.preventDefault();
        const areYouSureToDeleteAll = confirm("삭제 하시겠습니까? 정말로?????????");
        //console.log(areYouSureToDeleteAll);
        if(areYouSureToDeleteAll) {
            $("#member-list-form").submit();
        }
        return false;
    });

    $(".btn-delete-all").on("click",function () {
        $("#member-list-form").submit();
    });



    $(".btn-delete").on("click",function () {
        const parent = $(this).parent().parent();
        //alert("AJAX 방식으로 데이터 삭제처리");
        const sendUserID = $(this).data("userid") // this 는 버튼을 가리킴
        <%--// data-userid="<%=rs.getString("userid")%>">AJAX-DEL</button> 여기서 선언된 data-userid 를 가져옴--%>

        $.ajax({
            url:"../member/admin-delete-member-ajax-process.jsp",
            data: {
                listID : sendUserID
            },
            success:function(data) {
                console.log(data);
                if(data.isDelete === "yes") {
                    alert(sendUserID + "님을 탈퇴시켰습니다.");
                    // location.reload();
                    parent.remove();
                }
            }
        })
    });

    $("#check-all").on("click",function () {
        if($(this).is(":checked")) {
            // jquery 에서 체크가 되어있다고 표시할때 :checked 를 써줘야함
            $(".check").prop("checked",true);
        } else {
            $(".check").prop("checked",false);
        }
    })
</script>

<%@ include file="../include/footer.jsp" %>
