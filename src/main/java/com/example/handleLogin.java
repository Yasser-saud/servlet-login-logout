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
        // show the login page
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.html");
        HttpSession session = request.getSession();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // hard codded values
        String email= request.getParameter("email");
        String password = request.getParameter("pass");

        // check if both parameters equals admin admin
        if(email.equals("admin") && password.equals("admin")){
            // set a session for the user
            session.setAttribute("user", email);

            // redirect to dashboard
            response.sendRedirect("dashboard");
        }
        else {
            // throw error
            out.println("<h1>Email or password is wrong!</h1>");
        }

    }
}
