package com.kg.servletforward;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;

/**
 * UserServlet
 */

@WebServlet("/userservlet")
public class UserServlet extends HttpServlet {

    ArrayList<String> users = new ArrayList<String>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet called");

        String username = req.getParameter("username");
        System.out.println(username);

        users.add(username);

        System.out.println(users);

        req.setAttribute("username", username);
        req.setAttribute("users", users);
        RequestDispatcher dispatcher = req.getRequestDispatcher("user.jsp");
        dispatcher.forward(req, resp);
    }
}