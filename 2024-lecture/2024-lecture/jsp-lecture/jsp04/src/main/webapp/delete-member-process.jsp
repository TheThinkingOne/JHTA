<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="com.leekiye.jsp04.utility.CookieManager" %><%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-10
  Time: 오후 3:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String deleteUserID = request.getParameter("userID");
    String deleteUserPW = request.getParameter("userPW");
    //String infoID = (String) session.getAttribute("sessionID");

    Class.forName("oracle.jdbc.OracleDriver");
    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","leekiye99","1234");
    String sql = "delete from member where userid = ? and userpw = ?";
    PreparedStatement pstmt = conn.prepareStatement(sql);

    pstmt.setString(1,deleteUserID);
    pstmt.setString(2,deleteUserPW);

    int deleteResult = pstmt.executeUpdate(); // 여기서 deleteResult는 몇개에 행에 영향을 미쳤느냐 새는 개수
    // 아이디 삭제하는건 db 테이블에서 업데이트 하는것이므로
    // exequteQuery 가 아닌 exequteUpdate 해야함
    if (deleteResult > 0) {
        session.invalidate();
        CookieManager.deleteCookie(response,"loggedID");
        out.println("<script>alert("+deleteResult+"); location.href=\"index.jsp\"; </script>");
    }

%>

