<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
    <title>Grades</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>

<h1>Your Score</h1>
<p>You scored <span>${score}</span> out of <span>${questions.size()}</span>.</p>
<a href="quiz">Take Quiz Again</a>

</body>
</html>
