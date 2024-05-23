<%@ page import="com.leekiye.jsp05.connect.JDBCConnectionPool" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.google.gson.Gson" %><%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-13
  Time: 오후 3:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String dupIdCheck = request.getParameter("userID");
    // 만약 userID 가 db 에 있으면 알려주면 된다
    JDBCConnectionPool jdbcConnectionPool = new JDBCConnectionPool();
    String sql = "SELECT COUNT(*) as count FROM MEMBER WHERE USERID = ?";
    PreparedStatement pstmt = jdbcConnectionPool.conn.prepareStatement(sql);
    pstmt.setString(1, dupIdCheck);
    ResultSet rs = pstmt.executeQuery();
    int result = 0; // 중복이 아니면 0, 맞으면 1
    if(rs.next()) {
        result = rs.getInt("count"); // 위 count 에 적힌 별칭 가져옴
    }

    response.setContentType("application/json; charset=utf-8"); // mime 타입
    // 넘어온 값을 가공ㄹ해서 json 으로 반환
    Map<String, Integer> countMap = new HashMap<>();
    countMap.put("count",result); // {count : 0 or 1}
    Gson gson = new Gson();
    String returnJson = gson.toJson(countMap); // 맵을 Gson 으로 변환
    out.println(returnJson);

    // response.setContentType("application/json; charset=utf-8"); // 응답을 json 형식으로 보내기 위해 설정
    // out.println("{\"count\":\""+result+"\"}");

    System.out.println("ajax valie === " + dupIdCheck);
    // https://chatgpt.com/share/881ddecb-fb84-43e9-9832-44c8b2723f26
%>
