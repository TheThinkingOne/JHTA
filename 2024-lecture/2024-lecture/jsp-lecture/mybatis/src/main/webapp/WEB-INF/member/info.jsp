<%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-31
  Time: 오후 5:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="../include/header.jsp"%>
<div class="container">
  <h2 class="mt-5 mb-5">회원정보</h2>
  <table class="table table-striped">
    <tbody>
    <tr>
      <th>PROFILE</th>
      <td>
        <c:choose>
          <c:when test="${not empty infoMemberDto.renameProfile}">
            <img src="${request.contextPath}/upload/${infoMemberDto.renameProfile}" class="profile">
          </c:when>
          <c:otherwise>
            <img src="../images/defaultusericon.png" class="profile">
          </c:otherwise>
        </c:choose>

        <!-- 이미지 작게 만들기 -->
      </td>
    </tr>
    <tr>
      <th scope="row">NO</th>
      <td>${infoMemberDto.no}</td>
    </tr>
    <tr>
      <th scope="row">NAME</th>
      <td>${infoMemberDto.userName}</td>
    </tr>
    <tr>
      <th scope="row">EMAIL</th>
      <td>${infoMemberDto.userEmail}</td>
    </tr>
    <tr>
      <th scope="row">POSTCODE</th>
      <td>${infoMemberDto.postCode}</td>
    </tr>
    <tr>
      <th>ADDRESS</th>
      <td>${infoMemberDto.address} <br>${infoMemberDto.addressDetail}</td>
    </tr>
    <tr>
      <th scope="row">BIRTH</th>
      <td>${infoMemberDto.birth}</td>
    </tr>
    </tbody>
  </table>
  <div>
    <a href="../member/password-change" class="btn btn-primary">비밀번호 재설정</a>
    <!-- 페이지 만들고 기존 비밀번호 입력, 바꿀 비밀번호 만들고 확인하는 비밀번호 확인하는 것 구현 -->
  </div>
</div>
<%@ include file="../include/footer.jsp"%>

