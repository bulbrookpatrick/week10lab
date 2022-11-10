<%-- 
    Document   : users
    Created on : 29-Oct-2022, 4:17:28 PM
    Author     : Patrick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
    </head>
    <body>
        <h1>Manage Users</h1>
        
        <table style="border:solid; border-width: 2px;">
            <tr>
                <th>Email</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Role</th>
                <th></th>
                <th></th>
            </tr>
        
            <c:forEach items="${user}" var="user">
                <td>${user.email}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.role}</td>
                <td>Edit</td>
                <td>Delete</td>
            </c:forEach>
                
            
        </table>
        
        <form method="get">
         
            <h1>
                <c:if test="${message eq 'add'}">Add User: </c:if>
                <c:if test="${message eq 'edit'}">Edit User: </c:if>
            </h1><br>
            
            <label for="email">Email: </label>
            <input type="text" id ="email" name="email"><br>
            
            <label for="fName">First Name: </label>
            <input type="text" id="fName" name="fName"><br>
            
            <label for="lName">Last Name: </label>
            <input type="text" id="lName" name="lName"><br>
            
            <label for="password">Password: </label>
            <input type="password" id="password" name="password"><br>

            <label for="role">Role: </label>
            <select name="role" id="role">
                <option value="admin">System Admin</option>
                <option value="regularUser">Regular User</option>
                
            </select>
            <br><br>
            <input type="button" method="get" value="Add User">
        </form>
    </body>
</html>
