package cz.osu.books.db;

import cz.osu.books.db.entities.BookEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class BookDAO {
    //region Initialization
    private static final String PERSISTENCE_UNIT_NAME = "BooksPU";
    private static EntityManagerFactory emf = null;
    private EntityManager em = null;

    private EntityManager getEm(){
        if (emf == null) initEmf();
        if (em == null) initEm();
        return em;
    }

    private void initEmf(){
        try {
            emf = javax.persistence.Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        } catch (Exception e) {
            throw new DbException(
                    "Failed to initialize EntityManagerFactory.", e);
        }
    }

    private void initEm(){
        try {
            this.em = emf.createEntityManager();
        } catch (Exception e) {
            throw new DbException(
                    "Failed to initialize EntityManager.", e);
        }
    }
    //endregion

    public void insert(BookEntity book) { }

    public void delete(int bookId) { }

    public List<BookEntity> getAll(int maxCount) { }
}
