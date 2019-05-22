<%--
  Created by IntelliJ IDEA.
  User: akono
  Date: 5/13/2019
  Time: 12:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Parts-list</title>
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<c:url value="/" var="all"><c:param name="selectorList" value="${1}"/></c:url>
<c:url value="/" var="yes"><c:param name="selectorList" value="${2}"/></c:url>
<c:url value="/" var="no"><c:param name="selectorList" value="${3}"/></c:url>
    <div>
        <c:url value="/search" var="searchAction" />
        <form:form action="${searchAction}" method="POST">
            <table id="customers">
                <tr>
                    <td>Поиск: <input size="50" type="text" name="name"/> <input type="submit" class="button" value="Поиск"/></td>
                    <td></td>
                    <td> <c:url value="/add" var="add"/><a href="${add}">Добавить</a></td>
                </tr>
            </table>
        </form:form>
    </div>
    <table id="customers">
        <c:if test="${partsCount > 0}">
            <tr method="GET">
                <th><form:form action="${all}"><input type="submit" name="Enter1" class ="button2" value="Все товары"/></form:form></th>
                <th><form:form action="${yes}" style="float: left;"><input type="submit" name="Enter2" class ="button2" value="Необходимые"/></form:form>
                    <form:form action="${no}"><input type="submit" name="Enter3" class ="button2" value="Опциональные"/></form:form></th>
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
        </c:if>
            <tr>
                <th>Можно собрать</th>
                <th> ${compsCount}</th>
                <th>компьютеров</th>
                <th></th>
            </tr>
        <tr>
            <td colspan="7" class="left-side link right-side">

                <c:if test="${pagesCount > 1}">
                    <c:set value="disabled" var="disabled"/>
                    <c:set value="" var="active"/>
                    <c:url value="/" var="url">
                        <c:param name="page" value="1"/>
                    </c:url>
                    <a class="${page == 1 ? disabled : active}" href="${url}">
                        &nbsp<span class="icon icon-first"></span>&nbsp
                    </a>
                    <c:url value="/" var="url">
                        <c:param name="page" value="${page - 1}"/>
                    </c:url>
                    <a class="${page == 1 ? disabled : active}" href="${url}">
                        &nbsp<span class="icon icon-prev"></span>&nbsp
                    </a>

                    <c:if test="${pagesCount <= 5}">
                        <c:set var="begin" value="1"/>
                        <c:set var="end" value="${pagesCount}"/>
                    </c:if>
                    <c:if test="${pagesCount > 5}">
                        <c:choose>
                            <c:when test="${page < 3}">
                                <c:set var="begin" value="1"/>
                                <c:set var="end" value="5"/>
                            </c:when>
                            <c:when test="${page > pagesCount - 2}">
                                <c:set var="begin" value="${pagesCount - 4}"/>
                                <c:set var="end" value="${pagesCount}"/>
                            </c:when>
                            <c:otherwise>
                                <c:set var="begin" value="${page - 2}"/>
                                <c:set var="end" value="${page + 2}"/>
                            </c:otherwise>
                        </c:choose>
                    </c:if>

                    <c:forEach begin="${begin}" end="${end}" step="1" varStatus="i">
                        <c:url value="/" var="url">
                            <c:param name="page" value="${i.index}"/>
                        </c:url>
                        <c:set value="current-page" var="current"/>
                        <c:set value="" var="perspective"/>
                        <a class="${page == i.index ? current : perspective}" href="${url}">${i.index}</a>
                    </c:forEach>

                    <c:url value="/" var="url">
                        <c:param name="page" value="${page + 1}"/>
                    </c:url>
                    <a class="${page == pagesCount ? disabled : active}" href="${url}">
                        &nbsp<span class="icon icon-next"></span>&nbsp
                    </a>
                    <c:url value="/" var="url">
                        <c:param name="page" value="${pagesCount}"/>
                    </c:url>
                    <a class="${page == pagesCount ? disabled : active}" href="${url}">
                        &nbsp<span class="icon icon-last"></span>&nbsp
                    </a>
                </c:if>
            </td>
        </tr>

    </table>


</body>
</html>
