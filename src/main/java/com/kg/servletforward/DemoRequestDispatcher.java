package com.kg.servletreqdispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/splessons", initParams = { 
    @WebInitParam(name = "greet", value = "Hello ") })
public class DemoRequestDispatcher extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // response.setContentType("text/html");
        // PrintWriter out = response.getWriter();
        ServletContext context = getServletContext();
        context.setAttribute("company", "IBM");

        ServletConfig config = getServletConfig();
        config.getInitParameter("greet");
        // System.out.println(config.getInitParameter("greet"));
        
        request.setAttribute("initparam", config.getInitParameter("greet"));

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("goForwardServlet");
        requestDispatcher.include(request, response);

    }

}