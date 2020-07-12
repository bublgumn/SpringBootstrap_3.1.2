<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Admin page.</title>
</head>
<body>
<table border="1" cellpadding="5">
    <thead>
    <tr>
        <th><p>Id.</p></th>
        <th><p>Name.</p></th>
        <%--<th><p>Password.</p></th>--%>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
                <%--<td>${user.password}</td>--%>
            <td>
                <form name="delete" action="/admin/deleteUser" method="post">
                    <input title="Id" type="hidden" name="id" value="${user.id}">
                    <input type="submit" title="Submit" value="Delete">
                </form>
            </td>
            <td>
                <form name="update" action="/admin/updateUser" method="get">
                    <input title="Id" type="hidden" name="id" value="${user.id}">
                    <input type="submit" title="Submit" value="Update">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<br>
<div>
    <h1>New User</h1>
    <form action="/admin/newuser" method="post">
        <div><label> User Name : <input type="text" name="username"/> </label></div>
        <div><label> Password: <input type="text" name="password"/> </label></div>
        <%--<div><input type="checkbox" name="userparam" value="user"/></div>--%>
        <div><input type="checkbox" name="adminparam" value="admin"/></div>
        <div><input type="submit" value="Create user."/></div>
    </form>
</div>
<br>
<br>
<%--<h2><a href="/logout" >Logout</a></h2>--%>
<form action="/logout" method="post">
    <input type="submit" value="Sign Out"/>
</form>
</body>
</html>
