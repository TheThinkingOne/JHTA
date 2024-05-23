package com.leekiye.jspmodel2.controller.member;

import com.leekiye.jspmodel2.dao.MemberDao;
import com.leekiye.jspmodel2.dto.MemberDto;
import com.leekiye.jspmodel2.utils.ScriptWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.mindrot.jbcrypt.BCrypt;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/member/insert-process")
@MultipartConfig(
        maxFileSize = 1024*1024
) // 이걸 써야지만 바이너리로 넘어오는 것들 처리 가능

public class InsertMemberProcess2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userID = req.getParameter("userID");
        String userPW = req.getParameter("userPW");
        String userName = req.getParameter("userName");
        String userEmail = req.getParameter("userEMAIL");
        int postCode = Integer.parseInt(req.getParameter("userPOSTCODE"));
        String address = req.getParameter("userADDRESS");
        String detailAddress = req.getParameter("userDETAILADDRESS");
        String birth = req.getParameter("userBirth");
        String originalProfile = "";
        String renameProfile = "";
        Part profile = req.getPart("profile");
        String renameFile = "";

        // 비밀번호 암호화 => BCrypt 사용
        String salt = BCrypt.gensalt();
        userPW = BCrypt.hashpw(userPW, salt);
        System.out.println(userPW);
        // 이렇게 하면 사용자가 만든 비밀번호가 서버에는 무작위 문자열로 전달됨 // 레인보우 테이블 이라는 공격이 있음

        String partHeader = profile.getHeader("content-disposition");
        String partArray[] = partHeader.split("filename=");
        String originalFileName = partArray[1].trim().replace("\"", "");

        String serverUploadDir = this.getServletContext().getRealPath("upload");
        System.out.println("serverUploadDir === " + serverUploadDir);
        File dir = new File(serverUploadDir);
        if(!dir.exists()) {
            dir.mkdir();
        }

        if(!originalFileName.isEmpty()) {

            profile.write(serverUploadDir + File.separator + originalFileName);
            String fileName = originalFileName.substring(0, originalFileName.lastIndexOf("."));
            String extension = originalFileName.substring(originalFileName.lastIndexOf("."));

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("_YYYYMMdd_HHmmss");
            String formatNow = now.format(dateTimeFormatter);
            renameFile = fileName+formatNow+extension;

            originalProfile = serverUploadDir+File.separator+originalFileName;
            //localhost:8080/upload/jun.jpg
            renameProfile = serverUploadDir+File.separator+renameFile;
            //localhost:8080/upload/jun_20240513-151234.jpg

            File oldFile = new File(originalProfile);
            File newFile = new File(renameProfile);
            oldFile.renameTo(newFile);

        }
        // partHeader 에서 filename 을 통해서 올라온 파일명 추출
        // original file name과 renamed file name을 db에 올려주어야 한다


        // 쉽게 하는법 => 디자인 패턴 이용해서 코드짜기
        // Builder 패턴
        MemberDto insertMemberDto = MemberDto.builder()
                .userID(userID)
                .userPW(userPW)
                .userName(userName)
                .email(userEmail)
                .postcode(postCode)
                .address(address)
                .address_detail(detailAddress)
                .birth(birth)
                .grade("member")
                .originalProfile(originalProfile)
                .renameProfile(renameFile)
                .build();

        MemberDao memberDao = new MemberDao();
        int result = 0;
        try {
            result = memberDao.insertMember(insertMemberDto);
            if  (result > 0) {
                resp.sendRedirect("../index/index");
            } else {
                ScriptWriter.alertAndBack(resp,"알 수 없는 오류 발생. 다시 시도해주세요");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            memberDao.close();
        }

    }
}
