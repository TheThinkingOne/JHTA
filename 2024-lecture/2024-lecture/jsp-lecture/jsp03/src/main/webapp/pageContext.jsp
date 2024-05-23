<%@ page import="com.leekiye.jsp03.Data_Transfer_Object.Person" %><%--
  Created by IntelliJ IDEA.
  User: JHTA
  Date: 2024-05-09
  Time: 오전 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // setAttribute 에는 뭐든 담을 수 있음 값을 끄집어 낼때는 반드시 형변환 필요
    pageContext.setAttribute("pageContextInt",100);
    pageContext.setAttribute("pageContextString","EmmaHardy21");
    pageContext.setAttribute("pageContextPerson", new Person("엠마 하디",21));
    request.setAttribute("requestString","EmmaHardy21");
    session.setAttribute("sessionString","엠마하디21");
    session.setAttribute("sessionPerson",new Person("엠마하디22",21));
    // getAttribute() 할 때 주의할점은 return 값은 Object 이므로 형변환해서 써야 한다.
    // application. 은 웬만하면 쓰지 않음
    // 보통 로그인 했을 때 많이 사용함
    // session은 연결을 한번 설정했을 때 연결이 끊어질 때 까지 사용할 수 있음
    // session은 보통 브라우저 단위, 예를들어 크롬에서 네이버 로그인 하고 edge 로 네이버 키면 로그안 안 되어 있음

    // application > session > request > pageContext


    int pageContextInt = (int)pageContext.getAttribute("pageContextInt");
    String pageContextString = pageContext.getAttribute("pageContextString").toString();
    Person pageContextPerson = (Person)pageContext.getAttribute("pageContextPerson");
    // setAttribute(key, value) 형식으로 작성
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1> <%= pageContextInt %> </h1>
    <h1> <%= pageContextString %> </h1>
    <h1> <%= pageContextPerson.getName() %> </h1>
    <h1> <%= pageContextPerson.getAge() %> </h1>
<%
    // jsp를 view로 사용할때 쓴느 방법
    // request 에 실린 값은 forward 로 페이지 바뀔때만 한번 넘길 수 있다.
    request.getRequestDispatcher("second.jsp").forward(request,response); // forward 방식
    // response.sendRedirect("second.jsp");
%>
</body>
</html>
