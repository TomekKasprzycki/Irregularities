<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<header>
    <div>
        <p>Baza nieprawidłowości wersja 0.1.1.1</p>
        <form action="<c:url value="/logout"/>" method="post">
            <input class="fa fa-id-badge" type="submit" value="Wyloguj">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </div>
</header>