package cz.osu.books.db.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "BOOK", schema = "SA", catalog = "")
public class BookEntity {
    private int bookid;
    private String title;
    private String author;
    private double rating;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // <== tento řádek
    @Column(name = "BOOKID")
    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    @Basic
    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "AUTHOR")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "RATING")
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return bookid == that.bookid &&
                Double.compare(that.rating, rating) == 0 &&
                Objects.equals(title, that.title) &&
                Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookid, title, author, rating);
    }
}
