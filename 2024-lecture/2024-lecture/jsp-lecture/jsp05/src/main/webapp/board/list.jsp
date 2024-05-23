<%@ page import="com.leekiye.jsp05.connect.JDBCConnectionPool" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.leekiye.jsp05.DTO.BoardDto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-16
  Time: 오후 2:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="../include/header.jsp" %>
<%
    int intPage = 1;
    String strNo = request.getParameter("page");
    if (strNo != null) {
        intPage = Integer.parseInt(request.getParameter("page"));
    }

    int perPage = 10;
    int start = (intPage-1)*perPage+1;
    int end = start+perPage;

    JDBCConnectionPool jdbcConnectionPool = new JDBCConnectionPool();
    //String sql = "SELECT * FROM MEMBER WHERE userID = 'EmmaHardy21' and userPW = '1234'";
    String sql = "SELECT * FROM\n" +
            "(SELECT ROWNUM AS NUM, b.* FROM \n" +
            "\t(SELECT * FROM board ORDER BY NO DESC) b\n" +
            ") WHERE num BETWEEN ? AND ?";
    jdbcConnectionPool.pstmt = jdbcConnectionPool.conn.prepareStatement(sql);
    jdbcConnectionPool.pstmt.setInt(1,start);
    jdbcConnectionPool.pstmt.setInt(2,end);

    jdbcConnectionPool.rs = jdbcConnectionPool.pstmt.executeQuery();

    List<BoardDto> boardDtoList = new ArrayList<>();
    while (jdbcConnectionPool.rs.next()) {
        BoardDto boardDto = new BoardDto();
        boardDto.setNo(jdbcConnectionPool.rs.getInt("no"));
        boardDto.setSubject(jdbcConnectionPool.rs.getString("subject"));
        boardDto.setContent(jdbcConnectionPool.rs.getString("content"));
        boardDto.setUserID(jdbcConnectionPool.rs.getString("userid"));
        boardDto.setUserName(jdbcConnectionPool.rs.getString("username"));
        boardDto.setPassword(jdbcConnectionPool.rs.getString("password"));
        boardDto.setRegdate(jdbcConnectionPool.rs.getString("regdate"));
        boardDto.setHit(jdbcConnectionPool.rs.getInt("hit"));
        boardDtoList.add(boardDto);
    }
    request.setAttribute("boardDtoList",boardDtoList);
    // 이렇게 담아줘야 함
%>

<div class="container">
    <h2 class="mt-5 mb-5">LIST</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>no</th>
            <th>id</th>
            <th>name</th>
            <th>조회수</th>
            <th>date</th>
            <th><input type ="checkbox" id ="check-all"></th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="boardDto" items="${boardDtoList}" begin="0" end="9" varStatus="loop">
                <tr>
                    <td>${loop.count}</td>
                    <td>
                        <a href="../board/view.jsp?no=${boardDto.no}">${boardDto.subject}</a>
                    </td>
                    <td>${boardDto.userName}</td>
                    <td>${boardDto.hit}</td>
                    <td>${boardDto.regdate}</td>
                </tr>
            </c:forEach>
        </tbody>

    </table>

    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item"><a class="page-link" href="#">Previous</a></li>

            <c:forEach var="boardDto" begin="0" end="9" varStatus="loop">
                <c:choose>
                    <c:when test="${param.page == loop.count}">
                        <li class="page-item active"><span class="page-link">${loop.count}</span></li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item">
                            <a class="page-link"
                               href="../board/list.jsp?page=${loop.count}">${loop.count}</a></li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <li class="page-item"><a class="page-link" href="#">Next</a></li>
        </ul>
    </nav>

    <% jdbcConnectionPool.close(); %>
    <div class="mt-5 mb-5"><a href="../board/write.jsp" class="btn btn-primary">WRITE</a></div>
</div>
<%@ include file="../include/footer.jsp" %>