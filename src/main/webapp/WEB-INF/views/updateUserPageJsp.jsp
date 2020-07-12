<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<body>
<table>
    <thead>
    <tr>
        <th><p>Id.</p></th>
        <th><p>Name.</p></th>
        <th><p>Password.</p></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${user.id}</td>
        <td>${user.username}</td>
        <td>${user.password}</td>
        <th></th>
    </tr>
    <tr>
        <form name="update" action="/admin/updateUser" method="post">
            <td>
                <input title="Id"  type="hidden" name="id" value="${user.id}">
            </td>
            <td>
                <input type="text" name="username"/>
            </td>
            <td>
                <input type="text" name="password"/>
            </td>
            <td>
                <input type="submit" title="Submit" value="Update">
            </td>
        </form>
    </tr>
    </tbody>
</table>
<form action="/logout" method="post">
    <input type="submit" value="Sign Out"/>
</form>
</body>
</html>