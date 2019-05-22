<%--
  Created by IntelliJ IDEA.
  User: akono
  Date: 5/18/2019
  Time: 7:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>

<form>
    <table id="customers">
        <tr>
            <th>Наименование</th>
            <th>Необходимость</th>
            <th>Колличество</th>
            <th></th>
        </tr>
        <c:forEach var="part" items="${partsList}">
            <tr>
                <td>${part.name}</td>

                <td><c:choose>
                    <c:when test="${part.importance==true}">
                        Да
                        <br />
                    </c:when>
                    <c:otherwise>
                        Нет
                        <br />
                    </c:otherwise>
                </c:choose></td>
                <td>${part.count}</td>
                <td><a href="/edit/${part.id}">edit</a>
                    <a href="/delete/${part.id}">delete</a>
                </td>

            </tr>
        </c:forEach>
    </table>
</form>
<br>
<button type="button" name="back" class ="button" onclick="history.back()">Go back</button>
</body>
</html>
