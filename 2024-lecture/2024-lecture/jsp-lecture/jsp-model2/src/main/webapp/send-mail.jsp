<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.leekiye.jspmodel2.mail.NaverMail" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Map<String,String> sendMailInfo = new HashMap<>();
    sendMailInfo.put("from","kiyeleetest@naver.com");
    sendMailInfo.put("to","kiyelee@naver.com");
    sendMailInfo.put("subject","비밀번호 재설정");
    sendMailInfo.put("content","new password");
    sendMailInfo.put("format","text/plain; charset=utf-8");
    try {
        NaverMail naverMail = new NaverMail(application);
        naverMail.sendMail(sendMailInfo);
        System.out.println("success");
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("fail");
    }
%>