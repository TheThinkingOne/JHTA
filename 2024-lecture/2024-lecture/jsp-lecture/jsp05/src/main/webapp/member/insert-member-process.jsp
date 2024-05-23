<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="com.leekiye.jsp05.connect.JDBCConnect" %>
<%@ page import="com.leekiye.jsp05.utility.ScriptWriter" %>
<%@ page import="com.leekiye.jsp05.connect.JDBCConnectionPool" %><%--
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
    String birthday = request.getParameter("userBirth");
    String userEmail = request.getParameter("userEMAIL");
    String postCode = request.getParameter("userPOSTCODE");
    String userAddress = request.getParameter("userADDRESS");
    String userDetailAddress = request.getParameter("userDETAILADDRESS");


//    Class.forName("oracle.jdbc.OracleDriver");
//    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","leekiye99","1234");
    // 다른 호스트 쓴다고 하면 @localhost 에 ip주소 쓰면 됨
//    String driver = application.getInitParameter("OracleDriver");
//    String URL = application.getInitParameter("OracleURL");
//    String id = application.getInitParameter("OracleID");
//    String password = application.getInitParameter("OraclePassword");

    // web.xml에 아이디 비밀번호 저장해두고 쓰기


    JDBCConnect jdbcConnect = new JDBCConnect(application);
    // 이건 설정파일 web.xml 바꾼거니까 서버 재가동 하는게 좋다.
    // 사실 이렇게 하는게 좋음

    // web.xml 에 contextParameter 로 해서 안전하게 불러오기

//    JDBCConnect jdbcConnect = new JDBCConnect(driver, URL, id, password);
    JDBCConnectionPool jdbcConnectionPool = new JDBCConnectionPool();

    String seq_sql = "insert into member values(member_seq.nextval,?,?,?,?,?,?,?,?)";
    PreparedStatement seq_pstmt = jdbcConnectionPool.conn.prepareStatement(seq_sql);
    //PreparedStatement pstmt = jdbcConnect.conn.prepareStatement(seq_sql);

    seq_pstmt.setString(1,userID);
    seq_pstmt.setString(2,userPW);
    seq_pstmt.setString(3,userName);
    seq_pstmt.setString(4,userEmail);
    seq_pstmt.setString(5,postCode);
    seq_pstmt.setString(6,userAddress);
    seq_pstmt.setString(7,userDetailAddress);
    seq_pstmt.setString(8,birthday);

    int result = seq_pstmt.executeUpdate();
    if (userID == null || userID.trim().isEmpty() ||
            userPW == null || userPW.trim().isEmpty() ||
            userName == null || userName.trim().isEmpty() ||
            birthday == null || birthday.trim().isEmpty() ||
            userEmail == null || userEmail.trim().isEmpty() ||
            postCode == null || postCode.trim().isEmpty() ||
            userAddress == null || userAddress.trim().isEmpty() ||
            userDetailAddress == null || userDetailAddress.trim().isEmpty()) {
        ScriptWriter.alertAndBack(response,"회원가입이 되지 않았습니다. 모든 필수 입력란을 채워주세요.");
    }
    else {
        if (result > 0) {
            ScriptWriter.alertAndNext(response,"회원가입이 완료되었습니다.","../index/index.jsp");
            // 일반 경고창, 경고창 띄우고 페이지 바뀌는 경우, 경고창 띄우고 뒤로 빽하기..
            //out.println("<script>alert(\"회원가입이 완료됬습니다!\")</script>");
        }
    }
    //jdbcConnect.close();
    jdbcConnectionPool.close();

%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
