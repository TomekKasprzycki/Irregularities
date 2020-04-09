<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wprowadź nową nieprawidłowość</title>
</head>
<body>
<div>
    <div>
        <h3>Wprowaadzanie nowej nieprawidłowości.</h3>
        <p>Dane wprowadza: ${userDto.firstName} ${userDto.lastName}.</p>
        <p>Instytucja: ${userDto.institutionDto.name}</p>
    </div>
    <form method="post" action="${pageContext.request.contextPath}/main/new_irregularity">
        <div>
            <p><label for="nip">Podaj NIP beneficjenta: </label>
                <input type="text" id="nip" name="nip"></p>
            <button id="findNip" type="button">Szukaj</button>
            <p>Beneficjent: </p>
            <label for="pr-id">Wybierz beneficjenta: </label>
            <select id="pr-id" name="beneficiaryId" >
                <option class="beneficiary" value="${null}">-- wybierz beneficjenta --</option>
                <option class="beneficiary" value="${beneficiaryDto.id}">${beneficiaryDto.name}</option>
            </select>
        </div>
        <div>
            <label for="projectSelect">Wybierz WNP: </label>
            <select id="projectSelect" name="projectId" >
                <option class="project" value="${null}">-- wybierz projekt --</option>
                <option class="project" value="${projectDto.id}">${projectDto.projectNumber}</option>
            </select>
        </div>
        <div>
            <label for="irregularityType">Wybierz rodzaj nieprawidłowości: </label>
            <select id="irregularityType" name="irregularityTypes" multiple="multiple">
                <c:forEach items="${irregularityTypesDtoList}" var="irregularityTypeDto">
                    <option value="${irregularityTypeDto.id}">${irregularityTypeDto.name}</option>
                </c:forEach>
            </select>
        </div>
        <div>
            <label for="documentBaseIrregularity">Podaj postawę nieprawidłowoci: </label>
            <select id="documentBaseIrregularity" name="documentBaseIrregularityId">
                <c:forEach items="${documentBaseIrregularityDtoList}" var="documentBaseIrregularityDto">
                    <option value="${documentBaseIrregularityDto.id}">${documentBaseIrregularityDto.name}</option>
                </c:forEach>
            </select>
        </div>
        <div>
            <p>Dane nieprawidłowości:</p>
            <p><label>Opis nieprawidłowości: <input id="description" type="text" name="description"></label></p>
            <p><label>Numer kontroli: <input id="controlReferenceNumber" type="text" name="controlReferenceNumber"></label></p>
            <p><label>Numer kontraktu: <input id="contractReferenceNumber" type="text" name="contractReferenceNumber"></label></p>
            <p><label>Kwota ogółem: <input type="text" name="totalExpenses" id="totalExpenses"></label></p>
            <p><label>Kwota wydatków kwalifikowalnych: <input type="text" name="qualifiedExpenses" id="qualifiedExpenses"></label></p>
            <p><label>Uwagi: <input type="text" name="notes" id="notes"></label></p>
            <p><label for="dateOfIrregularity">Podaj datę nieprawidłowości: </label><input type="date" name="dateOfIrregularity" id="dateOfIrregularity"></p>
            <button id="saveIrregularity">Zapisz</button>
            <%--            <input type="submit" value="Zapisz">--%>
        </div>
        <%-- TODO --%>
    </form>
</div>

    <script
            src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
            crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/js/newIrregularity.js" type="text/javascript"></script>
</body>
</html>
