<%@ page import="cz.osu.books.db.entities.BookEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="cz.osu.books.app.BookService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
    <%
        BookService bookService = new BookService();
        List<BookEntity> books = bookService.getAll();
    %>
    Knih: <%= books.size() %>.
</body>
</html>
