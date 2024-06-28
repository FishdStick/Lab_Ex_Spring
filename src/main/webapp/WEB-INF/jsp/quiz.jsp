<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Quiz</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>

<c:if test="${not empty questions}">
    <form action="submitQuiz" method="post">
        <c:forEach var="question" items="${questions}" varStatus="status">
            <div>
                <h3>Question ${status.index + 1}: ${question.text}</h3>
                <c:forEach var="answer" items="${question.answers}">
                    <div>
                        <input type="radio" name="question${status.index}" value="${answer}">
                        <label>${answer}</label>
                    </div>
                </c:forEach>
            </div>
        </c:forEach>
        <input type="submit" value="Submit Quiz">
    </form>
</c:if>

<c:if test="${empty questions}">
    <p>No questions available.</p>
</c:if>

</body>
</html>
