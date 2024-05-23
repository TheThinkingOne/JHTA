<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.leekiye.jsp04.utility.CookieManager" %><%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-10
  Time: 오전 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //String userNO = String.valueOf(Integer.parseInt(request.getParameter("userNO")));
    String userID = request.getParameter("userID");
    String userPW = request.getParameter("userPW");
    String saveID = request.getParameter("saveID");
    String birthday = request.getParameter("birthday");

    Class.forName("oracle.jdbc.OracleDriver");
    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","leekiye99","1234");
    //String sql = "SELECT * FROM MEMBER WHERE userID = 'EmmaHardy21' and userPW = '1234'";
    String sql = "SELECT * FROM MEMBER WHERE userID = ? and userPW = ?";
    PreparedStatement pstmt = conn.prepareStatement(sql);

    pstmt.setString(1,userID);
    pstmt.setString(2,userPW);
    ResultSet rs = pstmt.executeQuery();
    // 결과 돌려주기
    if(rs.next()) {
        // 로그인 됐음
        //String userno = rs.getString("userno");
        String userid = rs.getString("userid");
        String username = rs.getString("username");
        //System.out.println(userid+"=="+username);
        if(saveID!=null && saveID.equals("yes")) {
            CookieManager.createCookie(response,"loggedID",userid,60*60*24*365);
        } else {
            CookieManager.deleteCookie(response,"loggedID");
        }

        session.setAttribute("sessionID",userID); // 세션으로 유저 정보 보내기 위한 키 벨류값 설정
        session.setAttribute("sessionName",username); // 여기서 왼쪽껀 대소문자 구분함, 주의할것
        session.setAttribute("sessionBirth",birthday);
        response.sendRedirect("index.jsp");
    }

%>

