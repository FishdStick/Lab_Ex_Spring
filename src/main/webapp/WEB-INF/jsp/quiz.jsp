<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quiz</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>

<form action="submitQuiz" method="post">
    <c:forEach var="question" items="${questions}">
        <h3>${question.questionText}</h3>
        <c:forEach var="choice" items="${question.choices}">
            <div class="choice">
                <input type="radio" id="${question.questionText}" name="${question.questionText}" value="${choice}" />
                <label for="${question.questionText}">${choice}</label>
            </div>
        </c:forEach>
        <br/>
    </c:forEach>
    <input type="submit" value="Submit Answers"/>
</form>

</body>
</html>
