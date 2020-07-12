<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="POST" action="/login">
    <h2>System in.</h2>
    <input name="username" type="text" placeholder="Username"
           autofocus="true"/>
    <input name="password" type="password" placeholder="Password"/>
    <button type="submit">Log In</button>
</form>
<%--<a href="/login/create"><h2>CreateUsers</h2></a>--%>
</body>
</html>