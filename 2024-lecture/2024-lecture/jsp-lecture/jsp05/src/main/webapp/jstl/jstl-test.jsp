<%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-20
  Time: 오전 9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="../include/header.jsp"%>
<div class="container">
    <h2>JSTL TEST</h2>
    <c:set var="pageVar" value="page에 설정된 변수" scope="page"></c:set>
    <c:set var="requestVar" value="request에 설정된 변수" scope="request"></c:set>
    <c:set var="sessionVar" value="session에 설정된 변수" scope="session"></c:set>
    <c:set var="applicationVar" value="application에 설정된 변수" scope="application"></c:set>
    <c:set var="betweenVar">사이에 설정된 변수</c:set>
    <c:set var="number" value="10"></c:set>
    <c:set var="string" value="이기예"></c:set>

    <ul>
        <li> pageVar에 변수 설정 : ${pageScope.pageVar} </li>
        <li> requestVar에 변수 설정 : ${requestScope.requestVar} </li>
        <li> sessionVar에 변수 설정 : ${sessionScope.sessionVar} </li>
        <li> applicationVar에 변수 설정 : ${applicationScope.applicationVar} </li>
        <li> 사이에 변수 설정 : ${betweenVar} </li>
        <%-- ${~~~.pageVar} 에서 ~~~ 부분은 생략해도 됨 --%>
        <l1>
            <c:if test="${number % 2 == 0}">
                <li>${number}는 짝수니까 출력</li>
            </c:if>
            <%-- c:if는 else문이 없다! 이런씨발! --%>
            <c:if test="${string eq '이기예'}">
                <li>${string}는 문자열 이기예니까 출력</li>
            </c:if>
            <c:if test="true">
                <li>test에 true가 들어가면 출력</li>
            </c:if>
            <c:if test="false">
                <li>test에 true가 들어가면 출력</li>
            </c:if>
            <%-- 대소문자 구분 안함, 공백 들어가는건 인식하나 --%>
            <c:choose>
                <c:when test=""></c:when>
                <c:otherwise></c:otherwise>
            </c:choose>
        </l1>
    </ul>
</div>



<%@include file="../include/footer.jsp"%>