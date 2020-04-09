<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Przegląd nieprawidłowości</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css"/>
</head>
<body>
    <div>

    </div>
    <div>
        <div class="leftDiv">
            <p><strong>Dane beneficjenta:</strong></p>
            <p>Nazwa : ${beneficiaryDto.name}</p>
            <p>NIP: ${beneficiaryDto.nip}</p>
        </div>
        <div class="leftDiv">
            <p>Dane projektu:</p>
            <p>Numer projektu: ${projectDto.projectNumber}</p>
            <c:if test="${paymentRequestDtoList.size()>1}"><p>Numery wniosków: </p></c:if>
            <c:if test="${paymentRequestDtoList.size()==1}"><p>Numer wniosku: </p></c:if>
            <c:forEach items="${paymentRequestDtoList}" var="paymentRequest" varStatus="lp">
                <p>${lp.index+1}. ${paymentRequest.paymentRequestNumber}</p>
            </c:forEach>
            <p>Dane zgłoszonej nieprawidłowości: </p>
            <p>Osoba zgłaszająca: ${userDto.firstName} ${userDto.lastName}</p>
            <p>Data utworzenia sprawy: ${irregularity.created}</p>
            <p>Zgłoszono na podstawie: ${documentBaseIrregularityDto.name} </p>
            <p>Rodzaj zgłoszonej nieprawidłowości: </p>
            <c:forEach items="${irregularityTypesListDto}" var="type" varStatus="lp">
                <p>${lp.index+1}. ${type.name}</p>
            </c:forEach>
        </div>
        <div class="leftDiv">
            <p>Opis nieprawidłowości: ${irregularity.description}</p>
            <p>Wartość ogółem: ${irregularity.totalExpenses}</p>
            <p>Wartość wydatków kwalifikowalnych: ${irregularity.qualifiedExpenses}</p>
            <p>Do uzupełnienia</p><%--TODO--%>
        </div>
    </div>

    <div>Strona ${x} z ${y}</div>
    <div>
        <a id="previous"  href="/main/irregularity_preview/${x-1}/0">Poprzedni</a>
        <a id="next" href="/main/irregularity_preview/${x+1}/0">Następny</a>
    </div>
    <div>
        <a href="/main/mainPage">Powrót do strony głównej</a>
    </div>

</body>
</html>
