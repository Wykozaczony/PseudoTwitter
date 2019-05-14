<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: jakub
  Date: 11.05.2019
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Messages</title>
</head>
<body>
<%@include file="header.jsp"%>

<br>
<br>
<br>
<h1>PSEUDO TWEETY DZIWKO!!!</h1>

<ul>
    <c:forEach items="${tweets}" var="tweet">
        <li>${tweet.message} <br>${tweet.username}
            <br>

            <fmt:formatDate value="${tweet.publishedAt}" pattern="dd-MM-yyyy HH:mm"></fmt:formatDate>

            <br><br></li>
    </c:forEach>
</ul>
<br>
<br>
<h1>TWEETUJ SZMATOO!!</h1>
<br>
<form action="addNewTweet" method="post">
    <textarea rows="4" cols="50" name="post"  placeholder="Enter text">
</textarea>
    <input type="submit" value="Tweetuj Czarnuchu!">
</form>



</body>
</html>
