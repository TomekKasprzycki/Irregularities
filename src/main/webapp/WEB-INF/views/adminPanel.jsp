<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin panel </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminPanel.css">
</head>
<body>
    <div>
        <p>Lista aktywnych użytkowników:</p>
        <table>
            <thead>
                <th>
                        <tr>
                            <td class="lp">LP</td>
                            <td class="user_name">Imię i nazwisko</td>
                            <td class="role">Rola</td>
                            <td class="institution">Instytucja</td>
                            <td class="email">email</td>
                            <td class="dez">Dezaktywuj</td>
                            <td class="delete">Usuń</td>
                        </tr>
                </th>
            </thead>
            <tbody>
                    <c:forEach var="activeUser" items="${activeUsers}" varStatus="lp">
                        <tr>
                            <td class="lp">${lp.index+1}</td>
                            <td class="user_name">${activeUser.firstName} ${activeUser.lastName}</td>
                            <td class="role">${activeUser.roleDto.name}</td>
                            <td class="institution">${activeUser.institutionDto.name}</td>
                            <td class="email">${activeUser.email}</td>
                            <td class="dez"><a href="/admin/deactivate/${activeUser.id}"><img src="/pictures/deactivateUserIcon.png"></a></td>
                            <td class="delete"><a href=""><img src="/pictures/deleteUserIcon.png"></a></td>
                        </tr>
                    </c:forEach>
            </tbody>
        </table>
    </div>

    <div>
        <p>Lista nieaktywnych użytkowników:</p>
        <table>
            <thead>
            <th>
                    <tr>
                        <td class="lp">LP</td>
                        <td class="user_name">Imię i nazwisko</td>
                        <td class="role">Rola</td>
                        <td class="institution">Instytucja</td>
                        <td class="email">email</td>
                        <td class="dez">Aktywuj</td>
                        <td class="chRole">Zmień rolę</td>
                        <td class="delete">Usuń</td>
                    </tr>
            </th>
            </thead>
            <tbody>
            <c:forEach var="unActiveUser" items="${unActiveUsers}" varStatus="lp">
                <tr>
                    <td class="lp">${lp.index+1}</td>
                    <td class="user_name">${unActiveUser.firstName} ${unActiveUser.lastName}</td>
                    <td class="role">${unActiveUser.roleDto.name}</td>
                    <td class="institution">${unActiveUser.institutionDto.name}</td>
                    <td class="email">${unActiveUser.email}</td>
                    <td class="dez"><a href="${pageContext.request.contextPath}/admin/activate/${unActiveUser.id}"><img src="/pictures/activateUserIcon.png"></a></td>
                    <td class="chRole"><a href=""><img src="/pictures/changeRoleIcon.png"></a></td>
                    <td class="delete"><a href=""><img src="/pictures/deleteUserIcon.png"></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
