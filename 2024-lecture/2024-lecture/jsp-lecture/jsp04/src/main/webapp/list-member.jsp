<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-10
  Time: 오전 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Class.forName("oracle.jdbc.OracleDriver");
    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","leekiye99","1234");
    String sql = "select * from member order by no";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    ResultSet rs = pstmt.executeQuery(); // executeQuery의 리턴값은 resultSet 을 반환

//    if(rs.next()) {
//        System.out.println(rs.getInt("no"));
//        System.out.println(rs.getString("userID"));
//        System.out.println(rs.getString("userPW"));
//        System.out.println(rs.getString("userName"));
//        System.out.println(rs.getString("birthday"));
//    }

%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table BORDER="1" WIDTH="800">
        <thead>
            <tr>
                <th>no</th>
                <th>id</th>
                <th>name</th>
                <th>birth</th>
            </tr>
        </thead>
        <tbody>
            <%
                while (rs.next()) {
                    out.println("<tr>");
                    out.println("<td>"+rs.getInt("no") + "</td>");
                    out.println("<td>"+rs.getString("userID") + "</td>");
                    out.println("<td>"+rs.getString("userName") + "</td>");
                    out.println("<td>"+rs.getString("birth") + "</td>");
                    out.println("</tr>");
//                  getInt, getString 안에 적는 건 맴버변수가 아니고 DB에 선언한 컬럼명이다. 주의할것
                }
            %>
            <tr>
                <td></td>
            </tr>
        </tbody>
    </table>
</body>
</html>
