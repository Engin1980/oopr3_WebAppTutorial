package cz.osu.books.app;

import cz.osu.books.db.BookDAO;
import cz.osu.books.db.entities.BookEntity;

import java.util.List;

public class BookService {

    private final BookDAO dao;

    public BookService() {
        this.dao = new BookDAO();
    }

    public BookEntity create(String title, String author, double rating) {
        BookEntity book = new BookEntity();
        book.setTitle(title);
        book.setAuthor(author);
        book.setRating(rating);

        this.dao.insert(book);

        return book;
    }

    public void delete(int bookId) {
        this.dao.delete(bookId);
    }

    public List<BookEntity> getAll() {
        List<BookEntity> ret = this.dao.getAll();
        return ret;
    }
}
