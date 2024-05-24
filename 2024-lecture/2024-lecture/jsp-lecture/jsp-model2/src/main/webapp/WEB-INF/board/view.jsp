<%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-24
  Time: 오후 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="../include/header.jsp"%>
    <h2 class="mt-5 mb-5">작성글 보기</h2>
    <table class="table">
        <colgroup>
            <col style="width: 150px">
        </colgroup>
        <tbody>
            <tr>
                <th>SUBJECT</th>
                <td>${boardDto.subject}</td>
            </tr>
            <tr>
                <th>CONTENT</th>
                <td class="content">${boardDto.content}</td>
            </tr>
        </tbody>
    </table>
<script src="http://cdn.iframe.ly/embed.js?api_key=01454fbe619575942590af"></script>
<script>
    document.querySelectorAll("oembed[url]").forEach(element=>{
        iframely.load(element,element.attributes.url.value)
    });
</script>

<%@ include file="../include/footer.jsp" %>