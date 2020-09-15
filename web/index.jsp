<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="bookService" class="cz.osu.books.app.BookService" scope="request"/>
<html>
<head>
    <title>Přehled knih</title>
    <link type="text/css" rel="stylesheet" href="resources/books.css">
</head>
<body>
<table>
    <tr>
        <th>Název knihy</th>
        <th>Autor knihy</th>
        <th>Hodnocení</th>
    </tr>
    <c:forEach var="book" items="${bookService.all}">
        <tr>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>
                <c:forEach var="i" begin="0" end="10" step="1">
                    <c:choose>
                        <c:when test="${i <= book.rating}">
                            <div class="rating ratingOn"></div>
                        </c:when>
                        <c:otherwise>
                            <div class="rating ratingOff"></div>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </td>
            <td>
                <form method="post" action="deleteBook">
                    <input type="hidden" name="bookId" value="${book.bookid}"/>
                    <button type="submit">(Smazat)</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<h3>Přidání nové knihy</h3>
<form method="post" action="addBook">
    <label for="title">Název: </label>
    <input name="title" id="title" type="text" maxlength="64"/>
    <br/>
    <label for="author">Autor: </label>
    <input name="author" id="author" type="text" maxlength="256"/>
    <br/>
    <button type="submit">Uložit novou knihu</button>
</form>
</body>
</html>
