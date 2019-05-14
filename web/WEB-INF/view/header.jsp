<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: jakub
  Date: 12.05.2019
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pseudo Twitter</title>
</head>
<body>



${fn:toUpperCase(login)}
<a href="message">Messages</a>

<a href="users">Users</a>

<a href="logout">Log out</a>



</body>
</html>
