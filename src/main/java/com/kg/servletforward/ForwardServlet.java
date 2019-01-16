package com.kg.servletforward;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/goForwardServlet")

public class ForwardServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // response.setContentType("text/html");
        // PrintWriter out = response.getWriter();


        String username = request.getParameter("username");
        String email = request.getParameter("email");
        
    

        ServletContext context=getServletContext();  
        String company=(String)context.getAttribute("company");  

        
        request.setAttribute("username", username);
        request.setAttribute("email", email);
        request.setAttribute("company", company);
        
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("welcome.jsp");  
        requestDispatcher.forward(request, response); 

        
    }
}
```

```
String str=req.getServletPath();
        // System.out.println(str);

        String str1 = req.getPathInfo();
        // System.out.println(str1);
        System.out.println(str + " "+str1);

        switch (str1) {
        case "/new":
            System.out.println("/new");
            break;
        case "/edit":
            System.out.println("/edit");
            break;

        default:
            System.out.println("/list");
            break;
        }