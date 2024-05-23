package com.leekiye.jsp03;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        // get (link, form)
        // post(form method를 post로 명시해서 보냄 안쓰면 get)
        // delete / put / patch (ajax 통해서 보낼 수 있음)

        // pageContext, Request, Session, Application, Cookie 영역

        String userID = request.getParameter("userID");
        String userPW = request.getParameter("userPW");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
        out.println("userID : " + userID);
        out.println("userPW : " + userPW);
        out.println("</body></html>");
    }

    public void destroy() {
    }
}