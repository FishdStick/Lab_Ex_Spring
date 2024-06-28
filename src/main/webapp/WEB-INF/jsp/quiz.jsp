<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
    <title>Quiz</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>

<form action="submitQuiz" method="post">
    <c:forEach var="question" items="${questions}" varStatus="status">
        <h3>${question.getQuestion()}</h3>
        <c:forEach var="choice" items="${question.getChoices()}">
            <div class="choice">
                <input type="radio" id="${question.getQuestion()}_${status.index}" name="answers[${question.getQuestion()}]" value="${choice}" />
                <label for="${question.getQuestion()}_${status.index}">${choice}</label>
            </div>
        </c:forEach>
        <input type="hidden" name="questions[${status.index}]" value="${question.getQuestion()}" />
        <br/>
    </c:forEach>
    <input type="submit" value="Submit Answers"/>
</form>

</body>
</html>
