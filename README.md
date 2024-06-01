<tr>
   <th scope="row">EMAIL</th>
   <td>${infoMemberDto.userEmail}</td>
</tr>
<tr>
   <th scope="row">POSTCODE</th>
   <td>${infoMemberDto.postCode}</td>
</tr>


// 우편번호 컬럼이 number(5) 타입으로 설정되어 있다면, 이는 숫자 형식으로 저장되므로 앞에 0이 있는 우편번호의 경우 앞의 0이 생략되어 표시
// 이를 해결하기 위해 ALTER TABLE MEMBER MODIFY POSTCODE VARCHAR2(5);
