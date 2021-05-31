package com.example;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "handleLogin", value = "/handle-login")

public class handleLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
        response.setContentType("text/html");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.html");
        HttpSession session = request.getSession();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String email= request.getParameter("email");
        String password = request.getParameter("pass");

        if(email.equals("admin") && password.equals("admin")){
            session.setAttribute("user", email);
            response.sendRedirect("dashboard");
        }
        else {
            out.println("<h1>Email or password is wrong!</h1>");
        }

    }
}
