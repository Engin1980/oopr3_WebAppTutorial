package cz.osu.books.db;

public class DbException extends RuntimeException {
    public DbException(String message, Throwable cause) {
        super("DAO operation error. " + message, cause);
    }
}
