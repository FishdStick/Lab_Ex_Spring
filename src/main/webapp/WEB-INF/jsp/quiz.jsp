<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Quiz</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>

<form action="/submitQuiz" method="post">
    <div th:each="question, stat : ${questions}">
        <p th:text="${#numbers.formatInteger(stat.index + 1)} + '. ' + ${question.text}"></p>
        <ul>
            <li th:each="option : ${question.options}">
                <input type="radio" th:name="'answers[' + ${stat.index} + ']'" th:value="${option}"> <span th:text="${option}"></span><br>
            </li>
        </ul>
    </div>
    <button type="submit">Submit</button>
</form>

</body>
</html>
