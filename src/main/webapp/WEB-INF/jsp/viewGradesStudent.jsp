<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
    <title>Grades</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>

<c:if test="${not empty userSession.username}">
    <ul>
        <li class="welcome">Welcome ${userSession.username}!</li>
        <li><a href="home">Home</a></li>
        <li><a href="quiz">Take Quiz</a></li>
        <li><a href="viewGradesStudent">View Grades</a></li>
        <li><a class="active" href="logout">Logout</a></li>
    </ul>
</c:if>

<br>
<br>

    <h3>Student Grades</h3>
    <h4>Grade on previous quiz: ${score}/${questions.size()}</h4>

</body>
</html>
