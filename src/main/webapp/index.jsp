<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <meta http-equiv="X-UA-Compatible" content="ie=edge">
            <title>Document</title>
        </head>

        <body>
            <form action="userservlet" method="GET">
                <label>Username :</label>
                <input type="text" name="username" id="username">
                <input type="submit">
            </form>
            <hr> ${username}

            <h1>All Users</h1>
            ${users}
            <hr>

            <div align="center">
                <c:if test="${users != null}">
                    <table border="1" cellpadding="5">
                        <caption>
                            <h2>List of Users</h2>
                        </caption>
                        <tr>
                            <th>username</th>
                            <th>Actions</th>
                        </tr>

                        <c:forEach var="user" items="${users}">
                            <tr>
                                <td>
                                    <c:out value="${user}" />
                                </td>
                                <td>
                                    <a href="/edit?id=<c:out value='${book.id}' />">Edit</a>
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    <a href="/delete?id=<c:out value='${book.id}' />">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                </c:if>
                </table>
            </div>
        </body>

        </html>