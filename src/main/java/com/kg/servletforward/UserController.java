// package com.kg.servletforward;

// import java.io.IOException;
// import java.text.ParseException;
// import java.text.SimpleDateFormat;
// import java.util.ArrayList;
// import java.util.Date;

// import javax.servlet.RequestDispatcher;
// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// @WebServlet("/UserController")
// public class UserController extends HttpServlet {
//     private static final long serialVersionUID = 1L;
//     private static String INSERT_OR_EDIT = "/user.jsp";
//     private static String LIST_USER = "/listUser.jsp";
//     // private UserDao dao;
// //User a=new User();
//     ArrayList<User> userList = new ArrayList<User>();

//     protected void doGet(HttpServletRequest request, HttpServletResponse response)
//             throws ServletException, IOException {
//         String forward = "";
//         String action = request.getParameter("action");

//         // userList.add(new User(1, "firstName1"));
//         // userList.add(new User(2, "firstName2"));
//         // userList.add(new User(3, "firstName3"));

//         if (action.equalsIgnoreCase("delete")) {
//             int userId = Integer.parseInt(request.getParameter("userid"));
//             // dao.deleteUser(userId);
//             System.out.println(userId);
//             for (User user : userList) {
//                 if (user.getUserid() == userId) {
//                     // System.out.println(studentList.indexOf(student));
//                     System.out.println(user);
//                     userList.remove(userList.indexOf(user));
//                     break;
//                 }

//             }
//             // userList.forEach(System.out::println);
//             forward = LIST_USER;
//             request.setAttribute("users", userList);
//         } else if (action.equalsIgnoreCase("Edit")) {
//             forward = INSERT_OR_EDIT;
//             int userId = Integer.parseInt(request.getParameter("userid"));
//             //int userId = Integer.parseInt(request.getParameter("userId"));
//             // dao.deleteUser(userId);
//             System.out.println(userId);
//             for (User user : userList) {
//                 if (user.getUserid() == userId) {
//                     // System.out.println(studentList.indexOf(student));
//                     System.out.println(user);
//                   //  userList.set(userList.indexOf(userId),"userId");
//                     userList.set(userList.indexOf(user),userId);
//                    // userList.set(userList.indexOf(firstName),"firstName");
                    
//                     break;
//                 }
//             // User user = dao.getUserById(userId);
//             // request.setAttribute("user", user);
//         } 
//     }else if (action.equalsIgnoreCase("listUser")) {

//             forward = LIST_USER;
//             request.setAttribute("users", userList);
//         } else {
//             forward = INSERT_OR_EDIT;
//         }

//         RequestDispatcher view = request.getRequestDispatcher(forward);
//         view.forward(request, response);
//     }

//     protected void doPost(HttpServletRequest request, HttpServletResponse response)
//             throws ServletException, IOException {

//         int userid = Integer.parseInt(request.getParameter("userid"));
//         String firstName = request.getParameter("firstName");
//         User newUser = new User(userid, firstName);

//         // String userid = request.getParameter("userid");
//         if (userid > 0) {
//             userList.add(newUser);
//             userList.forEach(System.out::println);
//             request.setAttribute("users", userList);
//         } else {
//             System.out.println("edit user called");
//             // user.setUserid(Integer.parseInt(userid));
//             // dao.updateUser(user);
//         }
//         RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
//         // request.setAttribute("users", dao.getAllUsers());
//         view.forward(request, response);
//     }
// }

// import java.io.IOException;
// import java.text.ParseException;
// import java.text.SimpleDateFormat;
// import java.util.ArrayList;
// import java.util.Date;
package com.kg.servletforward;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/user.jsp";
    private static String LIST_USER = "/listUser.jsp";
    private String mode = "";

    ArrayList<User> userList = new ArrayList<User>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            int userId = Integer.parseInt(request.getParameter("userId"));

            System.out.println(userId);
            for (User user : userList) {
                if (user.getUserid() == userId) {

                    System.out.println(user);
                    userList.remove(userList.indexOf(user));
                    break;
                }

            }

            forward = LIST_USER;
            request.setAttribute("users", userList);
        } else if (action.equalsIgnoreCase("edit")) {
            mode = "update";
            forward = INSERT_OR_EDIT;
            int userid = Integer.parseInt(request.getParameter("userId"));

            User updateUser = new User();

            for (User user : userList) {
                if (user.getUserid() == userid) {

                    updateUser = user;
                    break;
                }

            }

            request.setAttribute("user", updateUser);

        } else if (action.equalsIgnoreCase("listUser")) {

            forward = LIST_USER;
            request.setAttribute("users", userList);
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int userid = Integer.parseInt(request.getParameter("userid"));
        String firstName = request.getParameter("firstName");
        User newUser = new User(userid, firstName);
        System.out.println(mode);

        if (mode != "update") {
            userList.add(newUser);

            request.setAttribute("users", userList);
        } else {
            System.out.println("edit user called");
            System.out.println(newUser);
            for (User user : userList) {
                if (user.getUserid() == userid) {
                    userList.set(userList.indexOf(user), newUser);

                    break;
                }

            }
            request.setAttribute("users", userList);
            mode = "";

        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);

        view.forward(request, response);
    }
}