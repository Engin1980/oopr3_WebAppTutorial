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
        if (title == null || title.trim().length() == 0)
            throw new IllegalArgumentException("Title cannot be null or empty.");
        if (author == null || author.trim().length() == 0)
            throw new IllegalArgumentException("Author cannot be null.");
        if (rating < 0 || rating > 10)
            throw new IllegalArgumentException("Rating must be between 0 and 10.");
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
