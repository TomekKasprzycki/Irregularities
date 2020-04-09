<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css"/>
</head>
<body>
    <div>
        <div><h2>Logowanie do bazy nieprawidłowości</h2></div>
    </div>
    <div>
        <form method="post" action="login">
            <p>
                Login: <input type="text" name="email" placeholder="Podaj swój email"/>
            </p>
            <p>
                Hasło: <input type="password" name="password" />
            </p>
            <p>
                <input type="submit" name="Zaloguj">
            </p>
            <p>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </p>
        </form>
    </div>
    <div>
        <p id="logRej"><a href="/registration">Nie mam konta, chcę się zarejestrować</a></p>
    </div>
    <iframe src="https://giphy.com/embed/27EhcDHnlkw1O" width="480" height="381" frameBorder="0" class="giphy-embed" allowFullScreen></iframe><p><a href="https://giphy.com/gifs/facepalm-mega-27EhcDHnlkw1O">via GIPHY</a></p>
</body>
</html>
