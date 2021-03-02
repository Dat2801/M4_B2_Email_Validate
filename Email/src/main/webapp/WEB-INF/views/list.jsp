<%--
  Created by IntelliJ IDEA.
  User: Dat Bong
  Date: 3/2/2021
  Time: 1:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email Validate</title>
</head>
<body>
<h1>Email Validate</h1>
<h3>${message}</h3>
<form action="validate" method="post">
    <input type="text" name="email"><br>
    <input type="submit" name="Validate">
</form>
</body>
</html>
