<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Strona główna</title>
</head>
<body>
    <div>
        <c:out value="${userName}"/>
    </div>
    <span>
        Poniżej linki do podstron:
    </span>
    <div>
        <p><a href="/main/new_irregularity" >Wprowadź nową nieprawidłowość</a></p>
        <p><a href="/main/irregularity_preview/1/0" >Przeglądaj zgłoszone nieprawidłowości</a></p>
        <p><a href="/admin/userPreview" >Admin</a></p>
    </div>
</body>
</html>
