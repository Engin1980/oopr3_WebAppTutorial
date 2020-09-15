package cz.osu.books.servlets;

import cz.osu.books.app.BookService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteBook", urlPatterns = {"/deleteBook"})
public class DeleteBook extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String bookIdString = req.getParameter("bookId");
        int bookId = Integer.parseInt(bookIdString);

        BookService bookService = new BookService();
        bookService.delete(bookId);

        resp.sendRedirect("index.jsp");
    }
}
