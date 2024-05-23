package com.leekiye.jsp05.connect;

import jakarta.servlet.ServletContext;

import java.sql.*;

public class JDBCConnect {
    public Connection conn;
    public PreparedStatement pstmt;
    // pstmt 는 쿼리를 날리기 위한 것
    public ResultSet rs;
    // rs 는 select 에서 값 받아오기..

    public JDBCConnect(String driver, String url, String id, String password) {
        // 사실 이렇게 하는건 별로 안좋음
        // jsp가 아닌 외부 파일에서 Connection 설정하려면 try Catch 해줘야 함
        {
            try {
                Class.forName("oracle.jdbc.OracleDriver");
//                String url = "jdbc:oracle:thin:@localhost:1521:xe";
//                String id = "leekiye99";
//                String password = "1234";
                conn = DriverManager.getConnection(url,id,password);
                System.out.println("DB CONNECTED!");
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public JDBCConnect(ServletContext application) {
        {
            try {

                String driver = application.getInitParameter("OracleDriver");
                String URL = application.getInitParameter("OracleURL");
                String id = application.getInitParameter("OracleID");
                String password = application.getInitParameter("OraclePassword");

                Class.forName(driver);
                conn = DriverManager.getConnection(URL,id,password);
                System.out.println("DB CONNECTED!");

            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void close() {
        // Pool ==> 연결할 수 있는 것들 모아두기....
        // 메모리 누수 막기 위한 close 매소드
        try {
            if (rs!=null) rs.close();
            if (pstmt!=null) pstmt.close();
            if (conn!=null) conn.close();
            System.out.println("JDBC DISCONNECTED!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
