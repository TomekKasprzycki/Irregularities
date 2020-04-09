<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Rejestracja użytkownika</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css"/>
</head>
<body>
    <div>
        <p>Rejestracja użytkowników</p>
    </div>
    <c:if test="${error.value!=null}">${error.value}</c:if>
    <div>
        <form:form method="post" modelAttribute="userDto">
            <p>Podaj imię: <form:input path="firstName"/></p>
            <p>Podaj nazwisko: <form:input path="lastName"/></p>
            <p>Podaj email: <form:input path="email"/></p>
            <p>Podaj hasło: <form:password id="pass1" path="password"/></p>
            <p>Powtórz hasło: <form:password id="pass2" path="password2"/></p>
            <p>Podaj imię: <form:select itemValue="id" itemLabel="name" items="${institutionDtoList}" path="institutionDto"/></p>
            <p><form:button id="registrationButton">Zarejestruj</form:button></p>
        </form:form>
    </div>
</body>
<script src="${pageContext.request.contextPath}/js/registration.js" type="text/javascript"></script>
</html>
