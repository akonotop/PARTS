<%--
  Created by IntelliJ IDEA.
  User: akono
  Date: 5/14/2019
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet" type="text/css"/>

    <c:if test="${empty part.name}">
        <title>Add</title>
    </c:if>
    <c:if test="${!empty part.name}">
        <title>Edit</title>
    </c:if>
</head>
<body>
<c:if test="${empty part.name}">
    <c:url value="/add" var="var"/>
</c:if>
<c:if test="${!empty part.name}">
    <c:url value="/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${!empty part.name}">
        <input type="hidden" name="id" value="${part.id}" />
    </c:if>
    <table id="customers">
        <tr>
            <th>Наименование</th>
            <th>Необходимость</th>
            <th>Колличество</th>
            <th></th>
        </tr>
        <tr>
            <td><input type="text" name="name" id="name" value="${part.name}" /></td>
            <td><select name="importance">
                    <c:choose>
                        <c:when test="${part.importance}">
                            <option value="true" label="importance" >Да</option>
                            <option value="false" label="importance">Нет</option>
                        </c:when>
                        <c:otherwise>
                            <option value="true" label="importance">Да</option>
                            <option value="false" label="importance">Нет</option>
                        </c:otherwise>
                    </c:choose>
                </select>
            </td>
            <td><input type="number" name="count" id="count"  value="${part.count}" /></td>
            <td> <c:if test="${empty part.name}">
                <input type="submit" value="Add new part" />
                </c:if>
                <c:if test="${!empty part.name}">
                    <input type="submit" value="Edit part" />
                </c:if>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
