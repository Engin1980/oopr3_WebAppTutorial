package cz.osu.books.servlets;

import cz.osu.books.app.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addBookServlet", urlPatterns = {"/addBook"})
public class AddBook extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String author = req.getParameter("author");
        String title = req.getParameter("title");

        BookService bookService = new BookService();
        bookService.create(title, author, 2);

        resp.sendRedirect("index.jsp");
    }
}
