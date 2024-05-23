<%@ page import="com.leekiye.jsp05.connect.JDBCConnectionPool" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.sql.Array" %><%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-16
  Time: 오전 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    //request.getParameterValues("check");
<%--    // <td><input type ="checkbox" id="" name="check" class="check" value="<%=rs.getInt("no")%>"> </td>--%>
<%--    list-member 에서 선언된 checkbox 의 name 값 check 를 getParamValues 에 넣음--%>
<%
    JDBCConnectionPool jdbcConnectionPool = new JDBCConnectionPool();
    try {

        String sql = "DELETE FROM MEMBER WHERE NO = ?";
        PreparedStatement pstmt = jdbcConnectionPool.conn.prepareStatement(sql);
        jdbcConnectionPool.conn.setAutoCommit(false); // 오토 커밋 끄기
        String noList[] = request.getParameterValues("check");
        // 한꺼번에 삭제할때는 ( 만약 데이터가 존나 많을 경우...) 트랜잭션 구현을 무조건 해줘야 한다
        // 조금씩 삭제하는건 상관없지만

        // 한번에 처리할때는
        for (int i = 0; i < noList.length; i++) {
            System.out.println(noList[i]);
            pstmt.setInt(1, Integer.parseInt(noList[i]));
            pstmt.addBatch(); // 한번에 처리할때는 batch 사용해서 처리

            if(i==1) {
                throw new Exception("알 수 없는 서버 오류 떴다고 가정함");
            }


        } // 넘어오는 회원의 NO(회원번호 숫자) 출력해보기

        int result[] = pstmt.executeBatch(); //
        System.out.println(Arrays.toString(result));
        jdbcConnectionPool.conn.commit();
        jdbcConnectionPool.conn.close(); // 자원 회수 해줘야 함

    } catch (Exception e) {
        jdbcConnectionPool.conn.rollback();
        e.printStackTrace();
        jdbcConnectionPool.conn.close();

    } finally {
        // finally는 무조건 실행하는 곳 autoCommit(false)
        // 롤백을 하든 오토커밋을 하든 무조건 오토커밋을 true 해준다
        jdbcConnectionPool.conn.setAutoCommit(true);
        jdbcConnectionPool.conn.close();
    }



%>
