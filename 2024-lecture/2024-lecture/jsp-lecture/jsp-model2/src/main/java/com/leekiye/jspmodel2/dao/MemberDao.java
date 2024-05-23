package com.leekiye.jspmodel2.dao;

import com.leekiye.jspmodel2.connect.JDBCConnectionPool;
import com.leekiye.jspmodel2.dto.MemberDto;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDao extends JDBCConnectionPool {
    // DAO = DATA ACCESS OBJECT
    // Pool을 이용할 것이다.
    // 메서드 생성
    // 1.DB연결, 2.SQL생성, 3.PreparedStatement에 값 설정 4.SELECT 또는 나머지 것들
    public int insertMember(MemberDto memberDto) throws SQLException {
        int result = 0;
        try {
            String sql = "INSERT INTO MEMBER VALUES(MEMBER_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,memberDto.getUserID());
            pstmt.setString(2,memberDto.getUserPW());
            pstmt.setString(3,memberDto.getUserName());
            pstmt.setString(4,memberDto.getEmail());
            pstmt.setInt(5,memberDto.getPostcode());
            pstmt.setString(6,memberDto.getAddress());
            pstmt.setString(7,memberDto.getAddress_detail());
            pstmt.setString(8,"member");
            pstmt.setString(9,memberDto.getBirth());
            pstmt.setString(10,memberDto.getOriginalProfile());
            pstmt.setString(11,memberDto.getRenameProfile());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            conn.close();
        }
        return result;
    }

    public int checkDuplicateId(String userID) {
        int result = 0;
        String sql = "SELECT COUNT(*) AS COUNT FROM MEMBER WHERE USERID=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,userID);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                result = rs.getInt("COUNT"); // result 는 0 아니면 1이 될것임
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            this.close();
        }

        return result;
    }

    public MemberDto loginMember(String userID, String userPW) {
        // 매서드 안에 클래스를 넣기
        String sql = "SELECT * FROM MEMBER WHERE USERID=?";
        MemberDto loginMemberDto = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,userID);
            //pstmt.setString(2,userPW);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                String decodePW = rs.getString("userpw");
                System.out.println("decodePW==="+decodePW);
                
                if(BCrypt.checkpw(userPW,decodePW)){
                    loginMemberDto = new MemberDto();
                    loginMemberDto.setUserName(rs.getString("USERNAME"));
                    loginMemberDto.setUserID(rs.getString("USERID"));
                    loginMemberDto.setUserPW(rs.getString("USERPW"));
                } else {
                    System.out.println("로그인 실패 ㅠㅠ");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            this.close();
        }
        return loginMemberDto;
    }


    public MemberDto infoMember(String userID) {
        MemberDto infoMemberDto = null;
        String sql = "SELECT * FROM MEMBER WHERE USERID=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,userID);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                infoMemberDto = MemberDto.builder()
                        .no(rs.getInt("NO"))
                        .userName(rs.getString("USERNAME"))
                        .email(rs.getString("EMAIL"))
                        .postcode(rs.getInt("POSTCODE"))
                        .address(rs.getString("ADDRESS"))
                        .address_detail(rs.getString("ADDRESS_DETAIL"))
                        .birth(rs.getString("BIRTH"))
                        .originalProfile(rs.getString("ORIGINALPROFILE"))
                        .renameProfile(rs.getString("RENAMEPROFILE"))
                        .build();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            this.close();
        }

        return infoMemberDto;
    }

    public List<MemberDto> listMember() {
        List<MemberDto> memberList = null;
        String sql = "SELECT * FROM MEMBER";

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            memberList = new ArrayList<>();
            while (rs.next()) {
                MemberDto memberDto = MemberDto.builder()
                        .no(rs.getInt("no"))
                        .userID(rs.getString("USERID"))
                        .userName(rs.getString("USERNAME"))
                        .email(rs.getString("EMAIL"))
                        .address(rs.getString("ADDRESS"))
                        .address_detail(rs.getString("ADDRESS_DETAIL"))
                        .birth(rs.getString("BIRTH"))
                        .build();
                memberList.add(memberDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            this.close();
        }
        return memberList;
    }

    public int deleteMenber(String userID) {
        int result = 0;
        String sql = "DELETE FROM MEMBER WHERE USERID = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,userID);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result; // result 는 0 아니면 1로 떨어질 것임
    }

    public int updateChangedPassword(String userEmail, String changedPW) {
        int result = 0;
        String changePwSql = "UPDATE MEMBER SET USERPW=? WHERE EMAIL=?";
        String salt = BCrypt.gensalt();
        String encodedPW = BCrypt.hashpw(changedPW, salt);
        try {
            pstmt = conn.prepareStatement(changePwSql);
            pstmt.setString(1,encodedPW);
            pstmt.setString(2,userEmail);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            this.close();
        }
        return result;
    }

    public int updatePasswordAtInfo(String userID, String newPW) {
        int result = 0;
        //String sql ="select * from member where userid=? and userpw = ?";
        String sql ="update member set userpw = ? where userid = ?";
        String salt = BCrypt.gensalt();
        String encodePW = BCrypt.hashpw(newPW,salt);
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,encodePW);
            pstmt.setString(2,userID);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            this.close();
        }
        return result;

    }


    }

//    public int updatePasswordAtInfo(String currentPW, String newPW, String newPWConfirm) {
//        int result = 0;
//        String changePWAtInfoSql = "UPDATE MEMBER SET USERPW=? WHERE USERPW=?";
//        try {
//            String decodePW = rs.getString("USERPW");
//            if (BCrypt.checkpw(currentPW,decodePW)) {
//                pstmt = conn.prepareStatement(changePWAtInfoSql);
//                pstmt.setString(1,newPW);
//                pstmt.setString(2,currentPW);
//                result = pstmt.executeUpdate();
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            this.close();
//        }
//        return result;
//    }


