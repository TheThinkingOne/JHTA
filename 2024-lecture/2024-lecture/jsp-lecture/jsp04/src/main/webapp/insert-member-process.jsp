<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %><%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-10
  Time: 오전 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String userID = request.getParameter("userID");
    String userPW = request.getParameter("userPW");
    String userName = request.getParameter("userName");
    String birthday = request.getParameter("birthday");

    Class.forName("oracle.jdbc.OracleDriver");
    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","leekiye99","1234");
    // 다른 호스트 쓴다고 하면 @localhost 에 ip주소 쓰면 됨

    // sql Injection
//    String sql = "insert into member values(?,?,?)";
//    PreparedStatement pstmt = conn.prepareStatement(sql);
//    pstmt.setString(1,userID);
//    pstmt.setString(2,userPW);
//    pstmt.setString(3,userName);
    //pstmt.setString(4,birthday);
    // 이런식으로 해서 사용자 회원정보 입력을 받을 수 있다

    String seq_sql = "insert into member values(member_seq.nextval,?,?,?,?)";
    PreparedStatement seq_pstmt = conn.prepareStatement(seq_sql);
    
    seq_pstmt.setString(1,userID);
    seq_pstmt.setString(2,userPW);
    seq_pstmt.setString(3,userName);
    seq_pstmt.setString(4,birthday);

    int result = seq_pstmt.executeUpdate();
    if (result > 0) {
        out.println("<script>alert(\"회원가입이 완료됬습니다!\")</script>");
    }  else {
        out.println("<script>alert(\"회원가입에 실패했습니다...\")</script> ");
    }

%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
